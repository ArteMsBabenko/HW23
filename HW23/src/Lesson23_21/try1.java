package Lesson23_21;

import java.util.Objects;

public class try1 {
	
	private String string;
	private int integer;
	
	public try1(String string, int integer) {
		this.string=string;
		this.integer=integer;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public int getInteger() {
		return integer;
	}

	public void setInteger(int integer) {
		this.integer = integer;
	}

	@Override
	public String toString() {
		return "try1 [string=" + string + ", integer=" + integer + "]";
	}

	@Override
	public int hashCode() {
		final int main = 7;
		int result = 1;
		result = main*result + integer;
		result = main*result + ((string == null) ? 0:string.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		try1 other = (try1) obj;
		if (integer != other.integer)
			return false;
		if (string == null) {
			if (other.string != null)
				return false;
		} else if (!string.equals(other.string))
			return false;
		return true;
	}

}
