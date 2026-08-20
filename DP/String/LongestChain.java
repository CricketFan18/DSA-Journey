import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestChain {
    int dfs(Set<String> set, String word, Map<String, Integer> memo) {
        if (!set.contains(word)) {
            return 0;
        }
        if (memo.containsKey(word)) {
            return memo.get(word);
        }
        int maxChain = 1;

        for (int i = 0; i < word.length(); i++) {
            String newWord = word.substring(0, i) + word.substring(i + 1);

            int currentChainLength = 1 + dfs(set, newWord, memo);
            maxChain = Math.max(maxChain, currentChainLength);
        }

        memo.put(word, maxChain);
        return maxChain;
    }

    int solveMem(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }

        Map<String, Integer> memo = new HashMap<>();
        int maxAns = 0;

        for (String word : words) {
            maxAns = Math.max(maxAns, dfs(set, word, memo));
        }

        return maxAns;
    }

    int solveTab(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> dp = new HashMap<>();
        int maxLength = 0;
        for (String word : words) {
            int currentBest = 1;
            for (int i = 0; i < word.length(); i++) {
                String newWord = word.substring(0, i) + word.substring(i + 1);

                if (dp.containsKey(newWord))
                    currentBest = Math.max(currentBest, 1 + dp.get(newWord));
            }
            dp.put(word, currentBest);
            maxLength = Math.max(maxLength, currentBest);
        }
        return maxLength;
    }

    public int longestStrChain(String[] words) {
        return solveTab(words);
    }
}