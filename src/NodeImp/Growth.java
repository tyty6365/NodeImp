package NodeImp;

import java.util.Comparator;
import java.util.Random;

public class Growth {
    public final static String[] GROWTHS = new String[]{
            "berries", "leaves", "flowers", "fruit", "nuts",
            "pods", "pollen sacs", "psionic tendrils"};
    final int growth;
    public Growth(int n) {
        growth = n;
    }
    public Growth(String s) {
        growth = findGrowth(s);
    }
    public Growth(Random rand) {
        growth = rand.nextInt(GROWTHS.length);
    }
    public static int findGrowth(String s) {
        for(int i=0;i<GROWTHS.length;i++) {
            if(GROWTHS[i].equals(s)) {
                return i;
            }
        }
        throw new RuntimeException(s);
    }
    public String toString() { return GROWTHS[growth]; }
    public boolean equals(Object o) {
        if(o == null) return false;
        Growth that = (Growth)o;
        return this.growth == that.growth;
    }
}
