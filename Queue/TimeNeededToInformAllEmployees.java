import java.util.*;

public class TimeNeededToInformAllEmployees {

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                adj.get(manager[i]).add(i);
            }
        }

        
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{headID, 0});
        int totalTime = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int empId = curr[0];
            int timeSoFar = curr[1];

            
            totalTime = Math.max(totalTime, timeSoFar);

            
            for (int sub : adj.get(empId)) {
                q.add(new int[]{sub, timeSoFar + informTime[empId]});
            }
        }

        return totalTime;
    }

    public static void main(String[] args) {
        int n = 6;
        int headID = 2;
        int[] manager = {2, 2, -1, 2, 2, 2};
        int[] informTime = {0, 0, 1, 0, 0, 0};

        int result = numOfMinutes(n, headID, manager, informTime);
        System.out.println("Total time needed to inform all employees: " + result);
    }
}
