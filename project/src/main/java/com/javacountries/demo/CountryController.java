package com.javacountries.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;

@RestController

@RequestMapping("/data")
public class CountryController {

    //    "http://localhost8080/"



//    /names/all...return the names of all the countries alphabetically
@GetMapping(value = "/names/all",
           produces = {"application/json"})
    public ResponseEntity<?> alphaCountries() {
    JavaCountriesApplication.myCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(
                JavaCountriesApplication.myCountryList.countryList,
                HttpStatus.OK);
}
    //GetMapping says 'whatever is the next Java method (^^^^), use that'.


    ///names/start/{letter}...return the countries alphabetically that begin with the given letter
    @GetMapping(value = "/names/start/{letter}",
            produces = {"application/json"})
    public ResponseEntity<?> alphaLetterCountries(
            @PathVariable char letter) {


    ArrayList<Country> newVar = JavaCountriesApplication.myCountryList.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));

    newVar.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));



        return new ResponseEntity<>(
                newVar, HttpStatus.OK);
    }





// /names/size/{number}...return the countries alphabetically that have a name equal to or longer than the given length
@GetMapping(value = "/names/size/{number}",
        produces = {"application/json"})
public ResponseEntity<?> alphaLengthCountries(
        @PathVariable int number)
{
    return new ResponseEntity<>(
            JavaCountriesApplication.myCountryList.findCountries(c -> c.getName().length() == number),
            HttpStatus.OK);
}



//    /population/size/{people}   ...return the countries that have a population equal to or greater than the given population
@GetMapping(value = "/population/size/{people}",
        produces = {"application/json"})
public ResponseEntity<?> popSizeCountries(
        @PathVariable int people)
{
    return new ResponseEntity<>(
            JavaCountriesApplication.myCountryList.findCountries(c -> c.getPop() >= people),
            HttpStatus.OK);
}


//    /population/min... return the country with the smallest population
    @GetMapping(value = "/population/min",
            produces = {"application/json"})
    public ResponseEntity<?> popSmallCountries() {
        JavaCountriesApplication.myCountryList.countryList.sort(((c1, c2) -> (int)(c1.getPop() - c2.getPop())));
        return new ResponseEntity<>(
                (JavaCountriesApplication.myCountryList.countryList.get(0)),
                HttpStatus.OK);
    }


//    /population/max... return the country with the largest population
@GetMapping(value = "/population/max",
        produces = {"application/json"})
public ResponseEntity<?> popBigCountries() {
    JavaCountriesApplication.myCountryList.countryList.sort(((c1, c2) -> (int)(c2.getPop() - c1.getPop())));
    return new ResponseEntity<>(
            (JavaCountriesApplication.myCountryList.countryList.get(0)),
            HttpStatus.OK);
}


//        /age/age/{age}... return the countries that have a median age equal to or greater than the given age
@GetMapping(value = "/age/age/{age}",
        produces = {"application/json"})
public ResponseEntity<?> ageOldCountries(
        @PathVariable int age) {
    return new ResponseEntity<>(
            JavaCountriesApplication.myCountryList.findCountries(c -> c.getAge() >= age),
            HttpStatus.OK);
}


//    /age/min....return the country with the smallest median age
@GetMapping(value = "/age/min",
        produces = {"application/json"})
public ResponseEntity<?> ageYoungCountries() {
    JavaCountriesApplication.myCountryList.countryList.sort(Comparator.comparingInt(Country::getAge));
    return new ResponseEntity<>(
            (JavaCountriesApplication.myCountryList.countryList.get(0)),
            HttpStatus.OK);
}


// /age/max....return the country the the greatest median age
@GetMapping(value = "/age/max",
        produces = {"application/json"})
public ResponseEntity<?> ageOldCountries() {
    JavaCountriesApplication.myCountryList.countryList.sort(((c1, c2) -> c2.getAge() - c1.getAge()));
    return new ResponseEntity<>(
            (JavaCountriesApplication.myCountryList.countryList.get(0)),
            HttpStatus.OK);
}

}
