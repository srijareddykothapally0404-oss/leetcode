class Solution {
    public String lexGreaterPermutation(String s, String target) {
                int[] freq=new int[26];

        for(char c:s.toCharArray())
            freq[c-'a']++;

        for(int i=0;i<s.length();i++){
            int t=target.charAt(i)-'a';

            if(freq[t]>0){
                freq[t]--;
            }else{
                for(int c=t+1;c<26;c++){
                    if(freq[c]>0)
                        return build(target,i,freq,c);
                }
                break;
            }
        }

        for(int i=s.length()-1;i>=0;i--){
            int[] f=new int[26];

            for(char c:s.toCharArray())
                f[c-'a']++;

            boolean ok=true;

            for(int j=0;j<i;j++){
                int c=target.charAt(j)-'a';

                if(f[c]==0){
                    ok=false;
                    break;
                }

                f[c]--;
            }

            if(!ok) continue;

            int t=target.charAt(i)-'a';

            for(int c=t+1;c<26;c++){
                if(f[c]>0)
                    return build(target,i,f,c);
            }
        }

        return "";
    }

    private String build(String target,int i,int[] freq,int c){
        StringBuilder ans=new StringBuilder(target.substring(0,i));
        ans.append((char)('a'+c));
        freq[c]--;

        for(int x=0;x<26;x++){
            while(freq[x]>0){
                ans.append((char)('a'+x));
                freq[x]--;
            }
        }

        return ans.toString();

    }
}