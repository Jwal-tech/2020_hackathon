import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class Chomosone {
	
	private List<Gene> chromosone;
	
	
	
	
	public Chomosone(List<Gene> chromosone) {
		this.chromosone = chromosone;
	} // create a list of chromosones
	
	static public Chomosone create(Gene [] points) {
		List<Gene> genes = Arrays.asList(Arrays.copyOf(points, points.length));
		Collections.shuffle(genes);
		
		Chomosone randomChroGenes = new Chomosone(genes);
		return randomChroGenes ;
		
	} //generate a random array of genes to make a chromosone
	
	public List<Gene> getChromosone() {
		return this.chromosone;
	}
	
	@Override
	public String toString() {
		String ChromosoneStats = "";
		
		return ChromosoneStats;
	}
	
	public double calculateDistance() {
		double totalDistance = 0.0f;
		for(int i = 0; i < this.chromosone.size() -1; i ++) {
			totalDistance = totalDistance + this.chromosone.get(i).distanceBetweenPoints(this.chromosone.get(i + 1));
		}
		return totalDistance;  
	} //method to calculate distance between two chromosones
	
	

	public Chomosone mutate() {
		List<Gene> copy = new ArrayList<>(this.chromosone);
		int indexA = Utils.randomIndex(copy.size());
		int indexB = Utils.randomIndex(copy.size());
		
		while(indexA == indexB) {
			indexA = Utils.randomIndex(copy.size());
		    indexB = Utils.randomIndex(copy.size());
		}
		 
		Collections.swap(copy, indexA, indexB);
	    
		return new Chomosone(copy);
		
	} // method to mutate chromosone
	
	public Chomosone[] crossOver(Chomosone g) {
		
		List <Gene>[] Dna = Utils.split(this.chromosone);
		List <Gene>[] otherDna = Utils.split(g.getChromosone());
		
		List <Gene> firstCross = new ArrayList<>(Dna[0]);
	
		
		for(Gene gene: otherDna[0]) {
			if(!firstCross.contains(gene)) {
				firstCross.add(gene);
			}			
		}
		
		for(Gene gene: otherDna[1]) {
			if(!firstCross.contains(gene)) {
				firstCross.add(gene);
			}			
		}
		
        List <Gene> secondCross = new ArrayList<>(otherDna[0]);
	
		
		for(Gene gene: Dna[0]) {
			if(!firstCross.contains(gene)) {
				firstCross.add(gene);
			}			
		}
		
		for(Gene gene: Dna[1]) {
			if(!firstCross.contains(gene)) {
				firstCross.add(gene);
			}			
		}
		
		Chomosone [] newArray = { new Chomosone(firstCross),new Chomosone(secondCross)};
		return newArray;
		
		
	}  // method to cross over the chromosones
	
	
	
	
}
