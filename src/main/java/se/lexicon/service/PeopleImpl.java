package se.lexicon.service;


import se.lexicon.data.JsonReader;
import se.lexicon.model.Person;

import java.util.List;

public class PeopleImpl implements se.lexicon.service.People {

    private static final PeopleImpl INSTANCE;

    static {
        INSTANCE = new PeopleImpl();
    }

    static PeopleImpl getInstance(){
        return INSTANCE;
    }

    private List<Person> people;

    private PeopleImpl(){
        people = JsonReader.getInstance().read();
    }

    @Override
    public List<Person> getPeople(){
        return people;
    }
}
