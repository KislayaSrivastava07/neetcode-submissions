class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack <Integer> stack = new Stack<>();
        for (int ass: asteroids){
            boolean destroy= false;
            while(!stack.isEmpty()&& stack.peek()> 0 &&ass<0){
                if(stack.peek()< - ass){
                    stack.pop();
                }
                else if(stack.peek()==- ass){
                    stack.pop();
                    destroy=true;
                    break;
                }
                else{
                    destroy= true;
                    break;
                }
            }
            if(!destroy){
                stack.push(ass);
            }
        }
        int [] result = new int[stack.size()];
        for(int i= stack.size()-1;i>=0;i--){
            result[i] = stack.pop();
        }   
        return result;
    }
}