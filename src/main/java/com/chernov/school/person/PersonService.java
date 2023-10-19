package com.chernov.school.person;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class PersonService
{
    private final PersonRepository repository;

    public PersonService( PersonRepository repository )
    {
        this.repository = repository;
    }

    public Person save( Person person )
    {
        return repository.save( person );
    }

    public List<Person> getAll()
    {
        return StreamSupport.stream( repository.findAll().spliterator(), false )
                            .collect( Collectors.toList() );
    }

    public Optional<Person> findById( UUID id )
    {
        return repository.findById( id );
    }
}
