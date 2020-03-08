package animals;

public class Hamster extends Animal {
	
	public Hamster(String name, int age) {
		super(name, age);
		
	}
	
	/**
	 * This is a method to test if the class works
	 */
	public void testWorks() {
		print("HAMSTER", "Name: " + getName() + ", Age: " + getAge());
	}
}
