package _1._3;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostFix {
    /**
     * Data Structure : Stack
     *
     * Infix : A * B + C / D
     * PostFix : A B * C D / +
     */

    static final Map<Character, Integer> OP = new HashMap<>();
    static {
        OP.put('*', 5);
        OP.put('/', 5);
        OP.put('+', 3);
        OP.put('-', 3);
    }
    public static void main(String[] args) {
        String infix = "A*B+C/D";
        String expected = "AB*CD/+";
        String postfix = infixToPostFix(infix);
        System.out.println(postfix);
        System.out.println(expected.equalsIgnoreCase(postfix));
    }

    private static String infixToPostFix(String infix) {
        if(infix == null || infix.length() ==0) return "";
        Stack<Character>  s = new Stack<Character>();
        StringBuffer postfix = new StringBuffer();
        for(int i=0; i< infix.length(); i++){
            char c = infix.charAt(i);
            if(OP.keySet().contains(c)){
                while(!s.isEmpty()){
                    char l = s.pop();
                    if( OP.get(l) > OP.get(c)){
                        postfix.append(l);
                    }else {
                        s.push(l);
                        break; //END while loop
                    }
                }
                s.push(c);
            }else{
                postfix.append(c);
            }
        }
        while(!s.isEmpty()){
            postfix.append(s.pop());
        }
        return  postfix.toString();
    }

}
