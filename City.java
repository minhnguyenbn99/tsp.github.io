package laptrinhtsp2;

public class City {
	int x;
    int y;
    
    // Constructs a randomly placed city
    public City(){
        this.x = (int)(Math.random()*100);
        this.y = (int)(Math.random()*100);
    }
    
    // Constructs a city with pos x and y
    public City(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    

    public int getY(){
        return this.y;
    }
    
    // Gets the distance 
    public double distanceTo(City city){
        int xDistance = Math.abs(getX() - city.getX());
        int yDistance = Math.abs(getY() - city.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
        
        return distance;
    }
    
    @Override
    public String toString(){
        return getX()+", "+getY();
    }
}
