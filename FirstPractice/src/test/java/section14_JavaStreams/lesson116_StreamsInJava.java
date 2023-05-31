package section14_JavaStreams;

import java.util.ArrayList;

public class lesson116_StreamsInJava {

	public static void main(String[] args) {
		
		//Start creation of names arraylist
		ArrayList<String> names = new ArrayList<String>();
		names.add("Alejandra");
		names.add("Leopoldo");
		names.add("Roberto");
		names.add("Manuel");
		names.add("Daniela");
		names.add("Margaret");
		names.add("Logan");
		//Ends creation of names arrayList
		
		//Suppose we want to print names that start with M
		names.stream().filter(name->name.startsWith("M")).forEach(name -> System.out.println("Names that start with M: "+name));
		
		//Suppose we want to print names that start with L, sort them in orderm¿, make all caps and then print.
		names.stream().filter(name->name.startsWith("L")).sorted().map(name->name.toUpperCase()).forEach(name->System.out.println("capitalized names with L: "+ name));
		
		//How to check if a certain string appears in the stream
		boolean flag = names.stream().anyMatch(name->name.equalsIgnoreCase("Leopoldo"));
		System.out.println("The value of the matching flag is: "+flag);
	}

}
