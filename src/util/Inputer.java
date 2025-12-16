package util;

import java.util.Scanner;

public class Inputer {
    private static final Scanner scanner = new Scanner(System.in);

    public static String pegarString() {
        return scanner.nextLine();
    }
}
