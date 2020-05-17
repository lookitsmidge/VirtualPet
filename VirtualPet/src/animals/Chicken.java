package animals;

/**
 * This class is for the pet of type Chicken, that is a subclass of the animal class, which is abstract
 * @author James Martland 24233781
 */
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
	
	/**
	 * This method displays all the relevant details
	 */
	public void testWorks() {
		printt("CHICKEN", "Name: " + getName() + ", Age: " + getAge());
	}
	
	/**
	 * This method makes the animal speak
	 */
	@Override
	public String speak() {
		// TODO Auto-generated method stub
		print("Cluccck!");
		return "CLuccck!";
	}

	/**
	 * This method makes the animal eat
	 */
	@Override
	public String eat() {
		// TODO Auto-generated method stub
		print(getName() + " is eating corn");
		return getName() + " is eating corn";
	}

	/**
	 * This method makes the animal show love
	 */
	@Override
	public String showLove() {
		// TODO Auto-generated method stub
		print(getName() + " rubs its head  against your leg");
		return getName() + " rubs its head against your leg";
	}

	/**
	 * This method makes the animal sleep
	 */
	@Override
	public String sleep() {
		// TODO Auto-generated method stub
		print(getName() + " is now asleep in its roost");
		return getName() + " is now asleep in its roost";
	}

	/**
	 * This method makes the animal wake up
	 */
	@Override
	public String wake() {
		// TODO Auto-generated method stub
		print(getName() + " is now awake");
		return getName() + " is now awake";
	}

	/**
	 * This method makes the animal play
	 */
	@Override
	public String play() {
		// TODO Auto-generated method stub
		print( getName() + " plays with a wooden ball" );
		return getName() + " palys with a wooden ball";
	}

	/**
	 * This method makes the animal do a special thing
	 */
	@Override
	public String special() {
		print( getName() +  " lays an egg");
		return getName() +  " lays an egg";
	}
}
