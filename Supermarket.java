public class Supermarket implements PersonQueue {
	private Person queueStart = null;
	
	public void insert(Person person) {
		if (queueStart == null) {
			queueStart = person;
		} else {
			Person current = queueStart;
			while(current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(person);
			person.setPrevious(current);
		}
	}
	/**
	* Removes a person from the queue.
	*/
	public Person retrieve(){
		return queueStart;
	}
	
	public void addPerson(Person newPerson) {
		insert(newPerson);
	}
	
	public void servePerson() {
		retrieve();
		queueStart = queueStart.getNext();
		queueStart.setPrevious(null);
	}
	
	public int queueLength() {
		Person current = queueStart;
		int count = 0;
		while (current != null) {
			count++;
			current = current.getNext();
		}
		return count;
	}
	
	public void launch() {
		Person p1 = new Person("Dave");
		addPerson(p1);
		Person p2 = new Person("Tim");
		addPerson(p2);
		System.out.println(queueLength());
		Person p3 = new Person("Ben");
		addPerson(p3);
		Person p4 = new Person("Sam");
		addPerson(p4);
		servePerson();
		servePerson();
		System.out.println(queueLength());
		Person p5 = new Person("Jim");
		addPerson(p5);
		Person p6 = new Person("Dan");
		addPerson(p6);
		Person p7 = new Person("Will");
		addPerson(p7);
		System.out.println(queueLength());
		servePerson();
		servePerson();
		servePerson();
		servePerson();
		servePerson();
		System.out.println(queueLength());		
	}
	public static void main(String[] args) {
		Supermarket mySupermarket = new Supermarket();
		mySupermarket.launch();
	}
}