package laptrinhtsp2;
import java.util.ArrayList;
import java.util.Collections;
public class Circle {
	// Holds our circle of cities
    private ArrayList circle = new ArrayList<City>();
    // Cache
    private double fitness = 0;
    private int distance = 0;
    
    public Circle(){
        for (int i = 0; i < CircleManager.numberOfCities(); i++) {
            circle.add(null);
        }
    }
    
    public Circle(ArrayList circle){
        this.circle = circle;
    }

    // Creates a random individual
    public void generateIndividual() {
        // Loop through all our destination cities and add them to our circle
        for (int cityIndex = 0; cityIndex < CircleManager.numberOfCities(); cityIndex++) {
          setCity(cityIndex, CircleManager.getCity(cityIndex));
        }
        // shuffle the city
        Collections.shuffle(circle);
    }

    // Gets a city
    public City getCity(int tourPosition) {
        return (City)circle.get(tourPosition);
    }

    // Sets a city 
    public void setCity(int tourPosition, City city) {
        circle.set(tourPosition, city);
        // If the circles been altered we need to reset the fitness and distance
        fitness = 0;
        distance = 0;
    }
    
    // Gets the circles fitness
    public double getFitness() {
        if (fitness == 0) {
            fitness = 1/(double)getDistance();
        }
        return fitness;
    }
    
    // Gets the total distance of the circle
    public int getDistance(){
        if (distance == 0) {
            int circleDistance = 0;
            for (int cityIndex=0; cityIndex < circleSize(); cityIndex++) {
                // Get city we're travelling from
                City fromCity = getCity(cityIndex);
                // City we're travelling to
                City destinationCity;
                if(cityIndex+1 < circleSize()){
                    destinationCity = getCity(cityIndex+1);
                }
                else{
                    destinationCity = getCity(0);
                }
                // Get the distance between the two cities
                circleDistance += fromCity.distanceTo(destinationCity);
            }
            distance = circleDistance;
        }
        return distance;
    }

    public int circleSize() {
        return circle.size();
    }
    
    // Check if the tour contains a city
    public boolean containsCity(City city){
        return circle.contains(city);
    }
    
    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < circleSize(); i++) {
            geneString += getCity(i)+"\n";
        }   
        return geneString;
    }
}
