package com.javacountries.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaCountriesApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaCountriesApplication.class, args);
    //^^why is this here?



//    /names/all...return the names of all the countries alphabetically
///names/start/{letter}...return the countries alphabetically that begin with the given letter

// /names/size/{number}...return the countries alphabetically that have a name equal to or longer than the given length

//    /population/size/{people}   ...return the countries that have a population equal to or greater than the given population

//    /population/min... return the country with the smallest population

//    /population/max... return the country with the largest population

//        /age/age/{age}... return the countries that have a median age equal to or greater than the given age

//    /age/min....return the country with the smallest median age

// /age/max....return the country the the greatest median age

    }

}
