import java.math.BigDecimal;

public class sqrt {

    private static BigDecimal up;
    private static BigDecimal dn;

    public static void main(String[] args) {
        System.out.println("Hello World");
        BigDecimal n = BigDecimal.valueOf(19.0);
        up = BigDecimal.valueOf(5.0);
        dn = BigDecimal.valueOf(4.0);
        String s = "";
        //BigDecimal m= dn;
        String bin = "100";
        int i = 0;
        while(true){
            BigDecimal mid = mid();
            if(sq(mid).compareTo(n) > 0) {
                up = mid;
                bin += "0";
            } else {
                dn = mid;
                bin += "1";
            }
            i++;
            s = sig(mid);
            if(i%1000 == 0) {
                System.out.println(i);
                System.out.println(octa(bin));
                if(octa(bin).contains("sruthi:)")) {
                    System.out.println("here");
                    for(int j = 0; j < 10; j++) {
                        System.out.println();
                    }
                    System.out.println(i + "\n" + octa(bin) + "\n" + s);
                }
            }

        }
        //System.out.println(s.length() - 2);
        //System.out.println(octa(bin));
    }

    private static String octa(String b) {
        char[] letters = {'b','d','h','i','r','s','t','u'};
        String ret = "";
        for(int i = 0; i < b.length(); i += 3) {
            String sub;
            try{
                sub = b.substring(i, i+3);
            } catch (StringIndexOutOfBoundsException s) {
                sub = b.substring(i);
            }
            if (sub.length() == 3) {
                int s = Integer.parseInt(sub, 2);
                ret += letters[s];
            } else {
                sub += "0000";
                sub = sub.substring(0,3);
                int s = Integer.parseInt(sub, 2);
                ret += letters[s];
            }
        }
        return ret;
    }

    private static String sig(BigDecimal mid) {
        String m = mid.toString();
        int l = m.length();
        int end = ((l - 2) * 3/10) + 2;
        return mid.toString().substring(0, end);
    }

    public static BigDecimal mid() {
        BigDecimal sum = up.add(dn);
        return sum.divide(BigDecimal.valueOf(2.0));
    }

    public static BigDecimal sq(BigDecimal i) {
        return i.multiply(i);
    }

}
