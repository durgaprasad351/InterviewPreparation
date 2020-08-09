package strings;

public class SpreedSheetColumnEncoding {

    public static void main(String[] args) {
        System.out.println(spreadSheetDecoding("AA") == 27 );
        System.out.println(spreadSheetDecoding("D") == 4 );
        System.out.println(spreadSheetDecoding("ZZ") == 702 );
    }

    public static int spreadSheetDecoding(String col){
        int res =0;
        for(int i=0; i< col.length(); i++){
            res +=  (col.charAt(i) - 'A' +1) * Math.pow(26, col.length() - i -1);
        }
        return res;
    }
}
