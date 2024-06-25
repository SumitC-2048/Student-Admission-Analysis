package INNOVATIVE;

public class validation {
    public boolean isValidmobileNumber(String s){
        boolean f = true;
        if(s.length()!=10){
            f = false;
        }
        else{
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)>='0' && s.charAt(i)<='9'){}
                else{f=false;}
            }
        }
        return f;
    }

    public boolean isValidEmail(String s){
        return s.endsWith("@gmail.com");
    }
}
