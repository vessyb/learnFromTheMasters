package com.company.petclinic.web.screens.pettype;

import com.haulmont.cuba.gui.screen.*;
import com.company.petclinic.entity.PetType;

@UiController("petclinic_PetType.browse")
@UiDescriptor("pet-type-browse.xml")
@LookupComponent("petTypesTable")
@LoadDataBeforeShow
public class PetTypeBrowse extends StandardLookup<PetType> {
}