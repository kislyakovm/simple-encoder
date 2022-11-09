package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input string:");
        char[] str = scanner.nextLine().toCharArray();

        for (char i : str) {
            System.out.print(i + " ");
        }
    }
}