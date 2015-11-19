public class MyMap implements SimpleMap {
	private MapLink head = null;	
	
	
	/**
	* Puts a new String in the map.
	*
	* If the key is already in the map, nothing is done.
	*/
	public void put(int key, String name) {		
		MapLink newEntry = new MapLink(key, name);
		if (head == null) {
			head = newEntry;
		} else {
			MapLink current = head;
			while (current.getNext() != null) {
				if (current.getKey() == key) {
					return;
				}
				current = current.getNext();
			}
			current.setNext(newEntry);
		}
	}
	
	
	/**
	* Returns the name associated with that key,
	* or null if there is none.
	*/
	public String get(int key) {
		MapLink current = head;
		while (current != null) {
			if (current.getKey() == key) {
				return current.getValue();
			}
			current = current.getNext();
		}
		return null;
	}
	
	
	/**
	* Removes a name from the map. Future calls to get(key)
	* will return null for this key unless another
	* name is added with the same key.
	*/
	public void remove(int key) {
		if (head == null) {
			System.out.println("Key " + key + " not found.");
		} else if (head.getKey() == key ) {
			head = head.getNext();
		} else {
			MapLink current = head;
			while (current.getNext() != null && current.getNext().getKey() != key) {
				current = current.getNext();
			}
			if (current.getNext() == null) {
				System.out.println("Key " + key + " not found.");
				return;
			} else {
				current.setNext(current.getNext().getNext());
			}
		}
	}	
	
	/**
	* Returns true if there are no workers in the map,
	* false otherwise
	*/
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}
	
	public void launch() {
		System.out.println(isEmpty());
		put(1, "Jim");
		put(3, "Ben");
		put(2, "Sam");
		System.out.println(isEmpty());
		System.out.println(get(1));
		System.out.println(get(2));
		System.out.println(get(3));
		remove(1);
		remove(3);
		remove(3);
		remove(2);
		remove(2);
		System.out.println(get(1));
		System.out.println(get(2));
		System.out.println(get(3));
		System.out.println(isEmpty());	
		put(1, "Rob");
		put(1, "Tim");
		System.out.println(get(1));
		remove(4);
		remove(1);
		remove(1);
		
	}
	
	public static void main(String[] args) {
		MyMap driver = new MyMap();
		driver.launch();
	}
}