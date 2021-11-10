package se.lexicon;

import se.lexicon.model.Person;
import se.lexicon.service.People;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Examples examples = new Examples();
        System.out.println(examples.countPeople());
        System.out.println(examples.getOldest());
        System.out.println(examples.getYoungest());
        System.out.println("Find first: " + examples.findFirst());
        System.out.println("Find any: " + examples.findAny());
    }
}
