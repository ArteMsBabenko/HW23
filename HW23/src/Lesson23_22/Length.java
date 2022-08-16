package Lesson23_22;

import java.util.Comparator;

public class Length implements Comparator<Commodity> {

	@Override
	public int compare(Commodity o1, Commodity o2) {
		if (o1.getLength() > o2.getLength()) {
			return 1;
		} else if (o1.getLength() < o2.getLength()) {
			return -1;
		}
		return 0;
	}

}
