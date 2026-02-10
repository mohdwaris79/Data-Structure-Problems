import java.util.ArrayList;
import java.util.List;
public class AsynchronousResultProcessing {

    long fuel =0;                                  // Initialze the fuel 
    int seats =4;                                  // Initialize the seats
   public long minimumFuelCost(int [][] roads, int weights[]){

   
    List<List<int[]>>graph=new ArrayList<>();
     int n = roads.length+1;

    for(int i=0; i<n;i++)
    {
        graph.add(new ArrayList<>());
    }
    for(int i=0;i<roads.length;i++)
    {
        int u=roads[i][0];
        int v = roads[i][1];
        int w= weights[i];

        graph.get(u).add(new int[]{v,w});
        graph.get(v).add(new int[]{u,w});
    }
    dfs(0,-1,graph);
    return fuel;
   }
   private  int dfs(int node, int parent, List<List<int[]>>graph){
    int people =(node==0)?0:1;                  // single person on every junction and in node 0 will be zero.
    for(int edge[]:graph.get(node))
    {
        int next=edge[0];
        int cost=edge[1];

        if(next==parent)continue;

        int childPeople = dfs(next, node, graph);

         int cars= (childPeople+seats-1)/seats;           // finding the person at particular node and pass on top and then add on top 

            fuel+=(long) cars*cost;                          // fuel will be depend on the cars * cost (means the cost of the edge)
            people+=childPeople;                             // adding the people through passing on the top
        }
        return people;                                       // return total people who sit on the car
    }
    public static void main(String[] args) {
    AsynchronousResultProcessing arp = new AsynchronousResultProcessing();

    // Example input
    // Roads: connections between junctions
    int[][] roads = {
        {0, 1},
        {1, 2},
        {1, 3}
    };


    int[] weights = {1, 2, 3};  // fuel cost for each road


    long result = arp.minimumFuelCost(roads,weights);
    System.out.println("Minimum Fuel Cost: " + result);
}
}


    



