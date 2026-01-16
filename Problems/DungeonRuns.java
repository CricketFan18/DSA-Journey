
public class DungeonRuns {
     public long totalScore(int hp, int[] damage, int[] requirement) {
        int n = damage.length;
        long total = 0;
        for(int i =0 ;i<n;i++){
            int tempHp = hp;
            for(int j=i;j<n;j++) {
                 tempHp -= damage[j];
                if(tempHp >= requirement[j])
                    total++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int hp = 11;
        int[] d = {3,6,7};
        int[] r = {4,2,5};
        long s = new DungeonRuns().totalScore(hp, d, r);
        System.out.println(s);
    }
}
