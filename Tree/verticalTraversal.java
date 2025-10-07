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

public class verticalTraversal {

    
    public static List<List<Integer>> verticalOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

    
        Map<Integer, ArrayList<Integer>> hdMap = new TreeMap<>();

        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node node = p.node;
            int hd = p.hd;

         
            hdMap.putIfAbsent(hd, new ArrayList<>());
            hdMap.get(hd).add(node.data);

            if (node.left != null) q.add(new Pair(node.left, hd - 1));
            if (node.right != null) q.add(new Pair(node.right, hd + 1));
        }

      
        for (ArrayList<Integer> list : hdMap.values()) {
            ans.add(list);
        }
        return ans;
    }

    // Helper class
    static class Pair {
        Node node;
        int hd;
        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        List<List<Integer>> res = verticalOrder(root);
        System.out.println(res);
    }
}
