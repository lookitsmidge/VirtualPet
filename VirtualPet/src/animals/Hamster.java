package animals;

public class Hamster extends Animal {
	
	public Hamster(String name, int age) {
		super(name, age);
		
	}
	
	/**
	 * This is a method to test if the class works
	 */
	public void testWorks() {
		print("HAMSTER", "Name: " + getName() + ", Age: " + getAge());
	}

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showLove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wake() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}
}
