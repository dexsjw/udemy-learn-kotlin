package academy.learnprogramming.javacode;

import java.util.ArrayList;
import java.util.List;

public class JavaGenerics {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("hello");

        // Generics are a compile time feature
        // JVM does not recognise/understand generics
        boolean b = strings instanceof List;
//        boolean bool = strings instanceof List<String>; // does not work?
    }

}
