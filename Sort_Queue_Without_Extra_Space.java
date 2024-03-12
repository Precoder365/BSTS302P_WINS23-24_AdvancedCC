import java.util.*;

class Main
{ 
	public static void main (String[] args) 
	{ 
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		for(int i=0;i<n;i++){
		    list.add(sc.nextInt());
		}
		
	
		Collections.sort(list);
		
		for(int i=0;i<list.size();i++){
		    System.out.print(list.get(i)+" "); 
		}
	} 
} 

