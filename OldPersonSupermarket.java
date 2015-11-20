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
			System.out.println("There are no customers to serve.");
			return null;			
		} else {
			Person current = head;
			int oldest = 0;
			while (current.getNext() != null) {
				if (current.getAge() > oldest) {
					oldest = current.getAge();
				}
				current = current.getNext();
			}			
			while (current.getAge() != oldest) {
				current = current.getPrevious();
			}			
			if (current.getPrevious() != null && current.getNext() != null) {
				current.getPrevious().setNext(current.getNext());
				current.getNext().setPrevious(current.getPrevious());
				System.out.println("Customer " + current.getName() + " has been served.");
				return current;				
			} else if (current.getPrevious() == null && current.getNext() == null) {
				head = null;
				System.out.println("Customer " + current.getName() + " has been served.");
				return current;				
			} else if (current.getPrevious() == null) {
				head = current.getNext();
				System.out.println("Customer " + current.getName() + " has been served.");
				return current;				
			} else {
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
		Person p1 = new Person("Dave", 5);
		addPerson(p1);
		Person p2 = new Person("Tim", 10);
		addPerson(p2);	
		servePerson();
		servePerson();

		/**
		Person p3 = new Person("Ben", 20);
		addPerson(p3);
		Person p4 = new Person("Sam", 30);
		addPerson(p4);
		System.out.println(queueLength());
		servePerson();
		System.out.println(queueLength());
		Person p5 = new Person("Jim", 55);
		addPerson(p5);
		servePerson();
		System.out.println(queueLength());
		Person p6 = new Person("Dan", 75);
		addPerson(p6);
		servePerson();
		System.out.println(queueLength());
		Person p7 = new Person("Will", 80);
		addPerson(p7);
		servePerson();
		System.out.println(queueLength());
		servePerson();
		servePerson();
		servePerson();
		System.out.println(queueLength());
		servePerson();
		**/

	}
	public static void main(String[] args) {
		OldPersonSupermarket mySupermarket = new OldPersonSupermarket();
		mySupermarket.launch();
	}
}