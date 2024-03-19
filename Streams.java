import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

// count the number of names starting with A in the list by normal method and stream

public class Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Normal method\n");

		myMethod();
		System.out.println("Streams filter\n ");

		steramFilter();
		System.out.println("Streams map\n ");

		streamMap();
		
		System.out.println("Streams Collects\n ");
		StreamCollect();

	}

	@Test
	public static void myMethod() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhi");
		names.add("Kd");
		names.add("Akhil");
		names.add("Anandh");
		names.add("sai");

		int count = 0;

		for (int i = 0; i < names.size(); i++) {
			String name1 = names.get(i);

			if (name1.startsWith("A")) {
				count++;
			}
		}

		System.out.println(count);

	}

	@Test
	public static void steramFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhi");
		names.add("Kd");
		names.add("Akhil");
		names.add("Anandh");
		names.add("sai");

		// we can also declare stream instead of list and prints name with A and a
		long c1 = Stream.of("Abhi", "KD", "akhil", "Anandh", "sai").filter(x->x.startsWith("A") || x.startsWith("a")).count();
		

		long c = names.stream().filter(x -> x.startsWith("A")).count();

		System.out.println(c);

		// print all the names of arraylist
		names.stream().filter(x -> x.length() > 4).forEach(x -> System.out.println(x));

		// print only first name
		names.stream().filter(x -> x.length() > 4).limit(1).forEach(x -> System.out.println(x));
	}
	
	@Test
	public static void streamMap()
	{
		// Print names ends with a in uppercase
		
		Stream.of("Abhi", "KD", "akhila", "Anandha", "sai").filter(x->x.endsWith("a")).map(x->x.toUpperCase()).forEach(x->System.out.println(x));
	   
		// print the names have first letter A and sorted and uppercase
		
		System.out.println("print the names have first letter A and sorted and uppercase");
		
		List<String>names= Arrays.asList("Azbhi", "KD", "Akhila", "Anandha", "sai"); // Converting Array to arraylist
		names.stream().filter(x->x.startsWith("A")).sorted().map(x->x.toUpperCase()).forEach(x->System.out.println(x));
		
		// concat 2 diff lists with streams
		
		List<String> names2= Arrays.asList("male", "female");
		
		Stream<String> newStream=Stream.concat(names.stream(), names2.stream());
		
		// print true if the given name is found in the list
		boolean flag=newStream.anyMatch(x->x.contains("KD"));
		Assert.assertTrue(flag);
	
	}
	 //How to use collectors and store the result in new list 
	@Test
	public static void StreamCollect()
	{
		List<String>names= Arrays.asList("Azbhi", "KD", "Akhila", "Anandha", "sai");
		List<String> newNames=names.stream().filter(x->x.startsWith("A")).map(x->x.toUpperCase()).collect(Collectors.toList());
		
		List<Integer> values=Arrays.asList(3,2,5,4,8,6,3);
		// print the list in sorted and unique 
		List<Integer>newValue=values.stream().distinct().sorted().collect(Collectors.toList());
		newValue.stream().forEach(x->System.out.println(x));
		// want to print element in 3rd index
		System.out.println(newValue.get(2));
	}
	

}
