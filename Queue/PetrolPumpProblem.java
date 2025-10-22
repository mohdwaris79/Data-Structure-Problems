public class PetrolPumpProblem {

    
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;

        int start = 0;       
        int deficit = 0;     
        int balance = 0;    

        for (int i = 0; i < n; i++) {
            balance += petrol[i] - distance[i];

            
            if (balance < 0) {
                start = i + 1;        
                deficit += balance;   
                balance = 0;          
            }
        }

        if (balance + deficit >= 0) {
            return start;
        }

        return -1; 
    }

   
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int startIndex = findStartingPoint(petrol, distance);
        if (startIndex != -1) {
            System.out.println("Truck can start at petrol pump index: " + startIndex);
        } else {
            System.out.println("No possible starting point to complete the tour.");
        }
    }
}
