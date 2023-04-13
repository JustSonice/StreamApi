import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");

        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

   // 1
        long count = persons.stream()
                .filter(age -> age.getAge() > 18)
                .count();
        System.out.println(count);

    //2
        List<String> mans = persons.stream()
                .filter(Person -> Person.getSex().equals(Sex.MAN))
                .filter(Person -> Person.getAge() > 18 & Person.getAge() < 27)
                .map(Person -> Person.getFamily())
                .collect(Collectors.toList());
        System.out.println(mans);

    //3
        List<String> worker = persons.stream()
                .filter(education -> education.getEducation().equals(Education.HIGHER))
                .filter(age ->  age.getAge() > 18)
                .filter(Person -> {
                    if (Person.getSex().equals(Sex.MAN) && Person.getAge() < 65){
                    return true;
                } else if ( Person.getSex().equals(Sex.WOMAN) && Person.getAge() < 60) {
                    return true;
                } else {
                        return false;
                    }
                })
                .sorted(Comparator.comparing(Person::getFamily))
                .map(Person::toString)
                .collect(Collectors.toList());
        System.out.println(worker);
    }
}