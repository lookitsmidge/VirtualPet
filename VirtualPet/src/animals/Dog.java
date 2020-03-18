package animals;
import java.util.Random;

/**
 * This class is for the pet of type Dog, that is a subclass of the animal class, which is abstract
 * @author James Martland
 *
 */
public class Dog extends Animal {
	public String[] toys = { "Stick", "Tennis ball" };
	private String[] food = { "Dog Food", "Dog Treat" };
	private String[] playResponses = { " plays tug of war with you", " plays fetch with you" };
	Random r  = new Random();
	
	public Dog(String name, int age) {
		super(name, age);
		this.type = "Dog";
		
	}
	public void testWorks() {
		printt("DOG", "My Name is: " + getName() + ", My Age is: " + getAge());
	}
	@Override
	public void speak() {
		print("Woooooof!");
		
	}
	@Override
	public void eat() {
		print( getName() + " Eats " + food[r.nextInt(food.length)] );
		
	}
	@Override
	public void showLove() {
		// TODO Auto-generated method stub
		print( getName() + " rubs their head on your leg." );
	}
	@Override
	public void sleep() { // make it so that if asleep doesnt respond...
		// TODO Auto-generated method stub
		print( getName() + " falls asleep" );
	}
	@Override
	public void wake() {
		// TODO Auto-generated method stub
		print( getName() + " wakes up" );
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		print( getName() + playResponses[r.nextInt(playResponses.length)] );
	}
	@Override
	public void special() {
		
	}
}
