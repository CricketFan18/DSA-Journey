import java.util.*;

public class GenP {
    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder("(");

    public List<String> generateParenthesis(int n) {
        backtrack(n, 1, 0);
        return result;
    }

    public void backtrack(int limit, int open, int close) {
        if (path.length() == limit * 2) {
            result.add(path.toString());
            return;
        }
        if (open < limit) {
            path.append('(');
            backtrack(limit, open+1, close);
            path.deleteCharAt(path.length()-1);
        }
        if (close < open) {
            path.append(')');
            backtrack(limit, open, close+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
