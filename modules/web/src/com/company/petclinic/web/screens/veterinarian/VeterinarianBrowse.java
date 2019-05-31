package com.company.petclinic.web.screens.veterinarian;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import com.company.petclinic.entity.Veterinarian;
import com.haulmont.reports.gui.actions.RunReportAction;

import javax.inject.Inject;

@UiController("petclinic_Veterinarian.browse")
@UiDescriptor("veterinarian-browse.xml")
@LookupComponent("veterinariansTable")
@LoadDataBeforeShow
public class VeterinarianBrowse extends StandardLookup<Veterinarian> {

    @Inject
    private Button showPriceListBtn;

    @Subscribe
    private void onInit(InitEvent event) {
        showPriceListBtn.setAction(new RunReportAction());
    }
}