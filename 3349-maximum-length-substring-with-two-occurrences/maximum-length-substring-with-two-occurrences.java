class Solution {
    public int maximumLengthSubstring(String s) {
       int[] f=new int[26];
       int l=0,ans=0;
       for(int r=0;r<s.length();r++){
        f[s.charAt(r)-'a']++;
        while(f[s.charAt(r)-'a']>2){
            f[s.charAt(l)-'a']--;
            l++;
        }
        ans=Math.max(ans,r-l+1);
       } 
       return ans;
    }
}