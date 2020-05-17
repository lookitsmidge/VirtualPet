package animals;
import utilities.ProcessorTemplate;
/**
 * This class is the main class for the animals to inherit from
 * @author James Martland 24233781
 *
 */
public abstract class Animal extends ProcessorTemplate {
	//these are the universal attributes of all of the animals that are going to be created
	private String name;
	private int age;
	public String type;
	protected boolean asleep;

	
	/**
	 * This is the constructor for the class
	 */
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
		//Run a Thread Test? to decrease Happiness
	}
	
	/**
	 * This is an abstract Class, this will be implemented in subclasses of this
	 * @return response
	 */
	public abstract String speak();
	
	/**
	 * This is an abstract Class, this will be implemented in subclasses of this
	 * @return response
	 */
	public abstract String eat();
	
	/**
	 * This is an abstract Class, this will be implemented in subclasses of this
	 * @return response
	 */
	public abstract String showLove();
	
	/**
	 * This is an abstract Class, this will be implemented in subclasses of this
	 * @return response
	 */
	public abstract String sleep();
	
	/**
	 * This is an abstract Class, this will be implemented in subclasses of this
	 * @return response
	 */
	public abstract String wake();
	
	/**
	 * This is an abstract Class, this will be implemented in subclasses of this
	 * @return response
	 */
	public abstract String play();
	
	/**
	 * This is an abstract Class, this will be implemented in subclasses of this
	 * @return response
	 */
	public abstract String special();
	
	/**
	 * This is to set the value of the class variable age
	 * @param age
	 */
	public final void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * This is to retrieve the value of the class variable age
	 * @return
	 */
	public final int getAge() {
		return this.age;
	}
	
	/**
	 * This is to set the value of the class variable name
	 * @param name
	 */
	public final void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This is to retrieve the value of the class variable name
	 * @return
	 */
	public final String getName() {
		return this.name;
	}
	
	/**
	 * This is to retrieve the type of Animal it is
	 * @return
	 */
	public final String getType() {
		return this.type;
	}
	
	/**
	 * This method is meant to make writing this shit to a file easier
	 * Putting this in the animal superclass means that all objects that are under this WILL have it
	 * it is final so nooone overwrites it, because if they do everything will break
	 * @return this.type + this.name + this.age;
	 */
	public final String toString() {
		return this.type + "," + this.name + "," + this.age ;
	}
	
}
