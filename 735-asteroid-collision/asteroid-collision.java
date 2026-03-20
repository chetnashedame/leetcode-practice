class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
       for (int ast : asteroids) {
            boolean alive = true;

            while (alive && !stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                if (Math.abs(stack.peek()) < Math.abs(ast)) {
                    stack.pop(); // top explodes
                } 
                else if (Math.abs(stack.peek()) == Math.abs(ast)) {
                    stack.pop(); // both explode
                    alive = false;
                } 
                else {
                    alive = false; // current explodes
                }
            }

            if (alive) {
                stack.push(ast);
            }
        }


        int [] res=new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}