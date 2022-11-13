package chucknorris;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
//        String converted = charToBin();
//        binToChuckCode(converted);

        String binCode = ChuckToBin();
        binToString(binCode);
    }

    public static String charToBin () {
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
        return converted;
    }

    public static void binToChuckCode(String converted)
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

    public static String ChuckToBin() {
        System.out.println();
        System.out.println("Input encoded string:");
        Scanner scanner = new Scanner(System.in);

        String[] ChuckCode = scanner.nextLine().split(" ");
        String binCode = "";

        for (int i = 0; i < ChuckCode.length; i += 2) {
            if ("0".equals(ChuckCode[i])) {
                for (int j = 0; j < ChuckCode[i + 1].length(); j++) {
                    binCode += '1';
                }
            } else {
                for (int j = 0; j < ChuckCode[i + 1].length(); j++) {
                    binCode += '0';
                }
            }
        }
        return binCode;
    }

    public static void binToString (String binCode) {
        String Str = "";
        String[] symbols = binCode.split("(?<=\\G.{7})");

        for (String i : symbols) {
            Str += (char)Integer.parseInt(i,2);
        }

        System.out.println();
        System.out.println("The result:");
        System.out.println(Str);
    }

}
