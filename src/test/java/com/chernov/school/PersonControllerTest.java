package com.chernov.school;

import com.chernov.school.person.PersonController;
import com.chernov.school.person.vo.PersonRequestVO;
import com.chernov.school.person.vo.PersonResponseVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PersonControllerTest
{

    @Autowired
    private PersonController personController;

    @Test
    void testCreateAndGet()
    {
        PersonRequestVO person = new PersonRequestVO();
        person.setName( "John" );
        person.setSurname( "Dow" );
        person.setAge( 20 );

        PersonResponseVO responseVO = personController.create( person );

        Assertions.assertEquals( person.getName(), responseVO.getName() );
        Assertions.assertEquals( person.getSurname(), responseVO.getSurname() );
        Assertions.assertEquals( person.getAge(), responseVO.getAge() );

        PersonResponseVO loaded = personController.getById( responseVO.getId() );

        Assertions.assertEquals( responseVO.getId(), loaded.getId() );
        Assertions.assertEquals( person.getName(), loaded.getName() );
        Assertions.assertEquals( person.getSurname(), loaded.getSurname() );
        Assertions.assertEquals( person.getAge(), loaded.getAge() );
    }

    @Test
    void testGetAll()
    {
        PersonRequestVO person = new PersonRequestVO();
        person.setName( "John" );
        person.setSurname( "Dow" );
        person.setAge( 20 );

        personController.create( person );

        PersonRequestVO person2 = new PersonRequestVO();
        person2.setName( "Ann" );
        person2.setSurname( "Smith" );
        person2.setAge( 34 );

        personController.create( person2 );

        List<PersonResponseVO> persons = personController.getAll();

        Assertions.assertEquals( persons.size(), 2 );
    }

}
