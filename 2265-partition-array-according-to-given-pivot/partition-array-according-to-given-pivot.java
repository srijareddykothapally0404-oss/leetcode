class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] a=new int[nums.length];
        int[] b=new int[nums.length];
        int w=0;
        int e=0;
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                a[w++]=nums[i];
            }else if(nums[i]==pivot){
                c++;
            }else{
                b[e++]=nums[i];
            }
        }
        int[] res=new int[nums.length];
        int i=0;
        for(int j=0;j<w;j++){
            res[i++]=a[j];
        }
        while(c-->0){
            res[i++]=pivot;
                    }
          for(int j=0;j<e;j++){
            res[i++]=b[j];
        }           
       return res;        
    }
}