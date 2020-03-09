package animals;

public class Goat extends Animal {

	/**
	 * This is the constructor for the dolphin animal
	 * @param name
	 * @param age
	 */
	public Goat(String name, int age) {
		super(name, age);
		this.type = "Goat";
	}

	public void testWorks() {
		printt("DOLPHIN", "Name: " + getName() + ", Age: " + getAge());
	}

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showLove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wake() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}
}
