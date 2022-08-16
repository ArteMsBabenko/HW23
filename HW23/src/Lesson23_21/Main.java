package Lesson23_21;

import java.util.*;
import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) {
		
		Set<try1> tr = new HashSet<try1>();
		Consumer<try1> addToHashSet = try1Item -> tr.add(try1Item);
		addToHashSet.accept(new try1("String1", 25));
		addToHashSet.accept(new try1("String4", 44));
		addToHashSet.accept(new try1("String3", 12));
		addToHashSet.accept(new try1("String2", 57));
		addToHashSet.accept(new try1("String5", 94));
		
		System.out.println("Random elements");
		tr.forEach(System.out::println);
		
		Set<try1> tr1 = new LinkedHashSet<try1>();
		Consumer<try1> addToLinkedHashSet = try1Item -> tr1.add(try1Item);
		addToLinkedHashSet.accept(new try1("String1", 25));
		addToLinkedHashSet.accept(new try1("String4", 44));
		addToLinkedHashSet.accept(new try1("String3", 12));
		addToLinkedHashSet.accept(new try1("String2", 57));
		addToLinkedHashSet.accept(new try1("String5", 94));
		
		System.out.println("Elements in the order they were added");
		tr1.forEach(System.out::println);
		
		Set<try1> tr2 = new TreeSet<try1>();
		Consumer<try1> addToTreeSet = try1Item -> tr2.add(try1Item);
		addToTreeSet.accept(new try1("String1", 25));
		addToTreeSet.accept(new try1("String4", 44));
		addToTreeSet.accept(new try1("String3", 12));
		addToTreeSet.accept(new try1("String2", 57));
		addToTreeSet.accept(new try1("String5", 94));
		
		System.out.println("Elements in the order overridden in Comparable");
		tr2.forEach(System.out::println);
		
		Set<try1> tr3 = new TreeSet<try1>(new try2());
		tr.add(new try1("String1", 14));
		tr.add(new try1("String5", 54));
		tr.add(new try1("String3", 34));
		tr.add(new try1("String2", 24));
		tr.add(new try1("String4", 44));
		
		System.out.println("Elements in the order redefined in Comparato");
		tr2.stream().sorted(new try2()).forEach(System.out::println);
		
	}
	
}
