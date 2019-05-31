package com.company.petclinic.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@NamePattern("%s|title")
@Table(name = "PETCLINIC_CONSUMABLE")
@Entity(name = "petclinic_Consumable")
public class Consumable extends StandardEntity {
    private static final long serialVersionUID = -5164719868869741583L;

    @NotNull
    @Column(name = "TITLE", nullable = false)
    protected String title;

    @NotNull
    @Column(name = "DESCRIPTION", nullable = false)
    protected String description;

    @NotNull
    @Column(name = "PRICE", nullable = false)
    protected BigDecimal price;
    @JoinTable(name = "PETCLINIC_VISIT_CONSUMABLE_LINK",
            joinColumns = @JoinColumn(name = "CONSUMABLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "VISIT_ID"))
    @ManyToMany
    protected List<Visit> visits;

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}