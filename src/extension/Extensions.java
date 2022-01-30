package extension;

import java.util.List;

public class Extensions {

    public static void main(String[] args) {
        final var c = ExtensionsKt.lastChar("Happy Jordi");
        System.out.println(c);

        System.out.println(String.join(",", "a", "b", "c"));

        final var array = "12.345-6.A".split("\\.");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
