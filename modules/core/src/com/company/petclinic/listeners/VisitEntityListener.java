package com.company.petclinic.listeners;

import com.company.petclinic.entity.Visit;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.app.UniqueNumbersService;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.UUID;

@Component("petclinic_VisitEntityListener")
public class VisitEntityListener implements BeforeInsertEntityListener<Visit> {

    @Inject
    private UniqueNumbersService uniqueNumbersService;

    @Override
    public void onBeforeInsert(Visit entity, EntityManager entityManager) {
        long visitNumber = uniqueNumbersService.getNextNumber(entity.getVet().getUser().getLogin());
        entity.setNumber(String.format("%d-%tD", visitNumber, entity.getDate()));
    }
}