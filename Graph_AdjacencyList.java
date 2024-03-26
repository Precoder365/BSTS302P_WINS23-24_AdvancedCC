import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int v=sc.nextInt();
        int e=sc.nextInt();
        
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            lst.add(new ArrayList<>());
        }
        
        for(int i=0;i<e;i++){
            int s=sc.nextInt();
            int d=sc.nextInt();
            
            lst.get(s).add(d);
        }
    }
}
