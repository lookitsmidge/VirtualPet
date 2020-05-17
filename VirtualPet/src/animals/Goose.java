package animals;
/**
 * This class is for the pet of type Cat, that is a subclass of the animal class, which is abstract
 * @author James Martland 24233781 (Basis template), Matthew Milburn
 */
public class Goose extends Animal {
	
	/**
	 * This is the constructor for the goose animal
	 * @param name
	 * @param age
	 */
	public Goose(String name, int age) {
		super(name, age);
		this.type = "Goose";
	}
	
	/**
	 * This method displays all the relevant details
	 */
	public void testWorks() {
		printt("GOOSE", "Name: " + getName() + ", Age: " + getAge());
	}

	/**
	 * This method makes the animal speak
	 */
	@Override
	public String speak() {
		print("HONK!");
		return "HONK!";
	}

	/**
	 * This method makes the animal eat
	 */
	@Override
	public String eat() {
		print(getName() + "is eating seeds");
		return getName() + " is eating seeds";
	}

	/**
	 * This method makes the animal show love
	 */
	@Override
	public String showLove() {
		print("Honk <3");
		return "Honk <3";
	}

	/**
	 * This method makes the animal sleep
	 */
	@Override
	public String sleep() {
		print(getName() + "falls asleep");
		return getName() + " falls asleep";
	}

	/**
	 * This method makes the animal wake up
	 */
	@Override
	public String wake() {
		print(getName() + "wakes up");
		return getName() + " wakes up";
	}

	/**
	 * This method makes the animal play
	 */
	@Override
	public String play() {
		print(getName() + "is playing with a squeaky toy");
		return getName() + " is playing wiht a sqeaky toy";
	}

	/**
	 * This method makes the animal do a special thing
	 */
	@Override
	public String special() {
		print( getName() + " plays a harmonica");
		return getName() + " plays a harmonica";
	}
}
