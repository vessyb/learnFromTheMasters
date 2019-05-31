package com.company.petclinic.web.screens.consumable;

import com.haulmont.cuba.gui.screen.*;
import com.company.petclinic.entity.Consumable;

@UiController("petclinic_Consumable.edit")
@UiDescriptor("consumable-edit.xml")
@EditedEntityContainer("consumableDc")
@LoadDataBeforeShow
public class ConsumableEdit extends StandardEditor<Consumable> {
}