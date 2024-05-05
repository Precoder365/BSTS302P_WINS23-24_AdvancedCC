import java.util.*;

public class Main {
    public static void findLongestBitonicSubsequence(int[] arr, int n) {
        if(arr==null || n==0) return;
        
        List<List<Integer>> lis = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lis.add(new ArrayList<>());
        }
        
        lis.get(0).add(arr[0]);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (lis.get(i).size() < lis.get(j).size() && arr[i] > arr[j]) {
                    lis.set(i, new ArrayList<>(lis.get(j)));
                }
            }
            lis.get(i).add(arr[i]);
        }
        
        List<List<Integer>> lds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lds.add(new ArrayList<>());
        }
        
        lds.get(n - 1).add(0, arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (lds.get(i).size() < lds.get(j).size() && arr[i] > arr[j]) {
                    lds.set(i, new ArrayList<>(lds.get(j)));
                }
            }
            lds.get(i).add(0, arr[i]);
       }
        
        int peakIndex = 0;
        for (int i = 1; i < n; i++) {
            if ((lis.get(i).size() + lds.get(i).size()) >
                (lis.get(peakIndex).size() + lds.get(peakIndex).size())) {
                peakIndex = i;
            }
        }
        System.out.print(lis.get(peakIndex));
        lds.get(peakIndex).remove(0);
        System.out.println(lds.get(peakIndex));
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        findLongestBitonicSubsequence(arr,n);
    }
}
