import java.util.ArrayList;
import java.util.List;

public class MaximizeActiveSection {
    public int maxActiveSectionsAfterTrade(String s) {
        List<StringBuilder> blocks = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        char prev = s.charAt(0);
        word.append(prev);
        int count = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '1')
                count++;
            char curr = i == s.length() ? ' ' : s.charAt(i);
            if (curr == prev) {
                word.append(curr);
            } else {
                blocks.add(word);
                word = new StringBuilder();
                word.append(curr);
                prev = curr;
            }
        }
        int maxCount = count;
        for (int i = 1; i < blocks.size() - 1; i++) {
            if (blocks.get(i).charAt(0) == '1') {
                int delta = blocks.get(i - 1).length() + blocks.get(i + 1).length();
                maxCount = Math.max(maxCount, count + delta);
            }
        }
        return maxCount;
    }
}
