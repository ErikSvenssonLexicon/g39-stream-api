package se.lexicon;

import se.lexicon.model.Gender;
import se.lexicon.model.Person;
import se.lexicon.service.People;

import java.time.LocalDate;
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
        /*
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

         */

        System.out.println(examples.findById(9999));
        System.out.println();
        examples.findByLastName("Nilsson")
                .forEach(System.out::println);

        LocalDate[] year2021 = examples.createCalendarYear(2021);
        Arrays.stream(year2021).forEach(System.out::println);

        examples.findAndConvert(Gender.MALE)
                .forEach(System.out::println);

    }
}
