package laptrinhtsp2;

public class TSP {
	public static void main(String[] args) {

        // Create and add our cities
        City city = new City(37, 52);
        CircleManager.addCity(city);
        City city2 = new City(49, 49);
        CircleManager.addCity(city2);
        City city3 = new City(52, 64);
        CircleManager.addCity(city3);
        City city4 = new City(20, 26);
        CircleManager.addCity(city4);
        City city5 = new City(40,30);
        CircleManager.addCity(city5);
        City city6 = new City(21, 47);
        CircleManager.addCity(city6);
        City city7 = new City(17, 63);
        CircleManager.addCity(city7);
        City city8 = new City(31, 62);
        CircleManager.addCity(city8);
        City city9 = new City(52, 33);
        CircleManager.addCity(city9);
        City city10 = new City(51, 21);
        CircleManager.addCity(city10);
        City city11 = new City(42, 41);
        CircleManager.addCity(city11);
        City city12 = new City(31, 32);
        CircleManager.addCity(city12);
        City city13 = new City(5, 25);
        CircleManager.addCity(city13);
        City city14 = new City(12, 42);
        CircleManager.addCity(city14);
        City city15 = new City(36, 16);
        CircleManager.addCity(city15);
        City city16 = new City(52, 41);
        CircleManager.addCity(city16);
        City city17 = new City(27, 23);
        CircleManager.addCity(city17);
        City city18 = new City(17, 33);
        CircleManager.addCity(city18);
        City city19 = new City(13, 13);
        CircleManager.addCity(city19);
        City city20 = new City(57, 58);
        CircleManager.addCity(city20);
        City city21 = new City(62, 42);
        CircleManager.addCity(city21);
        City city22 = new City(42, 57);
        CircleManager.addCity(city22);
        City city23 = new City(16, 57);
        CircleManager.addCity(city23);
        City city24 = new City(8, 52);
        CircleManager.addCity(city24);
        City city25	= new City(7, 38);
        CircleManager.addCity(city25);
        City city26 = new City(27, 68);
        CircleManager.addCity(city26);
        City city27 = new City(30, 48);
        CircleManager.addCity(city27);
        City city28 = new City(43, 67);
        CircleManager.addCity(city28);
        City city29 = new City(58, 48);
        CircleManager.addCity(city29);
        City city30 = new City(58, 27);
        CircleManager.addCity(city30);
        City city31 = new City(37, 69);
        CircleManager.addCity(city31);
        City city32 = new City(38, 46);
        CircleManager.addCity(city32);
        City city33 = new City(46, 10);
        CircleManager.addCity(city33);
        City city34 = new City(61, 33);
        CircleManager.addCity(city34);
        City city35 = new City(62, 63);
        CircleManager.addCity(city35);
        City city36 = new City(63, 69);
        CircleManager.addCity(city36);
        City city37 = new City(32,22);
        CircleManager.addCity(city37);
        City city38 = new City(45,35);
        CircleManager.addCity(city38);
        City city39 = new City(59, 15);
        CircleManager.addCity(city39);
        City city40 = new City(5, 6);
        CircleManager.addCity(city40);
        City city41 = new City(10, 17);
        CircleManager.addCity(city41);
        City city42 = new City(21, 10);
        CircleManager.addCity(city42);
        City city43 = new City(5,64);
        CircleManager.addCity(city43);
        City city44 = new City(30, 15);
        CircleManager.addCity(city44);
        City city45 = new City(39, 10);
        CircleManager.addCity(city45);
        City city46 = new City(32, 39);
        CircleManager.addCity(city46);
        City city47 = new City(25, 32);
        CircleManager.addCity(city47);
        City city48 = new City(25, 55);
        CircleManager.addCity(city48);
        City city49 = new City(48, 28);
        CircleManager.addCity(city49);
        City city50 = new City(56, 37);
        CircleManager.addCity(city50);
        City city51 = new City(30, 40);
        CircleManager.addCity(city51);
     
        // Init population
        Population pop = new Population(60, true);
        System.out.println("First distance: " + pop.getFittest().getDistance());

        // Evolve population for 100 generations
        pop = GeneticAlgorithm.evolvePopulation(pop);
        for (int i = 0; i < 100; i++) {
            pop = GeneticAlgorithm.evolvePopulation(pop);
        }

        // Print results
        System.out.println("Done");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Way:");
        System.out.println(pop.getFittest());
    }
}
