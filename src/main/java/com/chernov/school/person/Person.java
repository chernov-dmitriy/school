package com.chernov.school.person;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table( name = "person" )
public class Person
{
    @Id
    @Column( name = "per_id" )
    private UUID id;

    @Column( name = "per_name" )
    private String name;

    @Column( name = "per_surname" )
    private String surname;

    @Column( name = "per_age" )
    private Integer age;
}
