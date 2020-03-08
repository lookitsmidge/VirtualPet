package animals;

public class Cat extends Animal{
	String[] toys = {"Wool", "lazer"};
	
	public Cat(String name, int age) {
		super(name, age);
	}
	
	public void testWorks() {
		print("CAT", "Name: " + getName() + ", Age: " + getAge());
	}
	//randomise play with toy responses
}
