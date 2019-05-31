package com.company.petclinic.web.screens.veterinarian;

import com.haulmont.cuba.gui.screen.*;
import com.company.petclinic.entity.Veterinarian;

@UiController("petclinic_Veterinarian.edit")
@UiDescriptor("veterinarian-edit.xml")
@EditedEntityContainer("veterinarianDc")
@LoadDataBeforeShow
public class VeterinarianEdit extends StandardEditor<Veterinarian> {
}