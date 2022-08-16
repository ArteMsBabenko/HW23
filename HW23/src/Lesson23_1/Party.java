package Lesson23_1;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Party {
	
	private String PartyName;
	
	public Party(String PartyName) {
		this.PartyName=PartyName;
	}

	public String getPartyName() {
		return PartyName;
	}

	public void setPartyName(String partyName) {
		PartyName = partyName;
	}
	
	ArrayList<Deputy> PartyArray = new ArrayList<Deputy>();

	Supplier<Deputy> CreateDeputy = () -> {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the deputy's second name:");
		String second_name = sc.next();
		System.out.println("Enter the deputy's first name:");
		String first_name = sc.next();
		System.out.println("Enter the age of the deputy:");
		int age = sc.nextInt();
		System.out.println("Enter the MP's height:");
		int height = sc.nextInt();
		System.out.println("Enter MP's weight:");
		int weight = sc.nextInt();
		System.out.println("Does the MP take bribes? True or false?:");
		boolean bribe_taker_ = sc.nextBoolean();
		
		return new Deputy ( weight,  height, second_name, first_name,age,bribe_taker_);
	};
		 
	Supplier<Deputy> getDeputy = () -> {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the deputy's second name: ");
		String first_name = sc.next();
		System.out.println("Enter the deputy's first name:");
		String second_name = sc.next();
		
		return new Deputy ( second_name, first_name);
	};
	    
	public void addDeputy() {
	
		Deputy deputy = CreateDeputy.get();
		
		if(deputy.isBribe_taker()) {
			deputy.give_bribe();
		}
		
		PartyArray.add(deputy);
	    System.out.println("Deputy " + deputy.toString() + " successfully added to faction");
	}
	
	public void removeDeputy() {
		
		Deputy DeputyTyped = getDeputy.get();
		
		Predicate<Deputy> isEqualsSenond_Name = deputy -> deputy.getSecond_name().equalsIgnoreCase(DeputyTyped.getSecond_name()) && deputy.getFirst_name().equalsIgnoreCase(DeputyTyped.getFirst_name());
				Optional<Deputy> deputyFound = PartyArray.stream().filter(isEqualsSenond_Name).findFirst();
		
		if(deputyFound.isPresent()) {
			
			PartyArray.remove(deputyFound.get());
			System.out.println("Deputy " + deputyFound.get().toString() + " successfully removed from faction!");
			
			
		  }
		
		else {
			System.out.println("This deputy does not exist");
		}
		
	}
	
	public void getBribeTakers() {
		System.out.println("Deputies of the faction taking bribes:");
		
		
		List<Deputy> bribeTakers = PartyArray.stream().filter(Deputy::isBribe_taker).collect(Collectors.toList());
		bribeTakers.forEach(System.out::println);
	}
	
	public void getLargestСorruptor() {
	 
		Comparator<Deputy> deputyBribe_SizeComparator = (deputy1,
				deputy2) -> (deputy1.getBribe_size() > deputy2.getBribe_size()) ? 1
						: (deputy1.getBribe_size() == deputy2.getBribe_size()) ? 0 : -1;
		Optional<Deputy> LargestСorruptor = PartyArray.stream().filter(Deputy::isBribe_taker)
				.max(deputyBribe_SizeComparator);
		
		
	 if(LargestСorruptor.isPresent()) {
		 System.out.println("Faction's Biggest Briber " + LargestСorruptor.get().toString());
	 }
	 
	 else {
		 System.out.println("There are no bribe takers in this party");
	 }
	 
	}
	
	public void getAllDeputies() {
		System.out.println("Members of this faction:");
		
		PartyArray.forEach(System.out::println);
	}
	
	public void clear() {
		PartyArray.clear();
		System.out.println("All deputies have been successfully removed from the faction");
	}
	
	
	public String toString() {
    return "Faction \"" + PartyArray + "\"";
	}
	
	
}
