import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;
public class Utils {

	public static Random  R = new Random(10);
	public static Gene[] MARKERS = generateData(10);//number of markers
	
	public static <T>List<T>[] split(List<T> list){
		List<T> first = new ArrayList<>();
		List<T> second = new ArrayList<>();
		int size = list.size();
		
		IntStream.range(0, size).forEach(i -> {
			if(i < (size + 1)/2) {
				first.add(list.get(i));
			} else {
				second.add(list.get(i));
			}
		});
		
		return (List<T>[]) new List [] {first, second};
		
	} //helper method to split lists
	
	public static Gene [] generateData(int numDataPoints) {
		Gene[] data = new Gene[numDataPoints];
		for(int i = 0; i < numDataPoints; i++) {
			data[i] = new Gene(Utils.randomIndex(MountainSlope.WIDTH), Utils.randomIndex(MountainSlope.HEIGHT));
		}
		
		return data;
	}
	
	public static int randomIndex(int limit) {
		return R.nextInt(limit);
	}
	
	
}
