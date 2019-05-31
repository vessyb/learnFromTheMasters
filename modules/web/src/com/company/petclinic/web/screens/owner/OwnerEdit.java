package com.company.petclinic.web.screens.owner;

import com.haulmont.cuba.gui.screen.*;
import com.company.petclinic.entity.Owner;

@UiController("petclinic_Owner.edit")
@UiDescriptor("owner-edit.xml")
@EditedEntityContainer("ownerDc")
@LoadDataBeforeShow
public class OwnerEdit extends StandardEditor<Owner> {
}