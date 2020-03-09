package animals;

public class Chicken extends Animal {

	/**
	 * This is the constructor for the dolphin animal
	 * @param name
	 * @param age
	 */
	public Chicken(String name, int age) {
		super(name, age);
	}

	public void testWorks() {
		print("CHICKEN", "Name: " + getName() + ", Age: " + getAge());
	}
}
