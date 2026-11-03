class Solution {
    public int minMoves(int[] nums) {
            Arrays.sort(nums);
            int l=nums[nums.length-1];
            int c=0;
            for(int i=0;i<nums.length;i++){
                c+=l-nums[i];
            }
            return c;
    }
}