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
    
    public static Node oddEve(Node head){
        if(head==null || head.next==null) return head;
        
        Node oddPtr=head;
        Node evePtr=head.next;
        
        Node eveHead=head.next;
        
        while(evePtr!=null && evePtr.next!=null){
            oddPtr.next=oddPtr.next.next;
            evePtr.next=evePtr.next.next;
            
            oddPtr=oddPtr.next;
            evePtr=evePtr.next;
        }
        
        oddPtr.next=eveHead;
        
        return head;
    }
    
    public static void printList(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        Node head=null;
        
        for(int i=0;i<n;i++){
            int data=sc.nextInt();
            head=insertNode(head,data);
        }
        
        Node newHead=oddEve(head);
        
        printList(head);
        
    }
}
