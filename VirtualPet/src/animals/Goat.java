package animals;

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
	public void testWorks() {
		printt("GOAT", "My Name is: " + getName() + ", My Age is: " + getAge());
	}
	/**
	* Methods for the goat pet acitons
	*/
	@Override
	public void speak() {
		print ("BLEEEAT");
	}

	@Override
	public void eat() {
		print(getName() + " is eating grass");		
	}

	@Override
	public void showLove() {
		print("ðŸ�� :D");
		
	}

	@Override 
	public void sleep() {
		print(getName() + " has gone to sleep.");	
	}

	@Override
	public void wake() {
		print(getName() + " has woken up from their sleep.");	
	}

	@Override
	public void play() {
		print(getName() + " is playing with their beach ball");		
	}
}
