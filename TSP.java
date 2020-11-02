package tsp02;

import java.io.FileInputStream;
import java.util.Scanner;

import tsp02.CityList;
import tsp02.City;

public class TSP {
	public static void main(String[] args) throws Exception {
      
                
       Scanner scan = new Scanner(System.in);
       
       
         	try {
         		String url = "C:\\Users\\Admin\\Desktop\\tspcode.txt";
                FileInputStream fileinputstream =  new FileInputStream(url);
                Scanner scan2 = new Scanner(fileinputstream);
        while (scan2.hasNextLine()) {
        	 String line = scan2.nextLine();
             String[] line_array = line.split(" ");
             City city = new City(Integer.parseInt(line_array[1]), Integer.parseInt(line_array[2]) );
             CityList.addCity(city);
        }
         	}catch (Exception e)
            {
                System.out.println("Error : "+e.getMessage() +" !");
            }
      
         
        
         for(int i=0; i<CityList.numberOfCities() ; i++) {
            System.out.println("\n" + CityList.getCity(i).toString());
         }  
     

        // Initialize population
        Population pop = new Population(100, true);
      
        System.out.println("First fittest distance is: " + pop.getFittest().getDistance());
        System.out.println(pop.getFittest());
        
        System.out.println("\n How many gens would you like to run ? \n");
        int gens = 0;
        gens = scan.nextInt();
        
        // Evolve population for "gens" 
        for (int i = 0; i < gens; i++)  {
            pop = GeneticAlgorithm.evolvePopulation(pop);
        }

        // Print final results
        System.out.println("\n After "+ Integer.toString(gens) +" gens \n");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Way:");
        System.out.println(pop.getFittest());
    }
}
