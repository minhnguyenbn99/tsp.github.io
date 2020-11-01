package tsp02;

public class Population {
	Circle[] circles;

    public Population(int getSize, boolean init) {
        circles = new Circle[getSize];        
        if (init) {
            for (int i = 0; i < getSize(); i++) 
            {
                Circle newCircle = new Circle();
                newCircle.generateIndividual();
                saveCircle(i, newCircle);
            }
        }
    }
    
    // Saves a circle
    public void saveCircle(int index, Circle circle)  {
        circles[index] = circle;
    }
    
    //returns circle at given index 
    public Circle getCircle(int index)  {
        return circles[index];
    }

    
    public Circle getFittest() {
        Circle fittest = circles[0];
        
        for (int i = 1; i < getSize(); i++) 
        {
            if (fittest.getFitness() <= getCircle(i).getFitness()) 
            {
                fittest = getCircle(i);
            }
        }
        return fittest;
    }
    
    @Override
    public String toString(){
      String out = new String();
      
      for(int i = 0; i<getSize(); i++)
      {
         out += "\n" + circles[i].toString();
      }
      
      return out;
    }
       
    
    public int getSize()  {
        return circles.length;
    }
}
