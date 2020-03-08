package animals;

public class Dog extends Animal {
	public String[] toys = {"Stick", "Tennis ball"};
	
	public Dog(String name, int age) {
		super(name, age);
		
	}
	public void sayAll() {
		print("[DOG]", "My Name is: " + getName() + ", My Age is: " + getAge());
	}
}
