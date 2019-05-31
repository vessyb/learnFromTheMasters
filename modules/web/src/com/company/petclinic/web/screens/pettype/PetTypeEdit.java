package com.company.petclinic.web.screens.pettype;

import com.haulmont.cuba.gui.screen.*;
import com.company.petclinic.entity.PetType;

@UiController("petclinic_PetType.edit")
@UiDescriptor("pet-type-edit.xml")
@EditedEntityContainer("petTypeDc")
@LoadDataBeforeShow
public class PetTypeEdit extends StandardEditor<PetType> {
}