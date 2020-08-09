import java.util.Arrays;
import java.util.Comparator;

public class _937_Reorder_Data_in_Log_Files {

    public static void main(String[] args) {
       String[]  res = reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"});

       for(String str : res){
           System.out.println(str);
       }
    }

    public static String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, 0, logs.length, new Comparator<String>() {

            public int compare(String s1, String s2) {
                int s1Type = s1.startsWith("let") ? 1 : 2;
                int s2Type = s2.startsWith("let") ? 1 : 2;
                if (s1Type == s2Type) {
                    if (s2Type == 1) {
                        return compareLetters(s1, s2);
                    } else {
                        return compareDigits(s1, s2);
                    }
                }
                return Integer.valueOf(s1Type).compareTo(s2Type);
            }

            public int compareLetters(String s1, String s2) {
                String[] s1Tokens = s1.split(" ");
                String[] s2Tokens = s2.split(" ");
                int s1Digit = Integer.valueOf(s1Tokens[0].replaceAll("let", ""));
                int s2Digit = Integer.valueOf(s2Tokens[0].replaceAll("let", ""));
                int i = 1;
                while (i < Math.min(s1Tokens.length, s2Tokens.length)) {
                    int comp = s1Tokens[i].compareTo(s2Tokens[i]);
                    if (comp == 0) {
                        if (s1Digit != s2Digit) {
                            return Integer.valueOf(s1Digit).compareTo(s2Digit);
                        }
                        i++;
                    }
                    return comp;
                }
                return -1;
            }

            public int compareDigits(String s1, String s2) {
                String[] s1Tokens = s1.split(" ");
                String[] s2Tokens = s2.split(" ");
                int s1Digit = Integer.valueOf(s1Tokens[0].replaceAll("dig", ""));
                int s2Digit = Integer.valueOf(s2Tokens[0].replaceAll("dig", ""));
                if (s1Digit != s2Digit) {
                    return Integer.valueOf(s1Digit).compareTo(s2Digit);
                }
                int i = 1;
                while (i < Math.min(s1Tokens.length, s2Tokens.length)) {
                    int comp = Integer.valueOf(s1Tokens[i]).compareTo(Integer.valueOf(s2Tokens[i]));
                    if (comp == 0) {
                        i++;
                    }
                    return comp;
                }
                return -1;
            }
        });

        return logs;
    }
}
