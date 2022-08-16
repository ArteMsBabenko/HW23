package Lesson23_21;

import java.util.Comparator;

public class try2 implements Comparator<try1> {

	@Override
	public int compare(try1 o1, try1 o2) {
		if(o1.getInteger() > o2.getInteger()) {
			return 1;
		}
		else if(o1.getInteger() < o2.getInteger()) {
			return -1;
		}
		return 0;
	}
	
	

}
