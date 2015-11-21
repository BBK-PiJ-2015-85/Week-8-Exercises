public class OldPersonSupermarket implements PersonQueue {
	private Person head = null;
	
	public void insert(Person person) {
		if (head == null) {
			head = person;
		} else {
			person.setNext(head);
			head.setPrevious(person);			
			head = person;
		}
	}
	/**
	* Removes a person from the queue.
	*/
	public Person retrieve(){
		if (head == null) {
			//no one in the queue
			System.out.println("There are no customers to serve.");
			return null;			
		} else if (head.getNext()  == null) {
			//only one person in the queue
			Person current = head;
			System.out.println("Customer " + current.getName() + " has been served.");
			head = null;
			return current;			
		} else {
			Person current = head;
			int oldest = 0;
			//go through queue and store the oldest age
			while (current != null) {
				if (current.getAge() > oldest) {
					oldest = current.getAge();
				}
				current = current.getNext();
			}
			current = head;
			//go through queue until you reach the oldest and serve them
			while (current.getAge() != oldest) {
				current = current.getNext();
			}			
			if (current.getPrevious() != null && current.getNext() != null) {
				//oldest has customers either side of him in the queue
				current.getPrevious().setNext(current.getNext());
				current.getNext().setPrevious(current.getPrevious());
				System.out.println("Customer " + current.getName() + " has been served.");
				return current;				
			} else if (current.getPrevious() == null) {
				//oldest is last in the queue
				head = current.getNext();
				current.getNext().setPrevious(null);
				System.out.println("Customer " + current.getName() + " has been served.");
				return current;				
			} else {
				//oldest is first in the queue
				current.getPrevious().setNext(null);
				System.out.println("Customer " + current.getName() + " has been served.");
				return current;				
			}			
		}
	}
	
	public void addPerson(Person newPerson) {
		insert(newPerson);
	}
	
	public void servePerson() {
		retrieve();
	}
	
	public int queueLength() {
		Person current = head;
		int count = 0;
		while (current != null) {
			count++;
			current = current.getNext();
		}
		return count;
	}
	
	public void launch() {
		Person p1 = new Person("Dave", 55);
		addPerson(p1);
		Person p2 = new Person("Tim", 10);
		addPerson(p2);	
		Person p3 = new Person("Ben", 78);
		addPerson(p3);
		Person p4 = new Person("Sam", 30);
		addPerson(p4);
		Person p5 = new Person("Jim", 24);
		addPerson(p5);		
		Person p6 = new Person("Dan", 75);
		addPerson(p6);
		Person p7 = new Person("Will", 1);
		addPerson(p7);
		System.out.println(queueLength());
		servePerson();
		servePerson();
		servePerson();
		servePerson();
		servePerson();
		servePerson();
		servePerson();
		System.out.println(queueLength());
		servePerson();
		

	}
	public static void main(String[] args) {
		OldPersonSupermarket mySupermarket = new OldPersonSupermarket();
		mySupermarket.launch();
	}
}