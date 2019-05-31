package com.company.petclinic.service;

import com.company.petclinic.entity.Veterinarian;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FluentLoader;
import com.haulmont.cuba.security.entity.User;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service(VetService.NAME)
public class VetServiceBean implements VetService {

    @Inject
    private DataManager dataManager;

    @Override
    public Veterinarian getVetByUser(User user) {
        FluentLoader.ByQuery<Veterinarian, UUID> query = dataManager.load(Veterinarian.class)
                .view("veterinarian-edit")
                .query("select v from petclinic_Veterinarian v where v.user = :user");
        Map<String, Object> params = new HashMap<>();
        params.put("user", user);
        query.setParameters(params);

        return query.one();
    }
}