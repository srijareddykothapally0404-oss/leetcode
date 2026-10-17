class Solution {
    public int minSwaps(int[] nums) {
          int n=nums.length;
        Integer[] a=new Integer[n];

        for(int i=0;i<n;i++){
            a[i]=nums[i];
        }

        Arrays.sort(a,(x,y)->{
            int s=0,t=0;
            int p=x,q=y;

            while(p>0){
                s+=p%10;
                p/=10;
            }

            while(q>0){
                t+=q%10;
                q/=10;
            }

            if(s!=t)return s-t;
            return x-y;
        });

        Map<Integer,Integer> m=new HashMap<>();

        for(int i=0;i<n;i++){
            m.put(a[i],i);
        }

        boolean[] v=new boolean[n];
        int ans=0;

        for(int i=0;i<n;i++){
            if(v[i]||m.get(nums[i])==i)continue;

            int j=i,c=0;

            while(!v[j]){
                v[j]=true;
                j=m.get(nums[j]);
                c++;
            }

            ans+=c-1;
        }

        return ans;
        
    }
}