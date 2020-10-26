package laptrinhtsp2;

public class TSP {
	public static void main(String[] args) {

        // Create and add our cities
        City city = new City(37, 52);
        TourManager.addCity(city);
        City city2 = new City(49, 49);
        TourManager.addCity(city2);
        City city3 = new City(52, 64);
        TourManager.addCity(city3);
        City city4 = new City(20, 26);
        TourManager.addCity(city4);
        City city5 = new City(40,30);
        TourManager.addCity(city5);
        City city6 = new City(21, 47);
        TourManager.addCity(city6);
        City city7 = new City(17, 63);
        TourManager.addCity(city7);
        City city8 = new City(31, 62);
        TourManager.addCity(city8);
        City city9 = new City(52, 33);
        TourManager.addCity(city9);
        City city10 = new City(51, 21);
        TourManager.addCity(city10);
        City city11 = new City(42, 41);
        TourManager.addCity(city11);
        City city12 = new City(31, 32);
        TourManager.addCity(city12);
        City city13 = new City(5, 25);
        TourManager.addCity(city13);
        City city14 = new City(12, 42);
        TourManager.addCity(city14);
        City city15 = new City(36, 16);
        TourManager.addCity(city15);
        City city16 = new City(52, 41);
        TourManager.addCity(city16);
        City city17 = new City(27, 23);
        TourManager.addCity(city17);
        City city18 = new City(17, 33);
        TourManager.addCity(city18);
        City city19 = new City(13, 13);
        TourManager.addCity(city19);
        City city20 = new City(57, 58);
        TourManager.addCity(city20);
        City city21 = new City(62, 42);
        TourManager.addCity(city21);
        City city22 = new City(42, 57);
        TourManager.addCity(city22);
        City city23 = new City(16, 57);
        TourManager.addCity(city23);
        City city24 = new City(8, 52);
        TourManager.addCity(city24);
        City city25	= new City(7, 38);
        TourManager.addCity(city25);
        City city26 = new City(27, 68);
        TourManager.addCity(city26);
        City city27 = new City(30, 48);
        TourManager.addCity(city27);
        City city28 = new City(43, 67);
        TourManager.addCity(city28);
        City city29 = new City(58, 48);
        TourManager.addCity(city29);
        City city30 = new City(58, 27);
        TourManager.addCity(city30);
        City city31 = new City(37, 69);
        TourManager.addCity(city31);
        City city32 = new City(38, 46);
        TourManager.addCity(city32);
        City city33 = new City(46, 10);
        TourManager.addCity(city33);
        City city34 = new City(61, 33);
        TourManager.addCity(city34);
        City city35 = new City(62, 63);
        TourManager.addCity(city35);
        City city36 = new City(63, 69);
        TourManager.addCity(city36);
        City city37 = new City(32,22);
        TourManager.addCity(city37);
        City city38 = new City(45,35);
        TourManager.addCity(city38);
        City city39 = new City(59, 15);
        TourManager.addCity(city39);
        City city40 = new City(5, 6);
        TourManager.addCity(city40);
        City city41 = new City(10, 17);
        TourManager.addCity(city41);
        City city42 = new City(21, 10);
        TourManager.addCity(city42);
        City city43 = new City(5,64);
        TourManager.addCity(city43);
        City city44 = new City(30, 15);
        TourManager.addCity(city44);
        City city45 = new City(39, 10);
        TourManager.addCity(city45);
        City city46 = new City(32, 39);
        TourManager.addCity(city46);
        City city47 = new City(25, 32);
        TourManager.addCity(city47);
        City city48 = new City(25, 55);
        TourManager.addCity(city48);
        City city49 = new City(48, 28);
        TourManager.addCity(city49);
        City city50 = new City(56, 37);
        TourManager.addCity(city50);
        City city51 = new City(30, 40);
        TourManager.addCity(city51);
     
        // Init population
        Population pop = new Population(60, true);
        System.out.println("First distance: " + pop.getFittest().getDistance());

        // Evolve population for 100 generations
        pop = GA.evolvePopulation(pop);
        for (int i = 0; i < 100; i++) {
            pop = GA.evolvePopulation(pop);
        }

        // Print results
        System.out.println("Done");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Way:");
        System.out.println(pop.getFittest());
    }
}
