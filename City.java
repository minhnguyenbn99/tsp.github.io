package tsp02;

public class City {
	    int x;
	    int y;
	    String cityName;
	    static int count = 0;
	    
	    public City(){
	        this.x = (int)(Math.random()*200);  
	        this.y = (int)(Math.random()*200);   
	        count++;
	        this.cityName = "City " + Integer.toString(count);
	    }
	    
	  
	    public City(int x, int y) {
	        this.x = x;
	        this.y = y;
	        count++;
	        this.cityName = "City " + Integer.toString(count) ;
	    }
	    
	   
	    public int getX() {
	        return this.x;
	    }
	    
	 
	    public int getY() {
	        return this.y;
	    }
	    
	    // Gets the distance 
	    public double distanceTo(City city){
	        int xDistance = Math.abs(getX() - city.getX());
	        int yDistance = Math.abs(getY() - city.getY());
	        
	        double distance = 0.0;
	        distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
	        
	        return distance;
	    }
	    
	    public static boolean isEqual(City c1, City c2){
	      boolean b = false;
	      
	      if(c1.getX() == c2.getX() && c1.getY() == c2.getY())
	         b = true;
	      
	      return b;
	    }
	      
	    
	    @Override
	    public String toString() {
	        return cityName + " is placed at (" +getX()+", "+getY()+")";
	    }
	    
	    public String toString1() {
	        return cityName;
	    }

}
