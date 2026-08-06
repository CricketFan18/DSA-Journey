import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SectorCapital {

    int countCaptials = 0;

    private int preOrder(int node, int parent, List<List<Integer>> tree, int[] v) {
        int subTreeSum = 0;
        for (int nbr : tree.get(node)) {
            if (nbr == parent)
                continue;

            subTreeSum += preOrder(nbr, node, tree, v);
        }
        if (subTreeSum > v[node])
            countCaptials++;

        return subTreeSum + v[node];
    }

    public int countSectorCapital(int n, int[][] edges, int[] v, int k) {
        List<List<Integer>> tree = new ArrayList<>();
        for(int[] edge : edges)
        {
            
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

    }

}