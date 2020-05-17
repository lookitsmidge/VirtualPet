package animals;

/**
 * This class is for the pet of type Goat, that is a subclass of the animal class, which is abstract
 * @author James Martland 24233781 (Basis Template), Asha Hall ( methods for goat actions )
 *
 */
public class Goat extends Animal {

	/**
	 * This is the constructor for the goat animal
	 * @param name
	 * @param age
	 */
	public Goat(String name, int age) {
		super(name, age);
		this.type = "Goat";
    }	

	/**
	 * This method displays all the relevant details
	 */
	public void testWorks() {
		printt("GOAT", "My Name is: " + getName() + ", My Age is: " + getAge());
	}

	/**
	 * This method makes the animal speak
	 */
	@Override
	public String speak() {
		print ("BLEEEAT");
		return "BLEEEAT";
	}

	/**
	 * This method makes the animal eat
	 */
	@Override
	public String eat() {
		print(getName() + " is eating grass");
		return getName() + " is eating grass";
	}

	/**
	 * This method makes the animal show love
	 */
	@Override
	public String showLove() {
		print("ðŸ�� :D");
		return "ðŸ�� :D";
	}

	/**
	 * This method makes the animal sleep
	 */
	@Override 
	public String sleep() {
		print(getName() + " has gone to sleep.");
		return getName() + " has gone to sleep";
	}

	/**
	 * This method makes the animal wake up
	 */
	@Override
	public String wake() {
		print(getName() + " has woken up from their sleep.");
		return getName() + " has woken up from their sleep";
	}

	/**
	 * This method makes the animal play
	 */
	@Override
	public String play() {
		print(getName() + " is playing with their beach ball");
		return getName() + " is playing with their beach ball";
	}

	/**
	 * This method makes the animal do a special thing
	 */
	@Override
	public String special() {
		print( getName() + " tries to climb a mountain, and falls down it");
		return getName() + " tries to climb a mountain, and falls down it";
	}
}
