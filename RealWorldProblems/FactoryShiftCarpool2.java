
import java.util.ArrayList;
import java.util.List;

public class FactoryShiftCarpool2 {

    long fuel =0;               // Initialize the fuel
    int seats =4;               // Initialize the seats of the car which will always 4 including driver

    public long minimumFuelCost(int [][] roads, int weights[], int c[])
    {
    List<List<int[]>> graph=new ArrayList<>();           // Adjacency List

    int n = roads.length+1;                              // finding the length of the nodes thats why we add 1

    for(int i =0;i<n;i++)                                // apply the loop on the node
    {
        graph.add(new ArrayList<>());                   // add the empty arraylist for node
    }
    for(int i =0; i<roads.length;i++)                   // apply the loop on the edges
    {
        int u= roads[i][0];                             // Referencing the bottom up
        int v = roads[i][1];                            // Referencing the top to bottom
        int w= weights[i];                              // Referencing the weights of the edges

        graph.get(u).add(new int []{v,w});              // finding the path from bottom up
        graph.get(v).add(new int[]{u,w});               // finding the path from top to bottom
    }

        dfs(0, -1, graph,c);                              // call the dfs function of dfs
        return fuel;                                    // return the final  cost
}
         private  int dfs(int node, int parent, List<List<int[]>>graph, int c[]){
            int people = c[node];                       // Referencing the every junctions have single person

            for(int edge[]:graph.get(node))             
            {
                int next=edge[0];
                int cost= edge[1];
             
                  if(next==parent) continue;        

            int childPeople = dfs(next, node, graph,c);
            int cars= (childPeople+seats-1)/seats;           // finding the person at particular node and pass on top and then add on top 

            fuel+=(long) cars*cost;                          // fuel will be depend on the cars * cost (means the cost of the edge)
            people+=childPeople;                             // adding the people through passing on the top
        }
        return people;                                       // return total people who sit on the car
    }

   public static void main(String[] args) {
    FactoryShiftCarpool2 fsc = new FactoryShiftCarpool2();

    // Example input
    // Roads: connections between junctions
    int[][] roads = {
        {0, 1},
        {1, 2},
        {1, 3}
    };

    // c[i] = number of people at node i
    int[] c = {1, 2, 3, 9};
    int[] weights = {1, 2, 3};  // fuel cost for each road


    long result = fsc.minimumFuelCost(roads,weights, c);
    System.out.println("Minimum Fuel Cost: " + result);
}
}
         
    

    

