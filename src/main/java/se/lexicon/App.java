package se.lexicon;

import se.lexicon.model.Person;
import se.lexicon.service.People;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
        System.out.println(examples.getOldestImperative());
        List<String> names = Arrays.asList(
                "Erik", "Fredrik", "Mehrdad", "Simon", "Ulf"
        );
        System.out.println(examples.getAllNames(names).replaceFirst(",", ""));
        System.out.println(examples.collectToSet().size());

        Map<String, List<Person>> map = examples.toMap();
        Map<Boolean, List<Person>> booleanListMap = examples.toMapBoolean();
        booleanListMap.get(false).forEach(System.out::println);

    }
}
