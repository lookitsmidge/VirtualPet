package animals;

public class Chicken extends Animal {

	/**
	 * This is the constructor for the goat animal
	 * @param name
	 * @param age
	 */
	public Chicken(String name, int age) {
		super(name, age);
		this.type = "Chicken";
	}

	public void testWorks() {
		printt("CHICKEN", "Name: " + getName() + ", Age: " + getAge());
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
