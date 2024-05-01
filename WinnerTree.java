import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> players = new ArrayList<>(Arrays.asList(3, 7, 1, 9, 4, 2, 8, 5));
        int minVal=Collections.min(players);
        int winnerIndex = players.indexOf(minVal);
        System.out.println("The player with the highest score is at index: " + (winnerIndex+1));
        System.out.println("The score of the winning player is: " + players.get(winnerIndex));
    }
}
