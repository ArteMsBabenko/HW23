package Lesson23_22;

import java.util.Scanner;
import java.util.function.Supplier;

public class Main {
	
	public static void main(String[] args) {
	
		Supplier<Integer> menu = () -> {
		
		System.out.println();
		System.out.println("Enter 1 to add item to shelf");
		System.out.println("Enter 2 to remove the item from the shelf");
		System.out.println("Enter 3 to replace an item on the shelf");
		System.out.println("Enter 4 to sort the products on the shelf by their name");
		System.out.println("Enter 5 to sort the items on the shelf by their length");
		System.out.println("Enter 6 to sort items on the shelf by their width");
		System.out.println("Enter 7 to sort items on the shelf by their weight");
		System.out.println("Enter 8 to display the product by its serial number on the shelf");
		System.out.println("Enter 9 to exit the program");
	
		Scanner sc = new Scanner(System.in);
		int menuChoise = sc.nextInt();

		return menuChoise;
	};
	
		Add add = new Add();
		
		while (true) {

			switch (menu.get()) {

			case 1: {
				add.addCommodity();
				break;
			}

			case 2: {
				add.removeCommodity();
				break;
			}

			case 3: {
				add.replaceCommodity();
				break;
			}

			case 4: {
				add.sortByName();
				break;
			}

			case 5: {
				add.sortByLength();
				break;
			}

			case 6: {
				add.sortByWidth();
				break;
			}

			case 7: {
				add.sortByWeight();
				break;
			}

			case 8: {
				add.getCommodity();
				break;
			}

			case 9: {
				System.exit(0);
				break;
			}

			default: {
				System.out.println("Enter a number from 1 to 9");
				break;
			}
			}
		}

	}
	
}

