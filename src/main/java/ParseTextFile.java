import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ParseTextFile {

    public static void main(String[] args) throws IOException {

        String[] likes = new String[]{"pony","cats", "dogs","snakes", "rabbits", "school", "friends", "Daddy"};

        for(String like : likes){
            System.out.println("Lassya likes " + like);
        }
    }
}

/**
 *     public static void main(String[] args) throws IOException {
 *         FileReader reader = new FileReader("/Users/poovalin/missing_segment.log");
 *         BufferedReader bufferedReader = new BufferedReader(reader);
 *         String line = null;
 *         Set<String> hashSet = new HashSet<>();
 *
 *         while( (line = bufferedReader.readLine()) != null){
 *             try {
 *                 int start = line.indexOf("[");
 *                 int end = line.indexOf("]");
 *                 String segments = line.substring(start + 1, end);
 *                 hashSet.addAll(Arrays.asList(segments.split(",")));
 *             }catch (Exception e){
 *                 System.out.println("Error parsing " + line);
 *             }
 *         }
 *         System.out.println(hashSet.size());
 *
 *         for(String s : hashSet){
 *             System.out.print("'" + s.trim() + "',");
 *         }
 *
 *     }
 */
