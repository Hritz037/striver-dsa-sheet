class Solution {
    public String longestPalindrome(String s) {
        int[][] dp=new int[s.length()][s.length()];
        dp[s.length()-1][s.length()-1]=1;
        int ans=1,start=0,end=0;
        for(int i=s.length()-2;i>=0;i--){
            for(int j=i;j<s.length();j++){
                //We need to start j from i because everywhere we want to set 
                //if(i==j)dp[i][j]=1;
                if(i==j)dp[i][j]=1;
                else if(i+1==j && s.charAt(i)==s.charAt(j)){dp[i][j]=2;
                 if(dp[i][j]>ans){ans=dp[i][j];start=i;end=j;}}
                else if(s.charAt(i)==s.charAt(j)){
                    if(dp[i+1][j-1]!=0)dp[i][j]=dp[i+1][j-1]+2;
                    if(dp[i][j]>ans){ans=dp[i][j];start=i;end=j;}
                }
            }
        }return s.substring(start,end+1);
    }
}