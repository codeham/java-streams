import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> studentNames = new ArrayList<>();
        studentNames.add("Cristian");
        studentNames.add("Alejandro");
        studentNames.add("Cristobal");
        studentNames.add("Carl");
        studentNames.add("Zeek");
        studentNames.add("Donald");

        List<String> teacherNames = new ArrayList<>();
        studentNames.add("Bill");
        studentNames.add("Dom");
        studentNames.add("Rick");
        studentNames.add("Pete");
        studentNames.add("Josh");

        List<List<String>> allNames = new ArrayList<>();

        allNames.add(studentNames);
        allNames.add(teacherNames);

        Optional<String> firstName = allNames.stream().flatMap(Collection::stream).findFirst();

        List<String> flatAllNamesStartingWithC = allNames.stream()
                .flatMap(Collection::stream)
                .filter(x -> x.startsWith("C"))
                .map(name -> name.concat(" - Match"))
                .collect(Collectors.toList());

        List<String> sortedNamesByLength = flatAllNamesStartingWithC.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());

        firstName.ifPresent(System.out::println);
        System.out.println();
        flatAllNamesStartingWithC.forEach(System.out::println);
        System.out.println();
        sortedNamesByLength.forEach(System.out::println);
        System.out.println();

        List<String> allNamesFlat = allNames.stream().flatMap(Collection::stream).collect(Collectors.toList());

        allNamesFlat.stream()
                .sorted(Comparator.comparing(x -> x.startsWith("C")))
                .forEach(System.out::println);

        boolean anyNameMatchingFirstLetterA  = allNamesFlat.stream()
                .anyMatch(name -> name.startsWith("A"));

        boolean allNameMatchingFirstLetterC = allNamesFlat.stream()
                        .allMatch(name -> name.startsWith("C"));

        System.out.println("\nAny names that match with the letter A ? : " + anyNameMatchingFirstLetterA);
        System.out.println("\nAll names matching with the letter C ? : " + allNameMatchingFirstLetterC);
        System.out.println();

        Random randomizer = new Random();
        List<Integer> listOfRandomizedNumbers = IntStream.range(0, 20)
                .boxed()
                .map(value -> randomizer.nextInt(Integer.SIZE))
                .collect(Collectors.toList());

        listOfRandomizedNumbers.forEach(System.out::println);
    }
}