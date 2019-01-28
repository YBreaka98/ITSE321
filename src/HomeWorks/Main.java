package HomeWorks;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
       /* String expr = in.nextLine();
        expr.trim();
        String expr1 = in.nextLine().trim();*/
        String expr2 = in.nextLine().trim();
        Functions F = new Functions(expr2);
        identifiersAutomata a = new identifiersAutomata();
        numbersAutomata b = new numbersAutomata();
        conditionsAutomata c = new conditionsAutomata();
        a.Identifers(F);
        //b.Numbers(new Functions(expr1));
        //c.Condition(new Functions(expr2));

<<<<<<< HEAD

            while (F.test()) {

                if (a.Identifers(F)) {
                    F.retract();
                    if (c.Condition(F)) {
                        F.retract();
                        if (b.Numbers(F)) {
=======

>>>>>>> parent of 0f54abe... FUCK OFF


<<<<<<< HEAD
                }
            }


        }
}
=======
    }
}
>>>>>>> parent of 0f54abe... FUCK OFF
