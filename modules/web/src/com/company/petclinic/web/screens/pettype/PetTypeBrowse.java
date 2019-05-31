package com.company.petclinic.web.screens.pettype;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import com.company.petclinic.entity.PetType;
import com.haulmont.reports.gui.actions.TablePrintFormAction;

import javax.inject.Inject;

@UiController("petclinic_PetType.browse")
@UiDescriptor("pet-type-browse.xml")
@LookupComponent("petTypesTable")
@LoadDataBeforeShow
public class PetTypeBrowse extends StandardLookup<PetType> {

    @Inject
    private Button printTypes;
    @Inject
    private GroupTable<PetType> petTypesTable;

    @Subscribe
    private void onInit(InitEvent event) {
        printTypes.setAction(new TablePrintFormAction(petTypesTable));
    }
    
    
}