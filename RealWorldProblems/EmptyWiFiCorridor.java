import java.util.*;

class EmptyWiFiCorridor {
    public static int maxCorridor(int[] router) {
        Arrays.sort(router);
        
        int maxGap = 0;
        
        for (int i = 1; i < router.length; i++) {
            maxGap = Math.max(maxGap, router[i] - router[i - 1]);
        }
        
        return maxGap;
    }

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] router = new int[n];

    for (int i = 0; i < n; i++) {
        router[i] = sc.nextInt();
    }

    System.out.println(maxCorridor(router));

    sc.close();
}

}

