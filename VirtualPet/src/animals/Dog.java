package animals;

public class Dog extends Animal {
	public String[] toys = {"Stick", "Tennis ball"};
	
	public Dog(String name, int age) {
		super(name, age);
		
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
