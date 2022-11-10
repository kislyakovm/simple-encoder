package chucknorris;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input string:");
        char[] str = scanner.nextLine().toCharArray();
        String converted = "";

        System.out.println();
        System.out.println("The result:");

        for (char i : str)
        {
            converted += String.format("%7s", Integer.toBinaryString(i)).replace(" ", "0");
        }
        encryption(converted);
    }

    public static void encryption(String converted)
    {
        int i = 0;
        char currentChar;

        while (i < converted.length())
        {
            if (converted.charAt(i) == '0')
            {
                System.out.print("00 ");
                currentChar = '0';
            }
            else
            {
                System.out.print("0 ");
                currentChar = '1';
            }

            while (converted.charAt(i) == currentChar)
            {
                System.out.print("0");
                i++;
                if (i == converted.length()) break;
            }

            if (i < converted.length()) System.out.print(" ");
        }
    }
}
