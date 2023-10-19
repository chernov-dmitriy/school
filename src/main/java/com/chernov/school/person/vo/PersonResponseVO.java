package com.chernov.school.person.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode( callSuper = true )
public class PersonResponseVO extends PersonBaseVO
{
    private UUID id;
}
