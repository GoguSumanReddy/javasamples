package Tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface Calculation
{
	int sum(int a,int b);
}
public class GFG {

	public static void main(String args[]) {
		
		List<String> list=Arrays.asList("Suman","Jagan","Suman");
		System.out.println(list.stream().filter(i->i.equals("Suman")).collect(Collectors.toList()));
		Map<String, Long> result=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	    System.out.println(result);
	    Integer maximum = Stream.of(10,13,4,9,2,100).max(Comparator.comparing(Integer::valueOf)).get();
	    Calculation c=(a,b)->a+b;
	    System.out.println(c.sum(1, 2));
	    Integer minimum = Stream.of(10,13,4,9,2,100).min(Comparator.comparing(Integer::valueOf)).get();
	    
	    
	    String str="";
	    Optional<String> optional=Optional.ofNullable(str);
	    if(optional.isPresent()) {
	    	System.out.println("Preset:"+optional.get());
	    }
	    else {
	    	System.out.println("Not Present and default value: "+ optional.orElse("Default 0"));
	    }
	    
	    List<Integer> intList=Stream.of(1,5,7,8,9,21,43,56,7,8,43,12).distinct().sorted().filter(x->x<30).map(x->x*x).collect(Collectors.toList());
	    intList.forEach(System.out::println);
	    System.out.println("Min: "+Stream.of(1,5,7,8,9,21,43,56,7,8,43,12).min((x,y)->x-y).get());
	    System.out.println("Max: "+Stream.of(1,5,7,8,9,21,43,56,7,8,43,12).max((x,y)->x-y).get());
	
	    System.out.println("Max: "+Stream.of(1,5,7,8,9,21,43,56,7,8,43,12).distinct().mapToInt(x->x).sum());
	}
}
