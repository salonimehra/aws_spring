# Aspect Object Programming
## in pom
<strong>This will import all necessary jar files related to aop </strong>

    <!-- https://mvnrepository.com/artifact/org.springframework/spring-aspects -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-aspects</artifactId>
        <version>5.3.5</version>
    </dependency>
## in helper.java 
<strong>Aspect file</strong>
    
    package com.cognizant.springlearn;

    import org.aspectj.lang.annotation.Aspect;
    import org.aspectj.lang.annotation.Before;
    import org.springframework.context.annotation.EnableAspectJAutoProxy;
    import org.springframework.stereotype.Component;

    @Component
    @Aspect
    @EnableAspectJAutoProxy
    public class helper {

      @Before("execution(* com.cognizant.springlearn.service.EmployeeServices.employeeList())")
      public void log() {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("###################### Welcome ##############33");
      }
    }

  
