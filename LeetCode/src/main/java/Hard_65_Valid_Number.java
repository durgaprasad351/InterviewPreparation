
public class Hard_65_Valid_Number {

    public static void main(String[] args) {
      //  System.out.println("1" + "-->" + isNumber("1"));
      /*  System.out.println(" 0.1 " + "-->" + isNumber(" 0.1 "));
        System.out.println("abc" + "-->" + isNumber("abc"));
        System.out.println("1 a" + "-->" + isNumber("1 a"));
        System.out.println("2e10" + "-->" + isNumber("2e10"));
        System.out.println(" -90e3   " + "-->" + isNumber(" -90e3   "));
        System.out.println(" 1e" + "-->" + isNumber(" 1e"));
        System.out.println("e3" + "-->" + isNumber("e3"));
        System.out.println(" 6e-1" + "-->" + isNumber(" 6e-1"));

        System.out.println(" 99e2.5 " + "-->" + isNumber(" 99e2.5 "));
        System.out.println("53.5e93" + "-->" + isNumber("53.5e93"));
        System.out.println(" --6 " + "-->" + isNumber(" --6 "));
        System.out.println("-+3" + "-->" + isNumber("-+3"));
        System.out.println("95a54e53" + "-->" + isNumber("95a54e53"));

        System.out.println(".1" + "-->" + isNumber(".1"));
        System.out.println(".e1" + "-->" + isNumber(".e1"));
        System.out.println("3." + isNumber("3."));

        System.out.println("4e+" + isNumber("4e+"));
        System.out.println(".-4" + isNumber(".-4"));
        System.out.println(" -." + isNumber(" -."));*/
        System.out.println(".1" + isNumber(".1"));
    }

    private static final int START = 1;
    private static final int SIGN = 2;
    private static final int DIGIT = 3;
    private static final int DOT = 4;
    private static final int E = 5;
    private static final int END = 6;
    private static final int NUMBER = 7;

    public static boolean isNumber(String s) {
        s = s.trim();
        int state = START;
        int i = 0;
        while (i < s.length()) {
            switch (state) {
            case START:
                if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                    state = SIGN;
                } else if (s.charAt(i) >= '0' || s.charAt(i) <= '9') {
                    state = DIGIT;
                } else if (s.charAt(i) == '.') {
                    state = DOT;
                }else{
                    return false;
                }
                break;
            case SIGN:
                i++;
                state = DIGIT;
                break;
            case E:
                i++;
                state = NUMBER;
                break;
            case DIGIT:
                boolean hasDigits = false;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    hasDigits = true;
                    i++;
                }
                if(! hasDigits) return false;
                if (i == s.length()) {
                    state = END;
                } else if (s.charAt(i) == '.') {
                    state = DOT;
                } else if (s.charAt(i) == 'e') {
                    state = E;
                }else{
                    return false;
                }
                break;
            case NUMBER:
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    i++;
                }
                if (i == s.length()) {
                    state = END;
                }else{
                    return false;
                }
                break;
            case DOT:
                i++;
                if (i == s.length()) {
                    state = END;
                } else if (s.charAt(i) >= '0' || s.charAt(i) <= '9') {
                    state = DIGIT;
                } else {
                return false;
                }
                break;
            case END:
            }

        }
        return state == END;
    }

}
