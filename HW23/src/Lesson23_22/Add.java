package Lesson23_22;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Add {
	
	ArrayList<Commodity> add = new ArrayList<Commodity>();

	Supplier<Commodity> getCommodity = () -> {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product name:");
		String name = sc.next();
		System.out.println("Enter the length of the item:");
		int length = sc.nextInt();
		System.out.println("Enter product weight:");
		int weight = sc.nextInt();
		System.out.println("Enter product width:");
		int width = sc.nextInt();
		
		return new Commodity(name,length,width,weight);
		
	};
	
	
	public Optional<Commodity> findCommodity() {
		Commodity commodityTyped = getCommodity.get();

		Predicate<Commodity> isEqual = commodity -> commodity.getName().equalsIgnoreCase(commodityTyped.getName())
				&& commodity.getLength() == commodityTyped.getLength()
				&& commodity.getWidth() == commodityTyped.getWidth()
				&& commodity.getWeight() == commodityTyped.getWeight();
		Optional<Commodity> commodityFound = add.stream().filter(isEqual).findFirst();

		return commodityFound;
	}
	
	
	public void addCommodity() {
		Commodity commodity = getCommodity.get();

		add.add(commodity);
		System.out.println("Product" + commodity.toString() + "successfully added to the shelf");
	}
	
	public void removeCommodity() {
		
		Optional<Commodity> commodityFound = findCommodity();

		if (commodityFound.isPresent()) {
			add.remove(commodityFound.get());
			System.out.println("Product " + commodityFound.get().toString() + " successfully removed from the shelf"); 
		}
		
		else {
			System.out.println("The product you entered is not exists");
		}
	}
	
	public void replaceCommodity() {
		Optional<Commodity> commodityFound = findCommodity();

		if (commodityFound.isPresent()) {
			System.out.println("Enter replacement item:");
			Commodity newCommodityTyped = getCommodity.get();

			commodityFound.get().setName(newCommodityTyped.getName());
			commodityFound.get().setLength(newCommodityTyped.getLength());
			commodityFound.get().setWidth(newCommodityTyped.getWidth());
			commodityFound.get().setWeight(newCommodityTyped.getWeight());

			System.out.println("The entered product has been successfully replaced with " + commodityFound.get().toString() + "!");
		}
		else {
			System.out.println("The product you entered is not exists");
		}
}

	
public void sortByName() {
	System.out.println("Before sorting, the goods were placed on the shelf in the following order:");
	add.forEach(System.out::println);
	
	
	System.out.println("After sorting, the order of the items on the shelf will be as follows:");
	add.stream().sorted(Comparator.comparing(Commodity::getName)).forEach(System.out::println);
	}

public void sortByLength() {
	System.out.println("Before sorting, the goods were placed on the shelf in the following order:");
	add.forEach(System.out::println);
	
	Collections.sort(add,new Length());
	
	System.out.println("After sorting, the order of the items on the shelf will be as follows:");
	add.stream().sorted(Comparator.comparing(Commodity::getLength)).forEach(System.out::println);
	}

public void sortByWidth() {
	System.out.println("Before sorting, the goods were placed on the shelf in the following order:");
	add.forEach(System.out::println);
	
	System.out.println("After sorting, the order of the items on the shelf will be as follows:");
    add.stream().sorted(Comparator.comparing(Commodity::getWeight)).forEach(System.out::println);
	}

public void sortByWeight() {
	System.out.println("Before sorting, the goods were placed on the shelf in the following order:");
	add.forEach(System.out::println);
	
	
	System.out.println("After sorting, the order of the items on the shelf will be as follows:");
	add.stream().sorted(Comparator.comparing(Commodity::getWeight)).forEach(System.out::println);
	}

public void getCommodity() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the serial number of the product on the shelf:");
	int i =sc.nextInt();
	
	if (i<0 || i>(add.size()-1)) {
		System.out.println("Product with this serial number is not on the shelf");
	} 
	else {
		System.out.println("Under the ordinal " + i + " on the shelf is " + add.get(i).toString());
	}
}

static boolean isExists(ArrayList<Commodity> add, String name, int length, int width, int weight) {
	boolean flag = false;

	for (Commodity commodity : add) {
		if (commodity.getName().equalsIgnoreCase(name) && commodity.getLength() == length
				&& commodity.getWidth() == width && commodity.getWeight() == weight) {
			flag = true;
		}
	}

	return flag;
}


}
	

