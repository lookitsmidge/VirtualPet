package animals;

public class Dog extends Animal {
	public String[] toys = {"Stick", "Tennis ball"};
	
	public Dog(String name, int age) {
		super(name, age);
		
	}
	public void testWorks() {
		print("DOG", "My Name is: " + getName() + ", My Age is: " + getAge());
	}
}
