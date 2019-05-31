package com.company.petclinic.service;

import com.company.petclinic.entity.Visit;

import java.math.BigDecimal;

public interface VisitService {
    String NAME = "petclinic_VisitService";

    BigDecimal calculateAmount(Visit visit);
}