// Simple program to demonstrate wildcard usage in Java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wildcard {
    public static void printAnyList(List<?> list) {
        for (Object item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public static void addIntegers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Asha", "Ravi", "Neha");
        List<Integer> marks = Arrays.asList(85, 90, 95);

        System.out.println("Using List<?>:");
        printAnyList(names);
        printAnyList(marks);

        System.out.println("Using List<? extends Number>:");
        System.out.println("Sum = " + sumNumbers(marks));

        System.out.println("Using List<? super Integer>:");
        List<Number> numbers = new ArrayList<>();
        addIntegers(numbers);
        System.out.println(numbers);
    }
}
