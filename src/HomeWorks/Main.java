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


            while (F.test()) {

                if (a.Identifers(F)) {
                    F.retract();
                    if (c.Condition(F)) {
                        F.retract();
                        if (b.Numbers(F)) {

                        }
                    }

                }
            }


        }
}