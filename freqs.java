import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class freqs {
    public static void main(String[] args) throws IOException {
        FileReader data = new FileReader("out1.txt");
        FileReader freq = new FileReader("frequencies");
        FileWriter w = new FileWriter("letters");
        Scanner sc;
        sc = new Scanner(freq);
        int[] range = new int[27];
        char[] l = new char[26];
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            char letter = sc.next().charAt(0);
            int value = (int) (1000.0 * Double.parseDouble(sc.next().replace('%', ' ').trim()));
            sum += value;
            //System.out.println(letter + ": [" + (sum-value) + " , " + sum + ")");
            range[i+1] = sum;
            l[i] = letter;
        }
        range[26]++;
        //System.out.println(Arrays.toString(range));
        //System.out.println(Arrays.toString(l));
        sc = new Scanner(data);
        String s = sc.nextLine();
        s = s.charAt(0) + s.substring(2);
        int count = 0;
        for(int i = 0; i < s.length(); i+=5) {
            int k = Integer.parseInt(s.substring(i, i+5));
            for(int idx = 1; idx < 27; idx++) {
                if(k >= range[idx - 1] && k < range[idx]) {
                    w.write(l[idx-1]);
                    count++;
                    break;
                }
            }
            if(count == 1000) {
                w.write("\n");
                count = 0;
            }

        }
        w.close();
    }
}
