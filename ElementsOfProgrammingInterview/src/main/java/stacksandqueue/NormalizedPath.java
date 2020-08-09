package stacksandqueue;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NormalizedPath {

    public static void main(String[] args) {
        System.out.println( normalizePath("sc//./../tc/awk/./") );
        System.out.println( normalizePath("/usr/lib/../bin/gcc") );
        System.out.println( normalizePath("scripts//./../awkscripts/././") );
    }


    public static String normalizePath(String path){
        String[] tokens = path.split("/");
        ArrayDeque<String> deque = new ArrayDeque<>();
        for(String token : tokens){
            switch (token){
            case "..":
                deque.pop();
                break;
            case "." :  break;
            case "" :  break;
            default:
                deque.push(token);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (Iterator<String> it = deque.descendingIterator(); it.hasNext(); ) {
            String token = it.next();
            builder.append(token + "/");
        }
        return  builder.toString();
    }

}
