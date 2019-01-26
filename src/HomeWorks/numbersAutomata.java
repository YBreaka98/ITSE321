package HomeWorks;

import java.util.ArrayList;



public class numbersAutomata {
    private int state;
    private char currentChar;
    private Boolean power;
    private ArrayList<TOKEN> tokens;
    ArrayList n = new ArrayList();

    public numbersAutomata() {
        this.tokens = new ArrayList<>();
        this.state = 0;
    }

    public void Numbers(Functions e) {

        power = e.getIndex() < e.getLen();
        state = 0;
        while (power) {

            power = e.getIndex() < e.getLen();
            currentChar = e.nextChar();

            switch (state) {
                case 0 :
                    Check(e);
                    break;
                case 1 :
                    Check(e);
                    break;
                case 2 :
                    Check(e);
                    break;
                case 3 :
                    /*createToken(new TOKEN("num","int"));
                    e.retract();
                    state = 0;*/
                    break;
            }

        }

    }

    public void Check(Functions e) {
          if (CheckNumbers(currentChar) && state == 0) {
            state = 1;
          } else if (!CheckNumbers(currentChar) && state ==0) {
              e.fail();
          } else if (currentChar == '.' && state == 1) {
              state = 2;
          } else if (currentChar == '\0' && state == 1) {
              createToken(new TOKEN("num", "int"));
              Functions.last_Index = e.getIndex();
              state = 0;
              power = false;
          } else if (!CheckNumbers(currentChar) && state == 1) {
              createToken(new TOKEN("num", "int"));
              Functions.last_Index = e.getIndex();
              state = 0;
              e.retract();
          } else if (currentChar == '\0' && state == 2) {
              createToken(new TOKEN("num", "float"));
              Functions.last_Index = e.getIndex();
              state = 0;
              power = false;
          } else if (!CheckNumbers(currentChar) && state == 2) {
              createToken(new TOKEN("num", "float"));
              Functions.last_Index = e.getIndex();
              state = 0;
          }

    }

    private void createToken(TOKEN token) {
        tokens.add(token);
        System.out.print(tokens.get(tokens.size() - 1).toString());
        state = 0;
    }


    public boolean CheckNumbers(char c) {
        if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
            return true;
        }
            return false;
    }
}