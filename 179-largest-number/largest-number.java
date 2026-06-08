class Solution {
    public String largestNumber(int[] nums) {
        String [] stringarr= new String[nums.length];
        for(int i=0; i< nums.length; i++){
            stringarr[i]=Integer.toString(nums[i]);
        }

        //sort using custom sort comparator
    Arrays.sort(stringarr, (a,b) -> (b+a).compareTo(a+b));

    //Handle 0 case
    if(stringarr[0].equals("0")) return "0";

    StringBuilder sb = new StringBuilder(); //build a string using builder to return string o/p

    for(String s: stringarr){
        sb.append(s);
    }   
    return sb.toString();
    
    }
}