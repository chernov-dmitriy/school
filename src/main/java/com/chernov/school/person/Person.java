package com.chernov.school.person;

import jakarta.persistence.*;

@Entity
@Table( name = "person" )
public class Person
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "per_id" )
    private Integer id;

    @Column( name = "per_name" )
    private String name;

    @Column( name = "per_surname" )
    private String surname;

    @Column( name = "per_age" )
    private Integer age;

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname( String surname )
    {
        this.surname = surname;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge( int age )
    {
        this.age = age;
    }
}
