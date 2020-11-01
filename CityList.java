package tsp02;

import java.util.ArrayList;

public class CityList {
	private static ArrayList destinationCities = new ArrayList<City>();

    // Add a city 
    public static void addCity(City city)  {
       destinationCities.add(city);
    }
    
    // Return City 
    public static City getCity(int index){
        return (City)destinationCities.get(index);
    }
    
    // Get the number of destination cities
    public static int numberOfCities(){
        return destinationCities.size();
    }
}
