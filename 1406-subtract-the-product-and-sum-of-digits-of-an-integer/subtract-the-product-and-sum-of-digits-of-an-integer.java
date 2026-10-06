class Solution {
    public int subtractProductAndSum(int n) {
        int p=1;
        int s=0;
        int x=n;
        while(x>0){
            int r=x%10;
            p*=r;
            s+=r;
            x=x/10;
        }
        return p-s;
    }
}