import java.util.*;

class Node{
    int data;
    int priority;
    Node next;
    Node prev;
    
    public Node(int data,int priority){
        this.data=data;
        this.priority=priority;
        next=null;
        prev=null;
    }
}

class MyPriorityQueue{
    Node head;
    
    MyPriorityQueue(){
        head=null;
    }
    
    public void push(int data, int priority){
        if(head==null){
            Node newNode=new Node(data,priority);
            head=newNode;
            return;
        }
        
        Node temp=head;
        
        while(temp!=null && temp.priority<=priority){
            temp=temp.next;
        }
        
        Node newNode=new Node(data,priority);
        
        if(temp == head) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } 
        else {
            Node insertPos=temp.prev;
            insertPos.next=newNode;
            newNode.prev=insertPos;
            newNode.next=temp;
            temp.prev=newNode;
        }
            
    }
    
    public int peek(){
        if(head==null){
            System.out.println("The pq is empty");
            return -1;
        }
        return head.data;
    }
    
    public void pop(){
        if(head==null){
            System.out.println("The pq is empty");
            return;
        }
        head=head.next;
    }
    
}

public class Main{
    public static void main(String[] args){
        MyPriorityQueue pq=new MyPriorityQueue();
        
        pq.push(10,3);
        pq.push(20,1);
        pq.push(30,2);
        
        System.out.println(pq.peek());
        
        
    }
}
