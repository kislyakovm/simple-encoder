package chucknorris;

import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please input operation (encode/decode/exit):");
            String answer = scanner.nextLine();
            if ("encode".equals(answer)) {
                String converted = charToBin();
                binToChuckCode(converted);
            } else if ("decode".equals(answer)) {
                String binCode = ChuckToBin();
                if (binCode.length() % 7 == 0) {
                    binToString(binCode);
                } else {
                    System.out.println("Encoded string is not valid.");
                    System.out.println();
                }
            } else if ("exit".equals(answer)) {
                System.out.println("Bye!");
                break;
            } else {
                System.out.printf("There is no '%s' operation\n", answer);
                System.out.println();
            }
        }
    }

    public static boolean checkInput(String[] ChuckCode) {
        if (ChuckCode.length % 2 != 0) {
            return false;
        }

        for (int k = 0; k < ChuckCode.length; k += 2) {
            if (!"0".equals(ChuckCode[k]) && !"00".equals(ChuckCode[k])) {
                return false;
            }
        }

        for (String i: ChuckCode) {
                if (!i.chars().allMatch(c -> c == '0')) {
                    return false;
                }
        }
        return true;
    }

    public static String charToBin () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input string:");
        char[] str = scanner.nextLine().toCharArray();
        String converted = "";

        System.out.println("Encoded string:");

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
        System.out.println();
        System.out.println();
    }

    public static String ChuckToBin() {
        System.out.println("Input encoded string:");
        Scanner scanner = new Scanner(System.in);

        String[] ChuckCode = scanner.nextLine().split(" ");

        if (checkInput(ChuckCode)) {
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
        return " ";
    }

    public static void binToString (String binCode) {
        String Str = "";
        String[] symbols = binCode.split("(?<=\\G.{7})");

        for (String i : symbols) {
            Str += (char)Integer.parseInt(i,2);
        }

        System.out.println("Decoded string:");
        System.out.println(Str);
        System.out.println();
    }

}
