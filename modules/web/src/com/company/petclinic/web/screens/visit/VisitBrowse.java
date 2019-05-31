package com.company.petclinic.web.screens.visit;

import com.haulmont.cuba.gui.screen.*;
import com.company.petclinic.entity.Visit;

@UiController("petclinic_Visit.browse")
@UiDescriptor("visit-browse.xml")
@LookupComponent("visitsTable")
@LoadDataBeforeShow
public class VisitBrowse extends StandardLookup<Visit> {
}