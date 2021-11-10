package se.lexicon;

import se.lexicon.model.Gender;
import se.lexicon.model.Person;
import se.lexicon.service.People;

import java.util.*;
import java.util.stream.Collectors;

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


}
