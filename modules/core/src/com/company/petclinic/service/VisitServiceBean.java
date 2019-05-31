package com.company.petclinic.service;

import com.company.petclinic.entity.Consumable;
import com.company.petclinic.entity.Visit;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service(VisitService.NAME)
public class VisitServiceBean implements VisitService {

    @Override
    public BigDecimal calculateAmount(Visit visit) {
        BigDecimal vetRate = visit.getVet().getHourlyRate();
        BigDecimal amount = vetRate.multiply(BigDecimal.valueOf(visit.getHours()));

        if (visit.getConsumables() != null) {
            for (Consumable consumable : visit.getConsumables()) {
                amount = amount.add(consumable.getPrice());
            }
        }
        return amount;
    }
}