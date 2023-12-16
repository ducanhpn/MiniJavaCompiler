import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Aufgabe33 {
    public static void main(String[] args){
        String abc = """
                final int eingabe = 10;
                int n = 0, sum = 0, next = 1, temp;
                print(sum);""";
        boolean test = programm(abc);
        System.out.println(test);

    }

    public static boolean programm(String str){
        String[] lines = str.split(System.lineSeparator());
        boolean a1 = constDecl(lines[0]);
        boolean a2 = varDecl(lines[1]);
        int i = statement(lines[2]);
        return a1 && a2 && i==0;
    }
    public static boolean constDecl(String str){

        Pattern p = Pattern.compile("^final\s*int\s*");
        Matcher matcher = p.matcher(str);
        boolean matchFound = matcher.find();
        if(matchFound) constorVarZu();
        else return false;
        return true;
    }

    static boolean varDecl(String str){
        Pattern p = Pattern.compile("^\s*int\s*");
        Matcher matcher = p.matcher(str);
        boolean matchFound = matcher.find();
        if(matchFound) constorVarZu();
        else return false;
        return true;
    }

    static int statement(String str){

        if(str.substring(0,5).equals("print")){
            String t = str.substring(6,str.length());
            return statement2(t, 0);
        }
        else{
            return -1;
        }
    }

    static int statement2(String str, int i){
        int temp = -1;
        if(str.charAt(0) == '('){
            temp = statement2(str.substring(1,str.length()),i+1);
        }
        else{
            while(str.charAt(0) != ')'){
                str = str.substring(1,str.length());
            }
            if(str.charAt(0) == ')'){
                return i--;
            }
        }
        return temp;
    }

    static boolean constorVarZu(){
        Pattern p = Pattern.compile("\\w(=\\d)?(,\\w(=\\d)?)*;");
        Matcher matcher = p.matcher("");
        return matcher.find();
    }

}
