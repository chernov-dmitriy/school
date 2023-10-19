package com.chernov.school.person;

import com.chernov.school.person.vo.PersonRequestVO;
import com.chernov.school.person.vo.PersonResponseVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping( "/person" )
public class PersonController
{
    private final PersonService personService;
    private final PersonVoMapper personVoMapper;

    @PostMapping( consumes = "application/json" )
    public PersonResponseVO create( @RequestBody PersonRequestVO person )
    {
        final Person entity = personVoMapper.toEntity( person );
        entity.setId( UUID.randomUUID() );
        Person saved = personService.save( entity );
        return personVoMapper.toVO( saved );
    }

    @GetMapping
    public List<PersonResponseVO> getAll()
    {
        return personService.getAll().stream()
                            .map( personVoMapper::toVO )
                            .collect( Collectors.toList() );
    }

    @GetMapping( "/{id}" )
    public PersonResponseVO getById( @PathVariable( "id" ) UUID id )
    {
        return personService.findById( id )
                            .map( personVoMapper::toVO )
                            .get();
    }

}
