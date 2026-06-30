class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(n, "", ans);
        return ans;
    }

    public void backtrack(int n, String s, List<String> ans) {

        if (s.length() == 2 * n) {

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (ch == '(') {
                    stack.push(')');
                } else {
                    if (stack.isEmpty() || stack.pop() != ch) {
                        return;
                    }
                }
            }

            if (stack.isEmpty()) {
                ans.add(s);
            }
            return;
        }

        backtrack(n, s + "(", ans);
        backtrack(n, s + ")", ans);
    }
}