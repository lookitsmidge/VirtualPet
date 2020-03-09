package animals;

public class Goat extends Animal {

	/**
	 * This is the constructor for the dolphin animal
	 * @param name
	 * @param age
	 */
	public Goat(String name, int age) {
		super(name, age);
	}

	public void testWorks() {
		print("DOLPHIN", "Name: " + getName() + ", Age: " + getAge());
	}
}
