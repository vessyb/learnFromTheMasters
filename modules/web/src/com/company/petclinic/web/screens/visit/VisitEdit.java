package com.company.petclinic.web.screens.visit;

import com.company.petclinic.entity.Consumable;
import com.company.petclinic.service.VetService;
import com.company.petclinic.service.VisitService;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.CollectionChangeType;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.petclinic.entity.Visit;
import com.haulmont.cuba.security.global.UserSession;
import com.haulmont.reports.gui.actions.EditorPrintFormAction;

import javax.inject.Inject;
import java.math.BigDecimal;

@UiController("petclinic_Visit.edit")
@UiDescriptor("visit-edit.xml")
@EditedEntityContainer("visitDc")
@LoadDataBeforeShow
public class VisitEdit extends StandardEditor<Visit> {

    @Inject
    private UserSession userSession;
    @Inject
    private VetService vetService;
    @Inject
    private VisitService visitService;
    @Inject
    private Button printInvoice;

    @Subscribe
    private void onInit(InitEvent event) {
        printInvoice.setAction(new EditorPrintFormAction(this, null));
    }

    @Subscribe
    private void onInitEntity(InitEntityEvent<Visit> event) {
        event.getEntity().setVet(vetService.getVetByUser(userSession.getUser()));
    }

    @Subscribe(id = "visitDc", target = Target.DATA_CONTAINER)
    private void onVisitDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<Visit> event) {
        if ("hours".equals(event.getProperty())) {
            BigDecimal amount = visitService.calculateAmount(getEditedEntity());
            getEditedEntity().setAmount(amount);
        }

    }

    @Subscribe(id = "consumablesDc", target = Target.DATA_CONTAINER)
    private void onConsumablesDcCollectionChange(CollectionContainer.CollectionChangeEvent<Consumable> event) {
        if (event.getChangeType() != CollectionChangeType.REFRESH) {
            BigDecimal amount = visitService.calculateAmount(getEditedEntity());
            getEditedEntity().setAmount(amount);
        }
    }

}