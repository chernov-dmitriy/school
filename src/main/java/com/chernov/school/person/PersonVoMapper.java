package com.chernov.school.person;

import com.chernov.school.person.vo.PersonRequestVO;
import com.chernov.school.person.vo.PersonResponseVO;
import org.springframework.stereotype.Service;

@Service
public class PersonVoMapper
{
    public Person toEntity( PersonRequestVO vo )
    {
        Person entity = new Person();
        entity.setAge( vo.getAge() );
        entity.setName( vo.getName() );
        entity.setSurname( vo.getSurname() );
        return entity;
    }

    public PersonResponseVO toVO( Person entity )
    {
        PersonResponseVO vo = new PersonResponseVO();
        vo.setId( entity.getId() );
        vo.setAge( entity.getAge() );
        vo.setName( entity.getName() );
        vo.setSurname( entity.getSurname() );
        return vo;
    }
}
