public class RideSharingProblem {
    


    public static int surgeTrigger(int[] demand, int[] supply, int threshold) {

        int surgeStart = -1;

        for (int i = 0; i < demand.length; i++) {
            int excess = demand[i] - supply[i];

            if (excess >= threshold) {
                if (surgeStart == -1) {
                    surgeStart = i;
                }
            } else {
                surgeStart = -1; // surge ended
            }
        }

        return surgeStart;
    }

    public static void main(String[] args) {

        int[] demand = {10, 12, 8, 15, 20};
        int[] supply = {10, 10, 9, 12, 15};
        int threshold = 2;

        System.out.println(surgeTrigger(demand, supply, threshold));
    }
}
