public class CDNCacheOverflow {

    public static int crashTime(int[] add, int[] remove, int capacity) {

        long cache = 0;
        int crashStart = -1;

        for (int i = 0; i < add.length; i++) {

            cache = cache + add[i] - remove[i];

            if (cache > capacity) {
                if (crashStart == -1) {
                    crashStart = i;
                }
            } else {
                crashStart = -1; // recovered
            }
        }

        return crashStart;
    }

    public static void main(String[] args) {

        int[] add = {5, 7, 4, 6, 2, 1};
        int[] remove = {0, 0, 3, 2, 8, 0};
        int capacity = 10;

        System.out.println(crashTime(add, remove, capacity));
    }
}
