package features.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExprssn {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(11);
        numbers.add(22);
        numbers.add(13);
        numbers.add(158);
        numbers.add(41);

        numbers.forEach( n -> {System.out.println(n);});

        List<Integer> ans = numbers.stream().filter( n -> n%2 == 0)
                .collect(Collectors.toList());
        System.out.println("******");
        ans.forEach(System.out::println);
        System.out.println("******");

        List<Integer> ans1 = numbers.stream().sorted().collect(Collectors.toList());
        ans1.forEach(System.out::println);
    }
}
