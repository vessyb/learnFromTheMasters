package com.company.petclinic.web.screens.pet;

import com.haulmont.cuba.gui.screen.*;
import com.company.petclinic.entity.Pet;

@UiController("petclinic_Pet.browse")
@UiDescriptor("pet-browse.xml")
@LookupComponent("petsTable")
@LoadDataBeforeShow
public class PetBrowse extends StandardLookup<Pet> {
}