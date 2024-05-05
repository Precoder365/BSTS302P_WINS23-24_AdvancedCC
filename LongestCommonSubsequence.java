import java.util.*;

public class Main{
    public static String lcs(String s1, String s2){
        int m=s1.length();
        int n=s2.length();
        
        int[][] L=new int[m+1][n+1];
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    L[i][j]=L[i-1][j-1]+1;
                }
                else{
                    L[i][j]=Math.max(L[i-1][j],L[i][j-1]);
                }
            }
        }
        
        StringBuilder sb=new StringBuilder();
        int i=m;
        int j=n;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sb.insert(0, s1.charAt(i-1));
                i--;
                j--;
            }
            else if (L[i-1][j]>L[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        
        System.out.println(lcs(s1,s2));
    }
}
