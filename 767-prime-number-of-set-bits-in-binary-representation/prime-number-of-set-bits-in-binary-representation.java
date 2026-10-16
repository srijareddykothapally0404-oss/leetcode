class Solution {
    public static boolean isprime(int n){
        if(n<2){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public int countPrimeSetBits(int left, int right) {
        int res=0;
        for(int i=left;i<=right;i++){
            int c=0;
            int x=i;
            while(x>0){
                if((x&1)==1){
                    c++;
                }
                 x=x>>1;
                
            }
          if(isprime(c)){
            res++;
          }
        }
        return res;

    }
}