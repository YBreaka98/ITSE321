package HomeWorks;

import java.util.ArrayList;

public class identifiersAutomata {
    private int state;
    private char currentChar;
    private Boolean power;
    private ArrayList<TOKEN> tokens;
    ArrayList w = new ArrayList();
    String co = "";


    public identifiersAutomata() {
        this.tokens = new ArrayList<>();
        this.state = 0;
    }


    public boolean Identifers(Functions e) {

        power = e.getIndex() < e.getLen();
        state = 0;
        while (power) {

            power = e.getIndex() < e.getLen();
            currentChar = e.nextChar();
            if(currentChar!=' ' || currentChar !='\0') {
                co = co + currentChar;
            }
            switch (state) {
                case 0 :
                    CheckChar(e , 1 );
                    break;
                case 1 :
                    CheckChar(e ,1 );
                    break;
            }

        }
        if(currentChar == '\0')
            return false;
        else
            return true;
    }

    private void createToken(TOKEN token) {
        tokens.add(token);
        System.out.print(tokens.get(tokens.size() - 1).toString());
        state = 0;

    }

    public void CheckChar(Functions e, int TState) {
        if (currentChar == '\0') {
            if (co.length() > 0) {
                if(!w.contains(co.trim())) {
                    w.add(co.trim());
                }
                createToken(new TOKEN("id" , String.valueOf(w.indexOf(co.trim()))));
                Functions.last_Index = e.getIndex();
                co = "";
            }
            co = "";
            power = false;
        }
        else if (Character.isAlphabetic(currentChar))
            state = TState;
        else if (currentChar == ' ' && state == 0) {
            state = 0;
        }
        else if (!Character.isAlphabetic(currentChar) && state ==0) {
            e.fail();
            power = false;
        } else if (state > 0) {
            if (!Character.isAlphabetic(currentChar) && !CheckNumber(currentChar)) {
                e.retract();
                if (!w.contains(co.trim())) {
                    w.add(co.trim());
                }
                createToken(new TOKEN("id", String.valueOf(w.indexOf(co.trim()))));
                Functions.last_Index = e.getIndex();
                co = "";
            }
        }
    }

    public static boolean CheckNumber(char c) {
        if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')
            return true ;
        return false;
    }

}
