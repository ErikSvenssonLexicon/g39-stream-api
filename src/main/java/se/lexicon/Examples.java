package se.lexicon;

import se.lexicon.model.Gender;
import se.lexicon.model.Person;
import se.lexicon.model.PersonDto;
import se.lexicon.service.People;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Examples {

    private final List<Person> people = People.INSTANCE.getPeople();

    public long countPeople(){
        return people.stream()
                .count();
    }

    public Person getOldest(){
        Optional<Person> result = people.stream()
                .min((p1, p2) -> p1.getDateOfBirth().compareTo(p2.getDateOfBirth()));
        return result.orElseThrow(RuntimeException::new);
    }

    public Person getOldestImperative(){
        Person person = null;
        for(Person p : people){
            if(person == null){
                person = p;
            }
            if(person.getDateOfBirth().isAfter(p.getDateOfBirth())){
                person = p;
            }
        }
        return Optional.ofNullable(person)
                .orElseThrow(RuntimeException::new);
    }

    public Person getYoungest(){
        return people.stream()
                .max(Comparator.comparing(Person::getDateOfBirth))
                .orElseThrow(RuntimeException::new);
    }

    public Person findFirst(){
        return people.stream()
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public Person findAny(){
        return people.parallelStream()
                .findAny()
                .orElseThrow(RuntimeException::new);
    }

    public String getAllNames(List<String> names){
        return names.stream()
                .reduce("", (s1, s2) -> s1 + "," + s2);
    }

    public Set<Person> collectToSet(){
        return people.stream()
                .collect(Collectors.toSet());
    }

    public Person[] toArray(){
        return people.stream()
                .toArray(Person[]::new);
    }

    public Map<String, List<Person>> toMap(){
        return people.stream()
                .collect(Collectors.groupingBy(Person::getLastName));
    }

    public Map<Boolean, List<Person>> toMapBoolean(){
        return people.stream()
                .collect(Collectors.partitioningBy(person -> person.getGender().equals(Gender.FEMALE)));
    }

    public Person findById(int id){
        return people.stream()
                .filter(person -> person.getPersonId() == id) //Intermediary
                .findFirst() //Terminal operation
                .orElseThrow(() -> new RuntimeException("Person with id " + id + " could not be found"));
    }

    public List<Person> findByLastName(final String lastName){
        return people.stream()
                .filter(person -> person.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }

    public List<PersonDto> findAndConvert(Gender gender){
        return people.stream()
                .filter(person -> person.getGender().equals(gender))
                //.map(person -> new PersonDto(person.getPersonId(), person.getFirstName() + " " + person.getLastName()))
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public LocalDate[] createCalendarYear(int year){
        LocalDate seed = LocalDate.ofYearDay(year, 1);
        return Stream.iterate(seed, date -> date.plusDays(1))
                .limit(seed.isLeapYear() ? 366 : 365)
                .toArray(LocalDate[]::new);
    }

    public PersonDto convert(Person person){
        if(person == null) return null;
        return new PersonDto(person.getPersonId(), person.getFirstName() + " " + person.getLastName());
    }


}
