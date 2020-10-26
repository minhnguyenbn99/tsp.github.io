package laptrinhtsp2;

public class Population {
	
    Circle[] circles;

    // Construct a population
    public Population(int populationSize, boolean init) {
        circles = new Circle[populationSize];
        if (init) {
            // Loop and create individuals
            for (int i = 0; i < populationSize(); i++) {
                Circle newTour = new Circle();
                newTour.generateIndividual();
                saveCircle(i, newTour);
            }
        }
    }
    
    // Saves a circle
    public void saveCircle(int index, Circle circle) {
        circles[index] = circle;
    }
    
    // Gets a circle from population
    public Circle getCircle(int index) {
        return circles[index];
    }

    // Gets the best circle in the population
    public Circle getFittest() {
        Circle fittest = circles[0];
        for (int i = 1; i < populationSize(); i++) {
            if (fittest.getFitness() <= getCircle(i).getFitness()) {
                fittest = getCircle(i);
            }
        }
        return fittest;
    }

    // Gets population size
    public int populationSize() {
        return circles.length;
    }
}



