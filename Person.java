public class Person {
	private String name;
	private int age;
	private Person next;
	private Person previous;
	
	public Person(String name, int age){
		this.name = name;
		this.age = age;
		this.next = null;
		this.previous = null;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public Person getNext(){
		return next;
	}
	
	public Person getPrevious() {
		return previous;
	}
	
	public void setNext(Person next) {
		this.next = next;
	}
	
	public void setPrevious(Person previous) {
		this.previous = previous;
	}
}