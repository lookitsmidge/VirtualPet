package animals;
import java.util.Random;
public class Cat extends Animal{
	String[] toys = {"Wool", "lazer"};
	String[] birds = {"Bluetit", "Woodpecker", "Eagle", "Vulture", "Emu", "Dodo"};
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
	
	@Override
	public void special() {
		int rnd = new Random().nextInt(birds.length);
		print(getName() + "brings back a" + rnd);
	}
}
