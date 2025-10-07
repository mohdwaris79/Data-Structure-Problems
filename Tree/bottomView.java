import java.util.*;

// Node structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class bottomView {

    public static ArrayList<Integer> bottomViews(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Map<Integer, Integer> hdNode = new TreeMap<>();

        // Queue for BFS: stores node + horizontal distance
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node node = p.node;
            int hd = p.hd;

            // For Bottom View -> overwrite value at hd
            hdNode.put(hd, node.data);

            if (node.left != null)
                q.add(new Pair(node.left, hd - 1));
            if (node.right != null)
                q.add(new Pair(node.right, hd + 1));
        }

        // Collect results from map
        for (int val : hdNode.values()) {
            ans.add(val);
        }
        return ans;
    }

    // Helper class for queue
    static class Pair {
        Node node;
        int hd; // horizontal distance

        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }

    // Driver code
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        ArrayList<Integer> res = bottomViews(root);
        System.out.println(res);
    }
}
