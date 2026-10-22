class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> a=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
             if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int t=nums[i]+nums[j]+nums[k];
                if(t>0){
                    k--;
                }else if(t<0){
                    j++;
                }else{
                    a.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                     while(j<k&&nums[j]==nums[j-1]){
                        j++;
                    }

                    while(j<k&&nums[k]==nums[k+1]){
                        k--;
                    }
                }
            }
        }
        return a;
    }
}