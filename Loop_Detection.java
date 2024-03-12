import java.util.*;

class Node{
        int data;
        Node next;
            
        Node(int data){
            this.data=data;
            next=null;
        }
}
    
public class Main{
    public static Node insertNode(Node head, int data){
        Node node=new Node(data);
        
        if(head==null){
            return node;
        }
        
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        
        return head;
    }
    
    public static boolean checkCycle(Node head){
        if(head==null) return false;
        
        Node slow=head;
        Node fast=head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow==fast){
                return true;
            }
        }
        
        return false;
        
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        Node head=null;
        
        for(int i=0;i<n;i++){
            int data=sc.nextInt();
            head=insertNode(head,data);
        }
        
        if(checkCycle(head)){
            System.out.println("Cycle");
        }
        else{
            System.out.println("No cycle");
        }
        
    }
}
