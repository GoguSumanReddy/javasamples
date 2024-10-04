package Tasks;

import java.util.Arrays;
import java.util.List;

public class FindMaxProfit {
	
	public static void main(String args[]) {
		
		List<Integer> list=Arrays.asList(7,8,1,3,6,4);
		int min=list.stream().min((x,y)->x-y).get();
		System.out.println("Minimum: "+min);
		
	    int i=list.indexOf(min);
	    System.out.println("index of min is: "+i);
	    List<Integer> sublist=list.subList(i+1, list.size());
	    System.out.println("sublist:  "+sublist);
	    int max=sublist.stream().max((x,y)->x-y).get();
	    
	    System.out.println("Maximum: "+max);
	    
	    System.out.println("Profit: "+(max-min));
	}

}
