package com.chernov.school.configuration;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log
public class LoggingAspect
{
    @Before( "execution(* com.chernov.school.person.*.*(..))" )
    public void anyPersonService( JoinPoint joinPoint )
    {
        log.info( "Starting method " + joinPoint.getTarget().toString() );
    }
}
