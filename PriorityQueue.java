public class PriorityQueue implements PersonQueue {
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
			//cycle to the front of the queue
			while (current.getNext() != null) {
				current = current.getNext();
			}			
			//cycle through queue until you find someone 65+
			while (current.getPrevious() != null) {
				if (current.getAge() >= 65) {
					break;
				}
				current = current.getPrevious();
			}			
			//check you have found someone that age, if not repeat the process but with 18+
			if (current.getAge() < 65) {
				while (current.getNext() != null) {
					current = current.getNext();
				}
				while (current.getPrevious() != null) {
					if (current.getAge() >= 18) {
						break;
					}
					current = current.getPrevious();
				}
			}	
			//check you have found someone 18+ if not go to start of queue
			if (current.getAge() < 18) {
				while (current.getNext() != null) {
				current = current.getNext();
				}
			}
			//now current should be on the correct person to serve we 
			//can re-arrange pointers based on where they are in the queue
			if (current.getPrevious() != null && current.getNext() != null) {
				//has customers either side of him in the queue
				current.getPrevious().setNext(current.getNext());
				current.getNext().setPrevious(current.getPrevious());
				System.out.println("Customer " + current.getName() + " has been served.");
				return current;				
			} else if (current.getPrevious() == null) {
				//is last in the queue
				head = current.getNext();
				current.getNext().setPrevious(null);
				System.out.println("Customer " + current.getName() + " has been served.");
				return current;				
			} else {
				//is first in the queue
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
		Person p1 = new Person("Dave", 17);
		addPerson(p1);
		Person p2 = new Person("Tim", 55);
		addPerson(p2);
		Person p3 = new Person("Ben", 66);
		addPerson(p3);
		Person p4 = new Person("Sam", 87);
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
		PriorityQueue mySupermarket = new PriorityQueue();
		mySupermarket.launch();
	}
}