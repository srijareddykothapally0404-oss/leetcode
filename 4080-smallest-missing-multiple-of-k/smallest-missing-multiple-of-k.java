class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int x:nums){
            set.add(x);
        }
        int x=k;
                 while(set.contains(x)){
                   x+=k;
                 }
        
return x;
    }
}