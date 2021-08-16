import java.util.Scanner;

public class Main {
    
    public static void printOptions() {
    System.out.println("Supported requests:");
    System.out.println("- enter a natural number to know its properties;");
    System.out.println("- enter two natural numbers to obtain the properties of the list:");
    System.out.println("* the first parameter represents a starting number;");
    System.out.println("* the second parameters show how many consecutive numbers are to be processed;");
    System.out.println("- two natural numbers and properties to search for;");
    System.out.println("- a property preceded by minus must not be present in numbers;");
    System.out.println("- separate the parameters with one space;");
    System.out.println("- enter 0 to exit.");
}
    
    public static void printProperties(long n) {
        System.out.println("Properties of " + n);
        System.out.println("\teven: " + isEven(n));
        System.out.println("\todd: " + isOdd(n));
        System.out.println("\tbuzz: " + isBuzz(n));
        System.out.println("\tduck: " + isDuck(n));
        System.out.println("\tpalindromic: " + isPal(n));
        System.out.println("\tgapful: " + isGapful(n));
        System.out.println("\tspy: " + isSpy(n));
        System.out.println("\tsunny: " + isSunny(n));
        System.out.println("\tsquare: " + isSquare(n));
        System.out.println("\tjumping: " + isJumping(n));
        System.out.println("\tsad: " + isSad(n));
        System.out.println("\thappy: " + isHappy(n));
    }

    public static void printProperties2(long n) {
        System.out.print(n + " is");
        if (isEven(n))
            System.out.print(" even,");
        if (isOdd(n))
            System.out.print(" odd,");
        if (isBuzz(n))
            System.out.print(" buzz,");
        if (isDuck(n))
            System.out.print(" duck,");
        if (isPal(n))
            System.out.print(" palindromic,");
        if (isGapful(n))
            System.out.print(" gapful,");
        if (isSpy(n))
            System.out.print(" spy,");
        if (isSunny(n))
            System.out.print(" sunny,");
        if (isSquare(n))
            System.out.print(" square,");
        if (isJumping(n))
            System.out.print(" jumping,");
        if (isSad(n))
            System.out.print(" sad,");
        if (isHappy(n))
            System.out.print(" happy");
        System.out.println();
    }
    
    public static boolean isEven(long n) {
        if (n % 2 == 0)
            return true;
        return false;
    }
    
    public static boolean isOdd(long n) {
        if (n % 2 == 1)
            return true;
        return false;
    }
    
    public static boolean isBuzz(long n) {
        if (n >= 7 && (n % 7 == 0 || n % 10 == 7))
            return true;
        return false;
    }
    
    public static boolean isDuck(long n) {
        boolean duck = false;
        long n2 = n;
        while (n2 > 0) {
            if (n2 % 10 == 0)
                duck = true;
            n2 /= 10;
        }
        return duck;
    }
    
    public static boolean isPal(long n) {
        boolean pal = true;
        String s = String.valueOf(n);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                pal = false;
        }
        return pal;
    }
    
    public static boolean isGapful(long n) {
        boolean gapful = false;
        String s = String.valueOf(n);
        if (s.length() >= 3) {
            if (n % (Character.getNumericValue(s.charAt(0)) * 10 + Character.getNumericValue(s.charAt(s.length() - 1))) == 0)
                gapful = true;
        }
        return gapful;
    }
    
    public static boolean isSpy(long n) {
        int sum = 0;
        int prd = 1;
        boolean spy = false;
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            sum += Character.getNumericValue(s.charAt(i));
            prd *= Character.getNumericValue(s.charAt(i));
        }
        if (sum == prd)
            spy = true;
        return spy;
    }
    
    public static boolean isSunny(long n) {
        n++;
        if (isSquare(n))
            return true;
        return false;
    }
    
    public static boolean isSquare(long n) {
        double sqrtn = Math.sqrt(n);
        String s = String.valueOf(sqrtn);
        if (s.charAt(s.length() - 2) == '.' && s.charAt(s.length() - 1) == '0')
            return true;
        return false;
    }
    
    public static boolean isJumping(long n) {
        String s = String.valueOf(n);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) - s.charAt(i + 1) != 1 && s.charAt(i) - s.charAt(i + 1) != -1)
                return false;
        }
        return true;
    }
    
    public static boolean isHappy(long n) {
        String s = String.valueOf(n);
        long n2 = n;
        int count = 0;
        do {
            n = 0;
            for (int i = 0; i < s.length(); i++)
                n += Character.getNumericValue(s.charAt(i)) * Character.getNumericValue(s.charAt(i));
            if (n == 1)
                return true;
            s = String.valueOf(n);
            count++;
        } while (n!= n2 && count < 100);
        return false;
    }
    
    public static boolean isSad(long n) {
        if (isHappy(n))
                return false;
        return true;
    }
    
    public static boolean checkProperties(long n, String prop) {
        if (prop.equals("even") && isEven(n))
            return true;
        if (prop.equals("odd") && isOdd(n))
            return true;
        if (prop.equals("buzz") && isBuzz(n))
            return true;
        if (prop.equals("duck") && isDuck(n))
            return true;
        if (prop.equals("palindromic") && isPal(n))
            return true;
        if (prop.equals("gapful") && isGapful(n))
            return true;
        if (prop.equals("spy") && isSpy(n))
            return true;
        if (prop.equals("sunny") && isSunny(n))
            return true;
        if (prop.equals("square") && isSquare(n))
            return true;
        if (prop.equals("jumping") && isJumping(n))
            return true;
        if (prop.equals("sad") && isSad(n))
            return true;
        if (prop.equals("happy") && isHappy(n))
            return true;
        return false;
    }
    
    public static void printProperties4(long n, int nmbr, String[] s) {
        for (int i = 2; i < s.length; i++)
            s[i] = s[i].toLowerCase();
        boolean check = true;
        while (nmbr > 0) {
            check = true;
            for (int i = 2; i < s.length; i++) {
                if (s[i].startsWith("-")) {
                    if (checkNotProperties(n, s[i]) == true)
                        check = false;
                }
                else {
                    if (checkProperties(n, s[i]) == false)
                        check = false;
                }
            }
            if (check) {
                printProperties2(n);
                nmbr--;
            }
            n++;
        } 
    }
    
    public static boolean sameNegative(String s1, String s2) {
        String start = "-";
        if (s1.charAt(0) == '-' && s2.charAt(0) != '-')
            start = start.concat(s2);
        if (s1.equals(start))
            return true;
        if (s2.charAt(0) == '-' && s1.charAt(0) != '-')
            start = start.concat(s1);
        if (s2.equals(start))
            return true;
        return false;
    }
    
    public static boolean checkMut(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        if (s1.equals("even") && s2.equals("odd") || s1.equals("odd") && s2.equals("even"))
            return true;
        if (s1.equals("duck") && s2.equals("spy") || s1.equals("spy") && s2.equals("duck"))
            return true;
        if (s1.equals("sunny") && s2.equals("square") || s1.equals("square") && s2.equals("sunny"))
            return true;
        if (s1.equals("sad") && s2.equals("happy") || s1.equals("happy") && s2.equals("sad"))
            return true;
        if (sameNegative(s1, s2))
            return true;
        if (s1.startsWith("-") && s2.startsWith("-")) {
            if (checkMut(s1.substring(1), s2.substring(1)))
                return true;
        }
        return false;
    }
         
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!\n");
        printOptions();
        String input = null;
        String[] ap = { "BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "EVEN", "ODD", "SUNNY", "SQUARE", "JUMPING", "SAD", "HAPPY", "-BUZZ", "-DUCK", "-PALINDROMIC", "-GAPFUL", "-SPY", "-EVEN", "-ODD", "-SUNNY", "-SQUARE", "-JUMPING", "-SAD", "-HAPPY" };
        while (true) {
            System.out.println("Enter a request:");
            if (scanner.hasNext())
                input = scanner.nextLine();
            if (input == null) {
                printOptions();
                continue;
            }
            String[] s = input.split(" ");
            long n = Long.valueOf(s[0]);
            if (n == 0)
                break;
            if (n < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
                continue;
            }
            if (s.length == 2) {
                long n2 = Long.valueOf(s[1]);
                if (n2 <= 0) {
                    System.out.println("The second parameter should be a natural number.");
                    continue;
                }
                for (long i = 0; i < n2; i++) {
                    printProperties2(n);
                    n++;
                }
            }
            else if (s.length >= 3) {
                boolean[] avail = new boolean[s.length];
                for (int i = 0; i < avail.length; i++)
                    avail[i] = false;
                avail[0] = true;
                avail[1] = true;
                for (int i = 2; i < avail.length; i++) {
                    for (int j = 0; j < ap.length; j++) {
                        if (ap[j].toLowerCase().equalsIgnoreCase(s[i]))
                            avail[i] = true;
                    }
                }
                int countFalse = 0;
                for (int i = 2; i < avail.length; i++) {
                    if (avail[i] == false)
                        countFalse++;
                }
                if (countFalse == 1) {
                    System.out.print("The property [");
                    for (int i = 0; i < avail.length; i++) {
                        if (avail[i] == false)
                            System.out.print(s[i].toUpperCase());
                    }
                    System.out.println("] is wrong.\nAvailable properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                    continue;
                }
                else if (countFalse > 1) {
                    StringBuilder str = new StringBuilder();
                    System.out.print("The properties [");
                    for (int i = 0; i < avail.length; i++) {
                        if (avail[i] == false)
                            str.append(s[i].toUpperCase()).append(", ");
                    }
                    str.deleteCharAt(str.length() - 1);
                    str.deleteCharAt(str.length() - 1);
                    System.out.print(str);
                    System.out.println("] are wrong..\nAvailable properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                    continue;
                }
                else {
                    boolean flg = false;
                    for (int i = 2; i < s.length; i++) {
                        for (int j = i; j < s.length; j++) {
                            if (checkMut(s[i], s[j])) {
                                flg = true;
                                System.out.println("The request contains mutually exclusive properties: [" + s[i].toUpperCase() + ", " + s[j].toUpperCase() + "]\nThere are no numbers with these properties.");
                                break;
                            }
                        }
                        if (flg)
                            break;
                    }
                    if (flg)
                        continue;
                }
                printProperties4(n, Integer.valueOf(s[1]), s);
            }
            else if (n > 0)
                printProperties(n);
        }
        System.out.println("Goodbye!");
    }
}

