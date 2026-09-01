import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinConsecutiveCardsToPickUp {
    public int minimumCardPickup(int[] cards) {
        Map<Integer,List<Integer>> indexes = new HashMap<>();
        for(int i=0;i<cards.length;i++)
        {
            int card = cards[i];
            if(!indexes.containsKey(card))
                indexes.put(card, new ArrayList<>());
            indexes.get(card).add(i);
        }
        int minLen = Integer.MAX_VALUE;
        for(Map.Entry<Integer,List<Integer>> entry : indexes.entrySet())
        {
            if(entry.getValue().size() < 2)
                continue;
            List<Integer> ar = entry.getValue();
            for(int i=1;i<ar.size();i++)
            {
                minLen = Math.min(minLen,ar.get(i)-ar.get(i-1)+1);
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
