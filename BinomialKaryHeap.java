import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your choice: ");
            String choice = sc.next();

            if (choice.equals("insert")) {
                System.out.println("Enter key to insert");
                int val = sc.nextInt();

                lst.add(val);
                Collections.sort(lst);
            }
            
            else if (choice.equals("getMin")) {
                if (lst.isEmpty()) {
                    System.out.println("Empty!");
                } else {
                    System.out.println("Min ele: " + lst.get(0));
                }
            }
            
            else if (choice.equals("extractMin")) {
                if (lst.isEmpty()) {
                    System.out.println("Empty!");
                } else {
                    System.out.println("Min ele: " + lst.get(0));
                    lst.remove(0);
                }
            }
            
            else if (choice.equals("decreaseKey")) {
                System.out.println("Enter key to decrease");
                int val = sc.nextInt();

                if (lst.contains(val)) {
                    lst.remove(new Integer(val));
                    lst.add(val - 1);
                    Collections.sort(lst);
                } else {
                    System.out.println("Key not found!");
                }
            }
            
            else if (choice.equals("increaseKey")) {
                System.out.println("Enter key to increase");
                int val = sc.nextInt();

                if (lst.contains(val)) {
                    lst.remove(new Integer(val));
                    lst.add(val + 1);
                    Collections.sort(lst);
                } else {
                    System.out.println("Key not found!");
                }
            }
            
            else if (choice.equals("isEmpty")) {
                if(lst.isEmpty()){
                    System.out.println("Yes");
                }
                else{
                    System.out.println("No");
                }
            }
            
            else if (choice.equals("exit")) {
                break;
            }
            
            else {
                System.out.println("Invalid choice");
            }
        }
    }
}
