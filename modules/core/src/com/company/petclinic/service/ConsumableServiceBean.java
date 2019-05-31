package com.company.petclinic.service;

import com.company.petclinic.entity.Consumable;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.TypedQuery;
import com.haulmont.cuba.core.global.View;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Service(ConsumableService.NAME)
public class ConsumableServiceBean implements ConsumableService {

    @Inject
    private Persistence persistence;

    @Transactional
    @Override
    public List<Consumable> getUsedConsumables() {

        return persistence.callInTransaction(em -> {

            TypedQuery<Consumable> query = em.createQuery(
                    "select distinct c from petclinic_Visit v join v.consumables c " +
                            "where @between(c.createTs, now-7, now+1, day)",
                    Consumable.class);
            query.setViewName(View.LOCAL);

            List<Consumable> consumables = query.getResultList();
            return consumables;
        });
    }
}