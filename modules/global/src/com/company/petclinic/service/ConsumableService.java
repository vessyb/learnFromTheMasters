package com.company.petclinic.service;

import com.company.petclinic.entity.Consumable;

import java.util.List;

public interface ConsumableService {
    String NAME = "petclinic_ConsumableService";

    List<Consumable> getUsedConsumables();
}