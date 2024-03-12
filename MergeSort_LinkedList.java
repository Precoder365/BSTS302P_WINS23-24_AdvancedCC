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
    
    public static void printList(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    
    public static Node midpoint(Node head){
        // if(head==null || head.next==null) return head;
        
        Node fast=head;
        Node slow=head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
    }
    
    public static Node merge(Node head1, Node head2){
        if(head1==null) return head2;
        if(head2==null) return head1;
        
        Node t1=head1;
        Node t2=head2;
        
        Node sortedHead=null;
        Node sortedTail=null;
        
        if(t1.data<t2.data){
            sortedHead=t1;
            sortedTail=t1;
            t1=t1.next;
        }
        else{
            sortedHead=t2;
            sortedTail=t2;
            t2=t2.next;
        }
        
        while(t1!=null && t2!=null){
            if(t1.data<t2.data){
                sortedTail.next=t1;
                t1=t1.next;
                sortedTail=sortedTail.next;
            }
            else{
                sortedTail.next=t2;
                t2=t2.next;
                sortedTail=sortedTail.next;
            }
        }
        
        if(t1!=null){
            sortedTail.next=t1;
        }
        if(t2!=null){
            sortedTail.next=t2;
        }
        
        return sortedHead;
        
    }
    
    public static Node mergeSort(Node head){
        if(head==null || head.next==null) return head;
        
        Node midNode=midpoint(head);
        Node leftHead=head;
        Node rightHead=midNode.next;
        
        midNode.next=null;
        
        Node l=mergeSort(leftHead);
        Node r=mergeSort(rightHead);
        
        return merge(l,r);
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        Node head=null;
        
        for(int i=0;i<n;i++){
            int data=sc.nextInt();
            head=insertNode(head,data);
        }
        
        Node newHead=mergeSort(head);
        
        printList(newHead);
        
    }
}
