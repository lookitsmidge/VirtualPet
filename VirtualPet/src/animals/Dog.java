package animals;
import java.util.Random;

/**
 * This class is for the pet of type Dog, that is a subclass of the animal class, which is abstract
 * @author James Martland 24233781
 *
 */
public class Dog extends Animal {
	public String[] toys = { "Stick", "Tennis ball" };
	private String[] food = { "Dog Food", "Dog Treat" };
	private String[] playResponses = { " plays tug of war with you", " plays fetch with you" };
	Random r  = new Random();
	
	/**
	 * This is the constructor for the cat animal
	 * @param name
	 * @param age
	 */
	public Dog(String name, int age) {
		super(name, age);
		this.type = "Dog";
	}

	/**
	 * This method displays all the relevant details
	 */
	public void testWorks() {
		printt("DOG", "My Name is: " + getName() + ", My Age is: " + getAge());
	}

	/**
	 * This method makes the animal speak
	 */
	@Override
	public String speak() {
		print("Woooooof!");
		return "Woooooof!";
	}

	/**
	 * This method makes the animal show love
	 */
	@Override
	public String eat() {
		print( getName() + " Eats " + food[r.nextInt(food.length)] );
		return getName() + " Eats " + food[r.nextInt(food.length)];
	}
	
	/**
	 * This method makes the animal show love
	 */
	@Override
	public String showLove() {
		// TODO Auto-generated method stub
		print( getName() + " rubs their head on your leg." );
		return getName() + " rubs their head on your leg.";
	}

	/**
	 * This method makes the animal sleep
	 */
	@Override
	public String sleep() { // make it so that if asleep doesnt respond...
		// TODO Auto-generated method stub
		print( getName() + " falls asleep" );
		return getName() + " falls asleep";
	}

	/**
	 * This method makes the animal wake up
	 */
	@Override
	public String wake() {
		// TODO Auto-generated method stub
		print( getName() + " wakes up" );
		return getName() + " wakes up";
	}

	/**
	 * This method makes the animal play
	 */
	@Override
	public String play() {
		// TODO Auto-generated method stub
		print( getName() + playResponses[r.nextInt(playResponses.length)] );
		return getName() + playResponses[r.nextInt(playResponses.length)];
	}

	/**
	 * This method makes the animal do a special thing
	 */
	@Override
	public String special() {
		print( getName() + " brings back a bone");
		return getName() + " brings back a bone";
	}
}
