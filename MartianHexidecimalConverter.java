import java.util.Scanner;

public class MartianHexidecimalConverter {

    public static void main(String[] args) {
        // Main method prompts the user for upper bound limit and begins the menu method testing.

        Scanner s = new Scanner(System.in);

        System.out.printf("Recursive programs can quickly get out of hand, complexity wise."
                + "%n Enter an upper bound on input size: ");
        int upperBound = s.nextInt();
        if (upperBound >= 6) {
            System.out.println("Warning: there will be a time delay for inputs larger than 6 characters long.");
        }

        int endUserSelection = menuChoice();
        while (endUserSelection != 0) {
            menuChoiceOutput(endUserSelection);
            System.out.println("");
            endUserSelection = menuChoice();
        }
        s.close();
        System.exit(0);
    }

    public static int menuChoice() {
        // Menu selection method

        Scanner s = new Scanner(System.in);
        System.out.printf("Select method to test: "
                + "%n Enter 1 for dec2Hex"
                + "%n Enter 2 for bin2Dec"
                + "%n Enter 3 for hex2Dec"
                + "%n Enter 4 for StringPermutation"
                + "%n Enter 0 to Exit the program ");
        int choice = s.nextInt();
        return choice;
    }

    public static void menuChoiceOutput(int endUserChoice) {
        // Menu selection output.

        Scanner s = new Scanner(System.in);

        if (endUserChoice == 1) {
            System.out.print("Enter a number: ");
            int number = s.nextInt();
            System.out.print(number + " in binary is " + dec2Hex(number));
        }
        else if (endUserChoice == 2) {
            System.out.print("Enter a binary number: ");
            String binary = s.next();
            System.out.println(binary + " is equal to " + bin2Dec(binary));
        }
        else if (endUserChoice == 3) {
            System.out.print("Enter a hexadecimal number: ");
            String hex = s.next();
            System.out.println(hex + " = " + hex2Dec(hex));

        }
        else {
            System.out.print("Enter a string: ");
            String str = s.next();
            System.out.println("All possible permutations of " + str + " are: ");
            displayPermutation(str);
        }
    }

    private static String dec2Hex(int value) {
        // Dec to hex converter

        if (value < 16)
            return getHexFormat(value);
        else
            return  dec2Hex(value / 16) + getHexFormat(value % 16);
    }

    public static int bin2Dec(String binaryString) {
        // Bin to str converter

        int i = (binaryString.charAt(0) == '1') ? 1 : 0;
        if (binaryString.length() == 1)
            return i;

        return (int)Math.pow(2, binaryString.length() - 1) * i + bin2Dec(binaryString.substring(1));
    }

    public static int hex2Dec(String hexString) {
        // Hex to str converter

        if (hexString.length() == 1)
            return convertHex(hexString.charAt(0));
        else
            return (int)Math.pow(16, hexString.length() - 1) * convertHex(hexString.charAt(0)) + hex2Dec(hexString.substring(1));
    }

    public static void displayPermutation(String s) {
        displayPermutation("", s);
    }

    public static void displayPermutation(String s1, String s2) {

        if (s2.length() == 0) {
            System.out.println(s1);
        } else {
            for (int i = 0; i < s2.length(); i++) {
                displayPermutation(s1 + s2.charAt(i), s2.substring(0, i) + s2.substring(i + 1));
            }
        }
    }

    private static String getHexFormat(int n) {
        // Returns hex format for dec2Hex

        if (n > 9 && n < 16)
            return (char)(n - 10 + 'A') + "";
        if (n >= 0)
            return n + "";
        else
            return "Invalid";
    }

    public static int convertHex(char ch) {
        // Returns for hex char for hex2Dec

        System.out.println(ch + " Text " + (ch - 10));
        if (ch - '0' < 10)
            return ch - '0';
        ch = Character.toUpperCase(ch);
        return ch - 'A' + 10;
    }

}
