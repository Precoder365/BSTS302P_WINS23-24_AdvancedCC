import java.util.*;

class Main{
    public static void toh(int n, char from, char to, char aux){
        if(n==0) return;
        
        toh(n-1,from,aux,to);
        System.out.println("Disk "+n+" from rod "+from+" to rod "+to);
        toh(n-1,aux,to,from);
    }
    
    public static void main(String[] args){
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        
        toh(n,'A','C','B');
    }
}
