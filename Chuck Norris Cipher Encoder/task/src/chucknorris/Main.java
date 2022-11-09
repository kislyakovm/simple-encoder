package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input string:");
        char[] str = scanner.nextLine().toCharArray();

        System.out.println();
        System.out.println("The result:");

        for (char i : str) {
            String newStr = String.format("%7s", Integer.toBinaryString(i)).replace(" ", "0");
            System.out.printf("%c = %s%n", i ,newStr);
        }
    }
}
