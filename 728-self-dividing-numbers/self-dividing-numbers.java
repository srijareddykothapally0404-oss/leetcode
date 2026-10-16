class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(isdiv(i)){
                list.add(i);
            }
        }
        return list;
    }
    public static boolean isdiv(int n){
        int x=n;
        while(x>0){
            int r=x%10;
            if(r==0){
                return false;
            }
            if(n%r!=0){
                return false;
            }
            x=x/10;
        }
        return true;
    }
}