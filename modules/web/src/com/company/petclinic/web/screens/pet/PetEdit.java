package com.company.petclinic.web.screens.pet;

import com.haulmont.cuba.gui.screen.*;
import com.company.petclinic.entity.Pet;

@UiController("petclinic_Pet.edit")
@UiDescriptor("pet-edit.xml")
@EditedEntityContainer("petDc")
@LoadDataBeforeShow
public class PetEdit extends StandardEditor<Pet> {
}