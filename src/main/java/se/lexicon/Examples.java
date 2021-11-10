package se.lexicon;

import se.lexicon.model.Person;
import se.lexicon.service.People;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Examples {

    private final List<Person> people = People.INSTANCE.getPeople();

    public long countPeople(){
        return people.stream()
                .count();
    }

    public Person getOldest(){
        Optional<Person> result = people.stream()
                .min((p1, p2) -> p1.getDateOfBirth().compareTo(p2.getDateOfBirth()));

        System.out.println(result);
        return result.orElseThrow(RuntimeException::new);
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


}
