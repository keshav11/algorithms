package JavaExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringComparisonEx {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");


        // ascending
        Collections.sort(list, (a, b) -> a.compareTo(b));

        System.out.println(list.get(0).compareTo(list.get(1))); // -1

        System.out.println(list); // [A, B, C, D, E]

        // descending
        Collections.sort(list, (a, b) -> b.compareTo(a)); // 1

        System.out.println(list.get(0).compareTo(list.get(1))); // [E, D, C, B, A]

        System.out.println(list);

    }

}
