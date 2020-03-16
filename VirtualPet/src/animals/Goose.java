package animals;

public class Goose extends Animal {
	
	public Goose(String name, int age) {
		super(name, age);
		this.type = "Goose";
	}
	
	/**
	 * This is a method to test if the class works
	 */
	public void testWorks() {
		printt("GOOSE", "Name: " + getName() + ", Age: " + getAge());
	}

	@Override
	public void speak() {
		print("HONK!");
		
	}

	@Override
	public void eat() {
		print(getName() + "is eating seeds");
		
	}

	@Override
	public void showLove() {
		print("Honk <3");
		
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
		print(getName() + "is playing with a squeaky toy");
		
	}
	@Override
	public void special() {
		
	}
}
