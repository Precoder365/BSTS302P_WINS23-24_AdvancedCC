import java.util.*;

class MyStack{
    Stack<Integer> s1;
    Stack<Integer> s2;
    
    public MyStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int data){
        s1.push(data);
        
        if(s2.isEmpty()){
            s2.push(data);
            return;
        }
        
        int top=s2.peek();
        if(top>data){
            s2.push(data);
        }
        else{
            s2.push(top);
        }
    }
    
    public void pop(){
        if(s1.isEmpty()){
            System.out.println("Stack is empty.. cannot pop");
            return;
        }
        s1.pop();
        s2.pop();
    }
    
    public int minEle(){
        if(s1.isEmpty()){
            System.out.println("Stack is empty.. cannot find min");
            return -1;
        }
        return s2.peek();
    }
    
    public int top(){
        if(s1.isEmpty()){
            System.out.println("Stack is empty.. cannot peek");
            return -1;
        }
        return s1.peek();
    }
}

class Main{
    public static void main(String[] args){
        MyStack s1=new MyStack();
        
        s1.push(10);
        s1.push(15);
        s1.push(1);
        
        System.out.println(s1.minEle());
        
        s1.pop();
        s1.pop();
        s1.pop();
        s1.pop();
        
        s1.push(100);
        s1.push(50);
        
        System.out.println(s1.minEle());
        
    }
}
