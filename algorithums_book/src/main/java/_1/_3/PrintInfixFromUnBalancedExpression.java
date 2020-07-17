package _1._3;

import java.util.Stack;

public class PrintInfixFromUnBalancedExpression {

    /**
     * Data Structure : Stack
     *
     */

    public static void main(String[] args) {
        String input = "1+2)*3-4)*5-6)))";
        String expected = "((1+2)*((3-4)*(5-6)))";
        String result = convert(input);
        System.out.println(result);
        System.out.println( expected.equalsIgnoreCase(result));
    }

    private static String convert(String input) {
        if(input == null || input.length() ==0) return "";
        Stack<String> stack = new Stack<String>();
        for(int i =0; i< input.length(); i++){
            String str  = Character.toString(input.charAt(i));
            if(str.equalsIgnoreCase(")")){
                String v2 = stack.pop();
                String op = stack.pop();
                String v1 = stack.pop();
                stack.push("(" + v1+op+v2+")");
            }else{
                stack.push(str);
            }
        }
        return stack.pop();
    }
}
