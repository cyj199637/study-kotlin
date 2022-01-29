package controlstructure;

import java.io.IOException;

public class Exceptions {

    public static void main(String[] args) {
        try {
            ExceptionsKt.parseInt("e");
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
