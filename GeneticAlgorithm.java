package tsp02;

public class GeneticAlgorithm {
    private static final double mutationRate = 0.005;
       
    // Evolves a population 
    public static Population evolvePopulation(Population pop) 
    {
        
        Population newPopulation = new Population(pop.getSize(), false);
        
        newPopulation.saveCircle(0,pop.getFittest());              
        newPopulation.saveCircle(pop.getSize()-1,pop.getFittest());


        for(int i=0; i<pop.getSize(); i++)
        {
            Circle temp = new Circle();
            temp = rouletteWheelSelection(pop);
            newPopulation.saveCircle(i,temp);
        }
       
        newPopulation.saveCircle(0,pop.getFittest());       
        newPopulation.saveCircle(pop.getSize()-1,pop.getFittest());
        
        System.out.println("\n Selected Population is \n"+ newPopulation.toString());
        
             
        Circle parent1 = new Circle();
        Circle parent2 = new Circle();

        for (int i = 1; i < pop.getSize()-1; i++)
        {
                 
            if(i%2==1)
            {
               parent1 = newPopulation.getCircle(i);
               parent2 = newPopulation.getCircle(i+1);
            }
            
            System.out.println("\n The parents are \n" + parent1.toString() + " and \n " + parent2.toString());
            
            // Crossover parents
            Circle child = crossover(parent1, parent2);
            
            System.out.println("\n The Child is \n" + child.toString());
            
            // Add child to new population
            newPopulation.saveCircle(i, child);
        }

        // Mutate the new population 
        for (int i = 0; i <pop.getSize(); i++) 
        {
            mutate(newPopulation.getCircle(i));
        }

        return newPopulation;
    }

    // Crossover 
    public static Circle crossover(Circle parent1, Circle parent2) 
    {
        
        Circle child = new Circle();

      
        int startPos = (int) (Math.random() * parent1.getSize());
        int endPos = (int) (Math.random() * parent1.getSize());

        // Loop and add the sub circle from parent1 
        for (int i = 0; i < parent1.getSize(); i++) 
        {
            // If our start position is less than the end position
            if (startPos < endPos && i > startPos && i < endPos) 
            {
                child.setCity(i, parent1.getCity(i));
            } // If our start position is larger
            else if (startPos > endPos) 
            {
                if (!(i < startPos && i > endPos)) 
                {
                    child.setCity(i, parent1.getCity(i));
                }
            }
        }

        // Loop through parent2's city circle
        for (int i = 0; i < parent2.getSize(); i++) 
        {
            // If child doesn't have the city add it
            if (!child.hasCity(parent2.getCity(i))) 
            {
                for (int j = 0; j < child.getSize(); j++) 
                {
                    // Add city if it's empty
                    if (child.getCity(j) == null)
                    {
                        child.setCity(j, parent2.getCity(i));
                        break;
                    }
                }
            }
        }
        return child;
    }

    private static void mutate(Circle circle) 
    {
        // Loop through circle cities
        for(int circlePos1=0; circlePos1 < circle.getSize(); circlePos1++)
        {
            // Apply mutation rate
            if(Math.random() < mutationRate)
            {
            
                System.out.println("\n Mutation Occurred at \n" + circle.toString());
                
                // Get a second random position in the circle
                int circlePos2 = (int) (circle.getSize() * Math.random());

                // Get the cities at target position in circle
                City city1 = circle.getCity(circlePos1);
                City city2 = circle.getCity(circlePos2);

                // Swap them around
                //circle.setCity(circlePos2, city1);
                //circle.setCity(circlePos1, city2);
                
                circle.generateIndividual();                 
                System.out.println("\n It is now \n" + circle.toString());
            }
        }
    }
    
    public static Circle rouletteWheelSelection(Population po)
    {
      double totalSum = 0.0;
      double partSum = 0;
      double roulette = 0;
      Circle c = new Circle();
         
      for(int i=0; i<po.getSize(); i++){
         totalSum += po.getCircle(i).getFitness();
      }
      
      for(int i=0; i<po.getSize(); i++){
         po.getCircle(i).setCircleProbability(totalSum, po.getCircle(i).getFitness());
      }
      
     
      roulette = (double)(Math.random());
      
      for(int i=0; i<po.getSize(); i++){
         partSum+=po.getCircle(i).circleProbability;
         
         if(partSum>=roulette){
            c = po.getCircle(i);
            break;
         }
      } 
      return c;
   }
}
