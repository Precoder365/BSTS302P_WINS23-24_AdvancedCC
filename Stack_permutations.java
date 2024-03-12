import java.util.*;

public class Main{
    static Boolean checkPermutation(int[] input, int[] output, int n){
        Stack<Integer> s=new Stack<Integer>();
        
        int j=0;
        for(int i=0;i<n;i++){
            s.push(input[i]);
            while(!s.isEmpty() && s.peek()==output[j]){
                s.pop();
                j++;
            }
        }
        
        if(s.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int input[]=new int[n];
        int output[]=new int[n];
        for(int i=0;i<n;i++){
            input[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            output[i]=sc.nextInt();
        }
        
        if(checkPermutation(input,output,n)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
