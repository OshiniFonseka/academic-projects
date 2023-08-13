package CWK;

import java.util.*;

import java.io.*;

public class Task1 {
    public static void main(String[] args){
        boolean menu = true;
        Scanner input = new Scanner(System.in);
        String[] ship = new String[12];             //creating an array to store cabin data
        
        int cabinNum = 0;
        initialise(ship);

        while(menu){
            /* displaying the menu */
            System.out.println("Select an option from the menu below");
            System.out.println("A - book a new cabin");
            System.out.println("V - view all cabins");
            System.out.println("E - view all empty cabins");
            System.out.println("D - delete a customer from a cabin");
            System.out.println("F - find cabin from customer name");
            System.out.println("S - store program data into file");
            System.out.println("L - load program data from file");
            System.out.println("O - view customers ordered by name");
            String choice = input.next();
            choice = choice.toUpperCase();
            switch (choice) {
                case "A":
                    Add(ship);
                    break;
                case "V":
                    View(ship);
                    break;
                case "E":
                    Empty(ship);
                    break;
                case "D":
                    Delete(ship, cabinNum);
                    break;
                case "F":
                    Find(ship);
                    break;
                case "S":
                    Store(ship);
                    break;
                case "L":
                    Load(ship);
                    break;
                case "O":
                    Ordered(ship);
                    break;
                default:
                    System.out.println("Invalid Selection");
                    break;
            }
        }
    }

    /*initializing*/
    private static void initialise(String[] ship) {
        for (int i = 0; i < 12; i++) {
            ship[i] = ("e");
        }
    }

    // adding customers to cabins
    public static void Add(String[] ship){
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
         
        System.out.println("Enter a cabin number(0-11): ");
        int cabinNum = input.nextInt();
        System.out.println("Enter customer name for cabin number " + cabinNum + " :");
        String customerName = input1.nextLine();
        ship[cabinNum] = customerName;
    }
    
    // viewing all the cabins
    public static void View(String[] ship){
        for(int i = 0; i < ship.length; i++){
            System.out.println("cabin " + i + " occupied by " + ship[i]);
        }
    }

    //viewing all the empty cabins
    public static void Empty(String[] ship){
        for(int i = 0; i < ship.length; i++){
            if(ship[i].equals("e"))
            System.out.println("cabin " + i + " is empty");
        }
    }

    // deleting a cabin by number
    public static void Delete(String[] ship, int cabinNum){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter cabin number to delete(0-11): ");
        cabinNum = input.nextInt();
        ship[cabinNum] = ("e");
        System.out.println("deleted");
    }
    
    //finding a cabin from customer name
    public static void Find(String[] ship){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter customer name to find cabin: ");
        String customerName = input.nextLine();
        for(int i=0; i < ship.length; i++){
            if (customerName.equals(ship[i])){
                System.out.println("The cabin number is " + i );
            }
        }
    }

    // storing program data to a file
    public static void Store(String[] ship){
        try{
            FileWriter fw = new FileWriter("storing.txt",true);
            for(int i = 0; i < ship.length; i++){
                PrintWriter pw = new PrintWriter(fw);
                pw.print("The customer name and the cabin number is: " + ship[i] + " , " + i + ".\n");
                pw.close();
            }
        System.out.println("Data stored");
        }
        catch (IOException e){
            System.out.println("An error!");
        }
    }

    //loading program data from file
    public static void Load(String[] ship){ 
        int lineCount = 1;
        try {
            File inputFile = new File("storing.txt");
            Scanner rf = new Scanner(inputFile);
            String fileLine;
            while(rf.hasNext()){
                fileLine = rf.nextLine();
                System.out.println(lineCount + " " + fileLine);
                lineCount++;
            }
            rf.close();
        } catch (Exception e) {
            System.out.println("Error IOException is" + e);
        } 
    }

    //sorting customers by name
    public static void Ordered(String[] ship ){
        Scanner input = new Scanner(System.in);

        Arrays.sort(ship);
        System.out.println("Passengers ordered sorted alphabetically: " + Arrays.toString(ship));

    }
}