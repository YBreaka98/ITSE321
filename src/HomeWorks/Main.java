package HomeWorks;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String expr = in.nextLine().trim();
        Functions F = new Functions(expr);
        identifiersAutomata a = new identifiersAutomata();
        numbersAutomata b = new numbersAutomata();
        conditionsAutomata c = new conditionsAutomata();

            blah:
            while (F.getIndex() < F.getLen()) {

                if (a.Identifers(F)) {
                    if (c.Condition(F)) {
                        if (b.Numbers(F)) {

                        }
                    }

                }
            }
        }
}