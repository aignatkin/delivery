package ru.aignatkin.delivery.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
    @Id
    private String id;
}
