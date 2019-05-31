package com.company.petclinic.web.screens.consumable;

import com.haulmont.cuba.gui.screen.*;
import com.company.petclinic.entity.Consumable;

@UiController("petclinic_Consumable.browse")
@UiDescriptor("consumable-browse.xml")
@LookupComponent("consumablesTable")
@LoadDataBeforeShow
public class ConsumableBrowse extends StandardLookup<Consumable> {
}