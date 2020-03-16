package animals;

public class Goose extends Animal {
	
	public Goose(String name, int age) {
		super(name, age);
		this.type = "Goose";
	}
	
	/**
	 * This is a method to test if the class works
	 */
	public void testWorks() {
		printt("GOOSE", "Name: " + getName() + ", Age: " + getAge());
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
