package Tasks;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Java8Features {
	
	public static void main(String args[]) {
		Utility u=new Utility();
		List<String> list=Arrays.asList("New City", "Newyork", "Newzealand", "India","Canada");
		System.out.println("==============starts with new======");
		list.stream().filter(Utility::startWith).forEach(System.out::println);
		System.out.println("==============ends with new========");
		list.stream().filter(u::endsWith).forEach(System.out::println);
		
		System.out.println("==============Create Cities========");
		list.stream().map(City::new).forEach(System.out::println);
		
		System.out.println("==============Upper Case========");
		list.stream().map(u::upperCase).forEach(System.out::println);
		
		System.out.println("==============Upper Case using String class========");
		list.stream().map(String::toUpperCase).forEach(System.out::println);
		
		System.out.println("==============Find Substring index========");
		BiFunction<String, String, Integer> func=String::indexOf;
		Integer index=func.apply("My Name is Suman", "Suman");
		System.out.println(index);
		
		System.out.println("==============Find Addition========");
		BiFunction<Integer, Integer, Integer> funadd=u::addition;
		System.out.println(funadd.apply(3, 4));
		
	}

}
