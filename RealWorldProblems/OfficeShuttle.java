import java.util.*;
public class OfficeShuttle {



    // It is tree based problems because its not have the loop because of single way for every two junctions

    // for this problem we will use the DFS approah because from the node 0 we will move the next node
    
long fuel=0;         // Initialize the fuel is Zero
int seats=4;         // every cars have limited seats which is four
public long minimumFuelCost(int [][]roads, int []c)
{
    int n=roads.length+1;            // for the finding of the node it will be +1 of the edges

    List<List<Integer>> graph =new ArrayList<>();         // We use the arraylist
    for(int i =0; i<n;i++)      
    {
        graph.add(new ArrayList<>());                     // we will use the empty arraylist for the nodes

    }
    for(int []r:roads)                                    // apply the loop on the road
    {
        graph.get(r[0]).add(r[1]);                        // from node 0 to last node
        graph.get(r[1]).add(r[0]);                         // from last node to office or node 0
    }

    dfs(0,-1, graph, c);                           // apply dfs function according to the capacity
    return fuel;                                        // return our final cost of the fuel
}


private long dfs (int node, int parent, List<List<Integer>> graph, int []c)
{
    long people = c[ node ];                            // In one node can have multiple people
   
    for(int next:graph.get(node))
    {
        if(next==parent)
        {
            continue;
        }
         people += dfs(next, node, graph, c);
        if(node!=0)
        {
            fuel += (people+seats-1)/seats;
        }
    }
        return people;
    }

public static void main(String[] args) {
    OfficeShuttle os = new OfficeShuttle();

    // Example input
    // Roads: connections between junctions
    int[][] roads = {
        {0, 1},
        {1, 2},
        {1, 3}
    };

    // c[i] = number of people at node i
    int[] c = {1, 2, 3, 9};

    long result = os.minimumFuelCost(roads, c);
    System.out.println("Minimum Fuel Cost: " + result);
}
}