package com.nouhoun.springboot.jwt.integration.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by mshah on 02/19/20.
 */
@Entity
@Table(name = "system.properties_rtab")
public class SystemProperty {
    @Column(name = "value")
    private String value;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
