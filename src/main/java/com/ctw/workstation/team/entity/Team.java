package com.ctw.workstation.team.entity;


import com.ctw.workstation.shared.entity.AbstractTimeEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "T_TEAM")
public class Team extends AbstractTimeEntity {

    @Column(name = "NAME", length = 50, nullable = false)
    public String name;

    @Column(name = "PRODUCT", length = 100)
    public String product;

    @Column(name = "DEFAULT_LOCATION", nullable = false)
    public String default_location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDefault_location() {
        return default_location;
    }

    public void setDefault_location(String default_location) {
        this.default_location = default_location;
    }
}