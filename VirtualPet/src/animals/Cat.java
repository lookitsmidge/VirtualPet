package animals;
import java.util.Random;
/**
 * This class is for the pet of type Cat, that is a subclass of the animal class, which is abstract
 * @author James Martland 24233781
 */
public class Cat extends Animal{
	
	String[] toys = {"Wool", "lazer"};
	String[] birds = {"Bluetit", "Woodpecker", "Eagle", "Vulture", "Emu", "Dodo"};
	
	
	
	/**
	 * This is the constructor for the cat animal
	 * @param name
	 * @param age
	 */
	public Cat(String name, int age) {
		super(name, age);
		this.type = "Cat";
	}
	
	/**
	 * This method displays all the relevant details
	 */
	public void testWorks() {
		printt("CAT", "Name: " + getName() + ", Age: " + getAge());
	}
	
	/**
	 * This method makes the animal speak
	 */
	@Override
	public String speak() {
		print("Nyaa");
		return "Nyaa";
	}
	
	/**
	 * This method makes the animal eat
	 */
	@Override
	public String eat() {
		print(getName() + " is eating fish");
		return getName() + " is eating fish";
	}
	
	/**
	 * This method makes the animal show love
	 */
	@Override
	public String showLove() {
		print("Purr <3");
		return "Purr <3";
	}
	
	/**
	 * This method makes the animal sleep
	 */
	@Override
	public String sleep() {
		print(getName() + " falls asleep");
		return getName() + " falls asleep";
	}
	
	/**
	 * This method makes the animal wake up
	 */
	@Override
	public String wake() {
		print(getName() + " wakes up");
		return getName() + " wakes up";
	}
	
	/**
	 * This method makes the animal play
	 */
	@Override
	public String play() {
		print(getName() + " is chasing a piece of string");
		return getName() + " is chasing a piece of string";
	}
	
	/**
	 * This method makes the animal do a special thing
	 */
	@Override
	public String special() {
		int rnd = new Random().nextInt(birds.length);
		print(getName() + " brings back a " + birds[rnd]);
		return getName() + " brings back a " + birds[rnd];
	}
}
