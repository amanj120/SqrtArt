import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class newton {

    private static int length = 4999999;

    private static BigDecimal xo = BigDecimal.valueOf(4.35889894354);
    public static final BigDecimal root = BigDecimal.valueOf(19.0);
    public static void main(String[] args) throws IOException {

        for(int i = 0; i < 100; i++) {
            System.out.println(i);
            BigDecimal xa = iter(xo);
            if(xo.toString().length() > length + 2) {
                if (xa.toString().substring(0, length + 2).equals(xo.toString().substring(0, length + 2))) {
                    break;
                }
            }
            xo = xa;
        }
        FileWriter w = new FileWriter("out1.txt");
        String s = xo.toPlainString().substring(0, length + 2);
        w.write(s);
        w.close();
        //w.write(xo.toString()+ "\n");
        //w.write(xo.multiply(xo).toString());
        System.out.println(xo);
        //String ss = toSix(xo);
        //String six = ss.charAt(0) + "." + ss.substring(1);
        //System.out.println(six);
        //System.out.println(ss);

    }

    public static BigDecimal iter(BigDecimal x) {
        return BigDecimal.valueOf(0.5).multiply(x.add(root.divide(x, length, RoundingMode.FLOOR)));
    }

    public static String toSix(BigDecimal x) {
        char[] letters = {'s', 'r', 'u', 't', 'h', 'i'};
        BigDecimal pow = BigDecimal.ZERO;
        String ret = "";
        BigDecimal xx = x;
        BigDecimal d= BigDecimal.ONE.divide(BigDecimal.valueOf(6.0), length, BigDecimal.ROUND_FLOOR);
        //System.out.println("DIV:\t" + d);
        int p = 0;
        for (int i = 0; i < length; i++) {
            BigDecimal div = d.pow(p);
            //System.out.println();
            p++;
            BigDecimal[] t = x.divideAndRemainder(div, MathContext.DECIMAL128);
//            System.out.println();
//            System.out.println(p);
//
//            System.out.println(x);
//            System.out.println(div);
//            System.out.println(t[0].intValue());
//            System.out.println(t[1]);
            x = t[1];
            ret += t[0].intValue();
            System.out.print(t[0].intValue());
//            System.out.println(ret);
//            System.out.println();
        }
        return ret;

    }
}
