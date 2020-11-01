package tsp02;

import java.util.Scanner;

import tsp02.CityList;
import tsp02.City;

public class TSP {
	public static void main(String[] args) {
      
                
       Scanner scan = new Scanner(System.in);
       
       
         
        // Create and add our cities
    	   City city = new City(37, 52);
    	   CityList.addCity(city);
           City city2 = new City(49, 49);
           CityList.addCity(city2);
           City city3 = new City(52, 64);
           CityList.addCity(city3);
           City city4 = new City(20, 26);
           CityList.addCity(city4);
           City city5 = new City(40,30);
           CityList.addCity(city5);
           City city6 = new City(21, 47);
           CityList.addCity(city6);
           City city7 = new City(17, 63);
           CityList.addCity(city7);
           City city8 = new City(31, 62);
           CityList.addCity(city8);
           City city9 = new City(52, 33);
           CityList.addCity(city9);
           City city10 = new City(51, 21);
           CityList.addCity(city10);
           City city11 = new City(42, 41);
           CityList.addCity(city11);
           City city12 = new City(31, 32);
           CityList.addCity(city12);
           City city13 = new City(5, 25);
           CityList.addCity(city13);
           City city14 = new City(12, 42);
           CityList.addCity(city14);
           City city15 = new City(36, 16);
           CityList.addCity(city15);
           City city16 = new City(52, 41);
           CityList.addCity(city16);
           City city17 = new City(27, 23);
           CityList.addCity(city17);
           City city18 = new City(17, 33);
           CityList.addCity(city18);
           City city19 = new City(13, 13);
           CityList.addCity(city19);
           City city20 = new City(57, 58);
           CityList.addCity(city20);
           City city21 = new City(62, 42);
           CityList.addCity(city21);
           City city22 = new City(42, 57);
           CityList.addCity(city22);
           City city23 = new City(16, 57);
           CityList.addCity(city23);
           City city24 = new City(8, 52);
           CityList.addCity(city24);
           City city25	= new City(7, 38);
           CityList.addCity(city25);
           City city26 = new City(27, 68);
           CityList.addCity(city26);
           City city27 = new City(30, 48);
           CityList.addCity(city27);
           City city28 = new City(43, 67);
           CityList.addCity(city28);
           City city29 = new City(58, 48);
           CityList.addCity(city29);
           City city30 = new City(58, 27);
           CityList.addCity(city30);
           City city31 = new City(37, 69);
           CityList.addCity(city31);
           City city32 = new City(38, 46);
           CityList.addCity(city32);
           City city33 = new City(46, 10);
           CityList.addCity(city33);
           City city34 = new City(61, 33);
           CityList.addCity(city34);
           City city35 = new City(62, 63);
           CityList.addCity(city35);
           City city36 = new City(63, 69);
           CityList.addCity(city36);
           City city37 = new City(32,22);
           CityList.addCity(city37);
           City city38 = new City(45,35);
           CityList.addCity(city38);
           City city39 = new City(59, 15);
           CityList.addCity(city39);
           City city40 = new City(5, 6);
           CityList.addCity(city40);
           City city41 = new City(10, 17);
           CityList.addCity(city41);
           City city42 = new City(21, 10);
           CityList.addCity(city42);
           City city43 = new City(5,64);
           CityList.addCity(city43);
           City city44 = new City(30, 15);
           CityList.addCity(city44);
           City city45 = new City(39, 10);
           CityList.addCity(city45);
           City city46 = new City(32, 39);
           CityList.addCity(city46);
           City city47 = new City(25, 32);
           CityList.addCity(city47);
           City city48 = new City(25, 55);
           CityList.addCity(city48);
           City city49 = new City(48, 28);
           CityList.addCity(city49);
           City city50 = new City(56, 37);
           CityList.addCity(city50);
           City city51 = new City(30, 40);
           CityList.addCity(city51);
      
      
         
        
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
