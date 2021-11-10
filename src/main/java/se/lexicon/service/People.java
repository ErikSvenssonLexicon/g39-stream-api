package se.lexicon.service;

import se.lexicon.model.Person;

import java.util.List;

public interface People {

    People INSTANCE = PeopleImpl.getInstance();

    List<Person> getPeople();
}
