import java.util.*;
public class SortCharactersByFreq {
    public static String frequencySort(String s) {
        StringBuilder ans = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue()); //sort in descending order

        for (Map.Entry<Character, Integer> entry : list) 
        {
            ans.append(String.valueOf(entry.getKey()).repeat(entry.getValue())); // Repeat character
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String ans = frequencySort(str);
        System.out.println(ans);
        sc.close();
    }
}
