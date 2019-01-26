package HomeWorks;

import java.util.ArrayList;

public class conditionsAutomata {

    private int state;
    private char currentChar;
    private Boolean power;
    private ArrayList<TOKEN> tokens;

    public conditionsAutomata() {
        this.tokens = new ArrayList<>();
        this.state = 0;
    }

    public void Condition(Functions e) {

        power = e.getIndex() < e.getLen();
        state = 0;
        while (power) {

            power = e.getIndex() < e.getLen();
            currentChar = e.nextChar();

            switch (state) {
                case 0:
                    Check(e);
                    break;
                case 1:
                    if(currentChar =='=')
                        state = 7;
                    else
                        state = 8;
                    break;
                case 2:
                    if(currentChar =='=')
                        state = 9;
                    else
                        state = 10;
                    break;
                case 3:
                    if(currentChar =='=')
                        state = 11;
                    else
                        e.fail();
                        state = 0;
                    break;
                case 4:
                    if(currentChar =='=')
                        state = 12;
                    else
                        state = 13;
                    break;
                case 5:
                    if(currentChar =='|')
                        state = 11;
                    else
                        state = 0;
                    break;
                case 6:
                    if(currentChar =='&')
                        state = 11;
                    else
                        state = 0;
                    break;
                case 7:
                    createToken(new TOKEN("Logic","LT_EQ"));
                    Functions.last_Index = e.getIndex();
                    state = 0;
                    break;
                case 8:
                    createToken(new TOKEN("Logic","LT"));
                    Functions.last_Index = e.getIndex();
                    e.retract();
                    state = 0;
                    break;
                case 9:
                    if (currentChar =='\0') {
                        power =false;
                    }
                    createToken(new TOKEN("Logic","NOT_EQ"));
                    Functions.last_Index = e.getIndex();
                    state = 0;
                    break;
                case 10:
                    if (currentChar =='\0') {
                        power =false;
                    }
                    createToken(new TOKEN("Logic","NOT"));
                    Functions.last_Index = e.getIndex();
                    e.retract();
                    state = 0;
                    break;
                case 11:
                    createToken(new TOKEN("Logic","EQ"));
                    Functions.last_Index = e.getIndex();
                    state = 0;
                    break;
                case 12:
                    createToken(new TOKEN("Logic","GT_EQ"));
                    Functions.last_Index = e.getIndex();
                    state = 0;
                    break;
                case 13:
                    if (currentChar =='\0') {
                        power =false;
                    }
                    createToken(new TOKEN("Logic","GT"));
                    Functions.last_Index = e.getIndex();
                    e.retract();
                    state = 0;
                    break;
                case 14:
                    createToken(new TOKEN("Logic","OR"));
                    Functions.last_Index = e.getIndex();
                    state = 0;
                    break;
                case 15:
                    createToken(new TOKEN("Logic","AND"));
                    Functions.last_Index = e.getIndex();
                    state = 0;
                    break;

            }

        }

    }

    public void Check(Functions e) {
        if (currentChar =='\0') {
            power =false;
        }
        else if (currentChar == '<')
            state = 1;
        else if (currentChar == '!')
            state = 2;
        else if (currentChar == '-')
            state = 3;
        else if (currentChar == '>')
            state = 4;
        else if (currentChar == '|')
            state = 5;
        else if (currentChar == '&')
            state = 6;
        else
            e.fail();


    }
    private void createToken(TOKEN token) {
        tokens.add(token);
        System.out.print(tokens.get(tokens.size() - 1).toString());
        state = 0;
    }
    }




