class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String to: tokens){
            if (to.equals("+")|| to.equals("-")|| to.equals("*")|| to.equals("/")){
                int b= stack.pop();
                int a = stack.pop();
                if(to.equals("+")){
                    stack.push(a+b);
                }
                else if(to.equals("-")){
                    stack.push(a-b);
                }
                else if(to.equals("*")){
                    stack.push(a*b);
                }
                else{
                    stack.push(a/b);
                }
            }
            else{
                stack.push(Integer.parseInt(to));
            }
        }
        return stack.peek();
    }
}