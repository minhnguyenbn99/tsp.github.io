package laptrinhtsp2;
import java.util.ArrayList;
public class TourManager {
    private static ArrayList destinationCities = new ArrayList<City>();

    // Add a des city
    public static void addCity(City city) {
        destinationCities.add(city);
    }
    
    // Get a city
    public static City getCity(int index){
        return (City)destinationCities.get(index);
    }
    
    // Get the number of des city
    public static int numberOfCities(){
        return destinationCities.size();
    }
}
