package animals;

public class Cat extends Animal{
	String[] toys = {"Wool", "lazer"};
	
	public Cat(String name, int age) {
		super(name, age);
	}
	
	/**
	 * This is a method to test shit
	 */
	public void testWorks() {
		printt("CAT", "Name: " + getName() + ", Age: " + getAge());
	}
	//randomise play with toy responses

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
