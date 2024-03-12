import java.util.*;

class Node{
    int data;
    Node next;
    Node prev;
        
    Node(int data){
        this.data=data;
        next=null;
        prev=null;
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
        node.prev=temp;
        
        return head;
    }
    
    public static void printList(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    
    public static Node findBreakPoint(Node head){
        Node temp=head;
        
        while(temp!=null){
            if(temp!=head && temp.data<temp.prev.data){
                break;
            }
            temp=temp.next;
        }
        
        if(temp==null){
            return head;
        }
        
        return temp.prev;
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
            t2=t2.prev;
        }
        
        while(t1!=null && t2!=null){
            if(t1.data<t2.data){
                sortedTail.next=t1;
                t1=t1.next;
                sortedTail=sortedTail.next;
            }
            else{
                sortedTail.next=t2;
                t2=t2.prev;
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
    
    public static Node sortBitonic(Node head){
        if(head==null || head.next==null) return head;
        
        Node pivot=findBreakPoint(head);
        
        Node leftHead=head;
        
        Node rightHead=pivot.next;
        while(rightHead.next!=null){
            rightHead=rightHead.next;
        }
        
        Node t=pivot.next;
        pivot.next=null;
        t.prev=null;
        
        return merge(leftHead,rightHead);
 
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        Node head=null;
        
        for(int i=0;i<n;i++){
            int data=sc.nextInt();
            head=insertNode(head,data);
        }
        
        Node newHead=sortBitonic(head);
        
        printList(newHead);
        
    }
}
