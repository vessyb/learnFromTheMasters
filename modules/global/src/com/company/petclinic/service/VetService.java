package com.company.petclinic.service;

import com.company.petclinic.entity.Veterinarian;
import com.haulmont.cuba.security.entity.User;

public interface VetService {
    String NAME = "petclinic_VetService";

    Veterinarian getVetByUser(User user);
}