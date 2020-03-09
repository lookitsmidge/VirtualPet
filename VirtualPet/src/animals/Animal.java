package animals;
import Utilities.ProcessorTemplate;// this  is so that I can have all of my print statements and stuff
public abstract class Animal extends ProcessorTemplate {
	//these are the universal attributes of all of the animals that are going to be created
	private String name;
	private int age;
//	protected int happiness = 10; // out of 20
//	protected int fitness = 5; // out of 10
	
	/**
	 * This is the constructor for the class
	 */
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
		
		//Run a Thread Test? to decrease Happiness
	}
	
	public abstract void speak();

	public abstract void eat();

	public abstract void showLove();

	public abstract void sleep();

	public abstract void wake();

	public abstract void play();
	
	/**
	 * This is to set the value of the class variable age
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * This is to retrieve the value of the class variable age
	 * @return
	 */
	public int getAge() {
		return this.age;
	}
	/**
	 * This is to set the value of the class variable name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * This is to retrieve the value of the class variable name
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	
}
