package animals;

public class Cat extends Animal{
	String[] toys = {"Wool", "lazer"};
	
	public Cat(String name, int age) {
		super(name, age);
		this.type = "Cat";
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
		print("Nyaa");
		
	}

	@Override
	public void eat() {
		print(getName() + "is eating fish");
		
	}

	@Override
	public void showLove() {
		print("Purr <3");
		
	}

	@Override
	public void sleep() {
		print(getName() + "falls asleep");
		
	}

	@Override
	public void wake() {
		print(getName() + "wakes up");
		
	}

	@Override
	public void play() {
		print(getName() + "is chasing a piece of string");
		
	}
}
