package Lesson23_1;

import java.util.*;
import java.util.function.Supplier;

public class Deputy extends Man{
	
	private String second_name;
	private String first_name;
	private int age;
	private boolean bribe_taker_;
	private int bribe_size;
	
	
	public Deputy (String second_name, String first_name) {
		this.first_name=first_name;
		this.second_name=second_name;
	}

	public Deputy(int weight, int height,String second_name,String first_name,int age, boolean bribe_taker_) {
		super(weight, height);
		this.second_name=second_name;
		this.first_name=first_name;
		this.age=age;
		this.bribe_taker_=bribe_taker_;
		
	}
	

	public String getSecond_name() {
		return second_name;
	}

	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBribe_taker() {
		return bribe_taker_;
	}

	public void setBribe_taker(boolean bribe_taker) {
		this.bribe_taker_ = bribe_taker;
	}

	public int getBribe_size() {
		return bribe_size;
	}

	public void setBribe_size(int bribe_size) {
		this.bribe_size = bribe_size;
	}
	
	public String bribe_taker_incorrect() {
		if (this.bribe_taker_) {
			return "Briber!";
		}
		else { return "Honest person";
		}
	} 
	
	public void give_bribe() {
		if (this.bribe_taker_ == false) {
			System.out.println("Does not take bribes");
		}
		
		else if(this.bribe_taker_ == true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the amount of the bribe:");
			int Amount = sc.nextInt();
			
			 if(Amount>5000) {
				 System.out.println("The police will (not) imprison the deputy");
			 }
			 else { this.bribe_size = Amount; 
			 }
		} 
		
	}
	
	Supplier<Integer> getBribeAmount =() -> {
		Scanner sc = new Scanner(System.in);
		int bribeAmount = sc.nextInt();
		
		return bribeAmount;
	};

	@Override
	public String toString() {
		return " second_name=" + second_name + ", first_name=" + first_name + ", age=" + age + ", getWeight()="
				+ getWeight() + ", getHeight()=" + getHeight() +  bribe_taker_incorrect();
	} 
	

}
