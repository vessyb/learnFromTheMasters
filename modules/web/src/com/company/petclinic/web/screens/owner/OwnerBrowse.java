package com.company.petclinic.web.screens.owner;

import com.haulmont.cuba.gui.screen.*;
import com.company.petclinic.entity.Owner;

@UiController("petclinic_Owner.browse")
@UiDescriptor("owner-browse.xml")
@LookupComponent("ownersTable")
@LoadDataBeforeShow
public class OwnerBrowse extends StandardLookup<Owner> {
}