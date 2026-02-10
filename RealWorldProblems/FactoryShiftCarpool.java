
import java.util.*;
public class FactoryShiftCarpool {

 // .........................................Single Person On Every Junction..................................................
    // cab picking problem follow dfs using adjacency list
    // weighted edge and every junction has one person
    // cost will be calculate according edge cost * cars
    long fuel=0;   // follow the constraints so we use the long for fuel
    int seats=4;   // seats is limited so use int

    public long minimumFuelCost(int [][] roads, int weights[])
    {
        int n=roads.length+1;       // for x edge there will x+1 nodes


        // Adjacency List

        List<List<int[]>> graph =new ArrayList<>();


        // apply the loop on the node and create empty arraylist
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }



        // Apply the loops on the edge
        for(int i=0;i<roads.length;i++)
        {
            int u=roads[i][0];       // for bottom up
            int v=roads[i][1];       // for top to bottom
            int w= weights[i];

            graph.get(u).add(new int[]{v,w});  // for bottom up
            graph.get(v).add(new int[]{u,w}); // for top to bottom
        }

        dfs(0,-1,graph);                // call the dfs function
        return fuel;
    }

    private  int dfs(int node, int parent, List<List<int[]>>graph)
    {
        int people =(node==0)?0:1;            // when every junction have only single person then 1 and if node is 0 means zero.

        for(int []edge:graph.get(node))       // getting the edge of the tree
        {

            int next =edge[0];                
            int cost=edge[1];

            if(next==parent) continue;        

            int childPeople =dfs(next, node, graph);
            int cars= (childPeople+seats-1)/seats;           // finding the person at particular node and pass on top and then add on top 

            fuel+=(long) cars*cost;                          // fuel will be depend on the cars * cost (means the cost of the edge)
            people+=childPeople;                             // adding the people through passing on the top
        }
        return people;                                       // return total people who sit on the car
    }


    
public static void main(String[] args) {
    FactoryShiftCarpool fsc = new FactoryShiftCarpool();

    // Example input
    // Roads: connections between junctions
    int[][] roads = {
        {0, 1},
        {1, 2},
        {1, 3}
    };

    // c[i] = number of people at node i
    int[] c = {1, 2, 3, 4};

    long result = fsc.minimumFuelCost(roads, c);
    System.out.println("Minimum Fuel Cost: " + result);
}
}
