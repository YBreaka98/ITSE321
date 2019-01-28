package HomeWorks;

public class  Functions {

    private static int Index;
    private  int len ;
    private String Str;
    public static int last_Index;

    public Functions(String expr){
        Str = expr;
        Index = -1;
        len = Str.length();

    }





    public char nextChar() {
        if(Index < (len - 1))
            return Str.charAt(++Index);
        return '\0';
    }
    public void fail() {
<<<<<<< HEAD
        /*System.out.print(" Not Accepted");*/
=======
        System.out.println("Not Accepted");
>>>>>>> parent of 0f54abe... FUCK OFF
        Index = last_Index;

    }

    public boolean test() {
        if (Index < (len-1) ) {
            return true;
        }
        return false;
    }



    public void retract() {
        Index--;
    }

    public  int getIndex() {
        return Index;
    }

    public int getLen() {
        return len;
    }

    public String getStr() {
        return Str;
    }
}
