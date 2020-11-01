package tsp02;

import java.util.ArrayList;
import java.util.Collections;

public class Circle {
	 private ArrayList circle = new ArrayList<City>();
	    private double fitness = 0;
	    private int distance = 0;
	    public double circleProbability ;
	    
	    
	    public Circle()
	    {
	        for (int i = 0; i < CityList.numberOfCities(); i++) 
	        {
	            circle.add(null);
	        }
	    }
	    
	    public Circle(ArrayList circle)
	    {
	        this.circle = circle;
	    }
	    
	      // Creates a random individual
	    public void generateIndividual() 
	    {
	        for (int cityIndex = 0; cityIndex < CityList.numberOfCities(); cityIndex++) 
	        {
	          setCity(cityIndex, CityList.getCity(cityIndex));
	        }
	        
	        // shuffles the list 
	        Collections.shuffle(circle);
	    }
	    
	    public void setCircleProbability(double total, double fitness)
	    {
	      this.circleProbability = fitness/total;
	    }

	    // returns City at a given position
	    public City getCity(int index) 
	    {
	        return (City)circle.get(index);
	    }

	    // Sets a city in a certain position within a circle
	    public void setCity(int pos, City city) 
	    {
	        circle.set(pos, city);
	        fitness = 0;
	        distance = 0;
	    }
	    
	        
	    // Gets the total distance of the circle
	    public int getDistance()
	    {
	        if (distance == 0) 
	        {
	            int circleDistance = 0;
	            
	                for (int cityIndex=0; cityIndex < getSize(); cityIndex++)
	                {
	                
	                  City fromCity = getCity(cityIndex);
	                  City destinationCity;
	              
	                  if(cityIndex+1 < getSize())
	                  destinationCity = getCity(cityIndex+1);
	                  else
	                  destinationCity = getCity(0);
	                  
	                  //Distance between the cities
	                  circleDistance += fromCity.distanceTo(destinationCity);
	               }
	            
	               distance = circleDistance;
	        }
	        return distance;
	    }
	    
	    // Gets the circles fitness
	    public double getFitness() 
	    {
	        if (fitness == 0) 
	        fitness = 1/(double)getDistance(); 
	        
	        
	        return fitness;
	    }


	    // Get number of cities on our circle
	    public int getSize() 
	    {
	        return circle.size();
	    }
	    
	    // Check if the circle contains a city
	    public boolean hasCity(City city)
	    {
	        return circle.contains(city);
	    }
	    
	    
	    public String toString() 
	    {
	        String gene = "|";
	        for (int i = 0; i < getSize(); i++) 
	        {
	            gene += getCity(i).toString1() +"|";
	        }
	        
	        return gene;
	    }
}
