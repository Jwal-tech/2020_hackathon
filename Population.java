
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class Population {
  
	private List<Chomosone> population;
    private int initialSize;
    
    public Population(Gene [] points, int initialSize) {
    	
    	this.population = init(points, initialSize);
    	this.initialSize = initialSize;
    }
    
    public Chomosone getBestPath() {
    	return this.population.get(0);
    	
    }
    
    private List<Chomosone> init(Gene[] points, int initialSize){
    	List <Chomosone> firstPopulation = new ArrayList<>();
    	 
    
    	for (int i = 0; i < initialSize; i++) {
    		Chomosone chromosone = Chomosone.create(points);
    		firstPopulation.add(chromosone);
    	}
    	
    	return firstPopulation;
    	
    }
    
    public void update() {
    	doCrossover();
        doMutation();
        doSpawn();
    	doSelection();
    	
    	
    }
    
    private void doCrossover() {
    	List <Chomosone> newPopulation = new ArrayList<>();
    	
    	for(Chomosone chromosone: this.population) {
    		Chomosone partner = getCrossOverPartner(chromosone);
    		newPopulation.addAll(Arrays.asList(chromosone.crossOver(partner))); 		
    	}
    	
    	this.population.addAll(newPopulation);
    }
    
    
	private void doMutation() {
		List <Chomosone> newPopulation = new ArrayList<>();
		for (int i = 0; i < initialSize; i++) {
    		Chomosone mutation = this.population.get(Utils.randomIndex(this.population.size())).mutate();
    		newPopulation.add(mutation);
    	}
		this.population.addAll(newPopulation);	
	}
	
	private void doSpawn() {
		IntStream.range(0,1000).forEach(e -> this.population.add(Chomosone.create(Utils.MARKERS))); // this is the code that isn't working for some reason
	}
	
	
	private void doSelection() {
		this.population.sort(Comparator.comparingDouble(Chomosone :: calculateDistance));
		this.population = this.population.stream().limit(this.initialSize).collect(Collectors.toList());
	}
	
	private Chomosone getCrossOverPartner(Chomosone chromosone) {
		Chomosone partner =  this.population.get(Utils.randomIndex(this.population.size()));
		
		while(chromosone == partner) {
			partner = this.population.get(Utils.randomIndex(this.population.size()));
		} // while loop that stops a chromosone from crossing over with itself
		 
		return partner;
			
	}
	
	
}
