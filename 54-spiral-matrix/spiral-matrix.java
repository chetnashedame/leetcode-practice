class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer= new ArrayList<>();
        int top=0, bot=matrix.length-1;
        int left=0, right=matrix[0].length-1;

        while(top<=bot && left<=right){
            for(int c=left; c<=right; c++)
                answer.add(matrix[top][c]);
                top++;
            
            for(int r=top; r<=bot; r++)
                answer.add(matrix[r][right]);
                right--;
            
            if(top<=bot){
                for(int c=right; c>=left; c--)
                    answer.add(matrix[bot][c]);
                    bot--;
                
            }
            if(left<=right){
                for(int r=bot; r>=top; r--)
                    answer.add(matrix[r][left]);
                    left++;
                
            }
        }  
        return answer;      
    }
}