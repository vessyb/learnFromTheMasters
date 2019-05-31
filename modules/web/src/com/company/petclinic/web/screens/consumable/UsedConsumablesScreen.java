package com.company.petclinic.web.screens.consumable;

import com.company.petclinic.entity.Consumable;
import com.company.petclinic.service.ConsumableService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.core.global.View;
import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.TextArea;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;
import java.util.List;

@UiController("petclinic_UsedConsumablesScreen")
@UiDescriptor("used-consumables-screen.xml")
public class UsedConsumablesScreen extends Screen {

    @Inject
    private ConsumableService consumableService;
    @Inject
    private CollectionContainer<Consumable> consumablesDc;
    @Inject
    private DataManager dataManager;

    @Subscribe
    private void onBeforeShowconsumablesDc(BeforeShowEvent event) {
        LoadContext<Consumable> loadContext = new LoadContext<>(Consumable.class);
        loadContext.setQuery(new LoadContext.Query("select distinct c from petclinic_Visit v join v.consumables c " +
                "where @between(c.createTs, now-7, now+1, day)")).setView(View.LOCAL);

        List<Consumable> consumables = dataManager.loadList(loadContext);
        consumablesDc.setItems(consumables);
        //consumablesDc.setItems(consumableService.getUsedConsumables());
    }


}