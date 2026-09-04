class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int ans=-1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int min=nums[i];
            int max=nums[i];
            for(int j=0;j<=i;j++){
                max=Math.max(max,nums[j]);
            }
            for(int ki=i;ki<n;ki++){
                min=Math.min(min,nums[ki]);
            }
            int x=max-min;
            if(x<=k){
                return i;
            }
        }
        return ans;
    }
}