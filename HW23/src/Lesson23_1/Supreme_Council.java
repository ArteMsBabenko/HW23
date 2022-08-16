package Lesson23_1;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class Supreme_Council {
	
	private static Supreme_Council instance = new Supreme_Council();
	
	private Supreme_Council() {
		
	}
	
	public static Supreme_Council getInstance() {
		if (instance == null) {
			
			instance = new Supreme_Council();
		}
		return instance;
	}
	
	ArrayList<Party> SCArray = new ArrayList<Party>();
	
	Supplier<Party> getParty = () -> {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the faction:");
		String PartyName = sc.next();

		return new Party(PartyName);
	};

	public Optional<Party> findParty() {
		Party PartyTyped = getParty.get();

		Predicate<Party> isEqualPartyName = deputyGroup -> deputyGroup.getPartyName().equalsIgnoreCase(PartyTyped.getPartyName());
		Optional<Party> PartyFound = SCArray.stream().filter(isEqualPartyName).findFirst();

		return PartyFound;
	}

	public void addParty() {
		Party Party = getParty.get();

		SCArray.add(Party);
		System.out.println(Party.toString() + " successfully added to the Verkhovna Rada");
	}

	public void removeParty() {
		Optional<Party> PartyFound = findParty();

		if (PartyFound.isPresent()) {
			SCArray.remove(PartyFound.get());
			System.out.println(PartyFound.get().toString() + "successfully removed from the Verkhovna Rada");
		} else {
			System.out.println("There is no introduced faction in the Verkhovna Rada");
		}
	}

	public void getAllPartyes() {
		System.out.println("Fractions registered in Verkhona Rada:");
		SCArray.forEach(System.out::println);
	}

	public void clear() {
		Optional<Party> PartyFound = findParty();

		if (PartyFound.isPresent()) {
			PartyFound.get().clear();
		} else {
			System.out.println("There is no introduced faction in the Verkhovna Rada");
		}
	}

	public void getParty() {
		Optional<Party> PartyFound = findParty();

		if (PartyFound.isPresent()) {
			System.out.println(PartyFound.get().toString());
			PartyFound.get().getAllDeputies();
		} else {
			System.out.println("There is no introduced faction in the Verkhovna Rada");
		}
	}

	public void addDeputyToParty() {
		Optional<Party> PartyFound = findParty();

		if (PartyFound.isPresent()) {
			PartyFound.get().addDeputy();
		} else {
			System.out.println("There is no introduced faction in the Verkhovna Rada");
		}
	}

	public void removeDeputyFromParty() {
		Optional<Party> PartyFound = findParty();

		if (PartyFound.isPresent()) {
			PartyFound.get().removeDeputy();
		} else {
			System.out.println("There is no introduced faction in the Verkhovna Rada");
		}
	}

	public void getBribeTakersFromParty() {
		Optional<Party> PartyFound = findParty();

		if (PartyFound.isPresent()) {
			PartyFound.get().getBribeTakers();
		} else {
			System.out.println("There is no introduced faction in the Verkhovna Rada");
		}
	}

	public void getLargestCorruptroFromParty() {
		Optional<Party> PartyFound = findParty();

		if (PartyFound.isPresent()) {
			PartyFound.get().getLargestСorruptor();
		} else {
			System.out.println("There is no introduced faction in the Verkhovna Rada");
		}
	}

	public void getAllDeputiesFromParty() {
		Optional<Party> PartyFound = findParty();

		if (PartyFound.isPresent()) {
			PartyFound.get().getAllDeputies();
		} else {
			System.out.println("There is no introduced faction in the Verkhovna Rada");
		}
	}
}