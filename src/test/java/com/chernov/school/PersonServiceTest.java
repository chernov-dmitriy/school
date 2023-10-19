package com.chernov.school;

import com.chernov.school.person.Person;
import com.chernov.school.person.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
class PersonServiceTest
{

    @Autowired
    private PersonService personService;

    @Test
    void save()
    {
        Person person = new Person();
        person.setId( UUID.randomUUID() );
        person.setName( "John" );
        person.setSurname( "Dow" );
        person.setAge( 20 );

        personService.save( person );

        Person person2 = new Person();
        person2.setId( UUID.randomUUID() );
        person2.setName( "Ann" );
        person2.setSurname( "Smith" );
        person2.setAge( 34 );

        personService.save( person2 );

        List<Person> persons = personService.getAll();

        Assertions.assertEquals( persons.size(), 2 );

        Person loaded = personService.findById( person.getId() ).get();

        Assertions.assertEquals( person.getId(), loaded.getId() );
        Assertions.assertEquals( person.getName(), loaded.getName() );
        Assertions.assertEquals( person.getSurname(), loaded.getSurname() );
        Assertions.assertEquals( person.getAge(), loaded.getAge() );
    }

}
