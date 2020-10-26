package laptrinhtsp2;

public class GeneticAlgorithm {
    private static final double mutationRate = 0.02;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;

    // Evolves a new population 
    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.populationSize(), false);

        int Offset = 0;
        if (elitism) {
            newPopulation.saveCircle(0, pop.getFittest());
            Offset = 1;
        }

        // Crossover population
        for (int i = Offset; i < newPopulation.populationSize(); i++) {
            // Select parents
            Circle parent1 = tournamentSelection(pop);
            Circle parent2 = tournamentSelection(pop);
            // Crossover parents
            Circle child = crossover(parent1, parent2);
            // Add child to new population
            newPopulation.saveCircle(i, child);
        }

              for (int i = Offset; i < newPopulation.populationSize(); i++) {
            mutate(newPopulation.getCircle(i));
        }

        return newPopulation;
    }

    // Crossover
    public static Circle crossover(Circle parent1, Circle parent2) {
        Circle child = new Circle();
        // Get start and end sub circle positions for parent1's tour
        int startPos = (int) (Math.random() * parent1.circleSize());
        int endPos = (int) (Math.random() * parent1.circleSize());
        // Loop and add the sub circle from parent1 to our child
        for (int i = 0; i < child.circleSize(); i++) {
            // If our start position is less than the end position
            if (startPos < endPos && i > startPos && i < endPos) {
                child.setCity(i, parent1.getCity(i));
            } // If our start position is larger
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    child.setCity(i, parent1.getCity(i));
                }
            }
        }

        // Loop through parent2's city circle
        for (int i = 0; i < parent2.circleSize(); i++) {
            // If child doesn't have the city add it
            if (!child.containsCity(parent2.getCity(i))) {
                // Loop to find a spare position 
                for (int ii = 0; ii < child.circleSize(); ii++) {
                    //Add city in spare position 
                    if (child.getCity(ii) == null) {
                        child.setCity(ii, parent2.getCity(i));
                        break;
                    }
                }
            }
        }
        return child;
    }

    // Mutate a circle using swap mutation
    private static void mutate(Circle circle) {
        for(int circlePos1=0; circlePos1 < circle.circleSize(); circlePos1++){
            // Apply mutation rate
            if(Math.random() < mutationRate){           
                int circlePos2 = (int) (Math.random()*circle.circleSize());
                // Get the cities at target position in cle
                City city1 = circle.getCity(circlePos1);
                City city2 = circle.getCity(circlePos2);

                // Swap
                circle.setCity(circlePos2, city1);
                circle.setCity(circlePos1, city2);
            }
        }
    }

    // Selects candidate circle for crossover
    private static Circle tournamentSelection(Population pop) {
               Population tournament = new Population(tournamentSize, false);
               for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.populationSize());
            tournament.saveCircle(i, pop.getCircle(randomId));
        }
        // Get the fittest cirle
        Circle fittest = tournament.getFittest();
        return fittest;
    }
}
