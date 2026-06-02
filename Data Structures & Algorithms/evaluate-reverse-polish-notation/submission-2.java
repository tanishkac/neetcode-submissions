class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
     

        for(String token : tokens) {

            if(token.equals("+")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                int ans = val1 + val2;
                stack.push(ans);
            }
            else if(token.equals("*")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                int ans = val1 * val2;
                stack.push(ans);
            }
            else if(token.equals("-")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                int ans = val2 - val1;
                stack.push(ans);
            }
            else if(token.equals("/")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                int ans = val2 / val1;
                stack.push(ans);
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
