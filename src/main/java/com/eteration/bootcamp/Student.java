package com.eteration.bootcamp;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Student extends PanacheEntity {
    public String name;
    public int no;
    public boolean status;
}