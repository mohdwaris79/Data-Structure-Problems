class AntFallOutProblem {

    public int getLastMoment(int n, int left[], int right[]) {

        int maxTime = 0;

        for (int pos : left) {
            maxTime = Math.max(maxTime, pos);
        }

        for (int pos : right) {
            maxTime = Math.max(maxTime, n - pos);
        }

        return maxTime;
    }

    public static void main(String args[]) {

        int n = 5;
        int left[] = {4, 3};
        int right[] = {0, 1};

        AntFallOutProblem obj = new AntFallOutProblem();
        System.out.println(obj.getLastMoment(n, left, right));
    }
}
