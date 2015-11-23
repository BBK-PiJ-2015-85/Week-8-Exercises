class HashTableImp implements HashTable {
	private int[] key; 
	private String[][] values; 
	
	public HashTableImp() {
		this.key = new int[10];
		this.values = new String[10][10]; 
	}
	
	/**
	* Puts a new String in the map.
	*/
	public String put(int key, String name) {
		int position = -1;
		//check and see if key already exists and remember position if it does
		for (int i = 0; i < this.key.length; i++) {
			if (this.key[i] == key) {
				position = i;
				break;
			}			
		}
		
		//if it doesn't exist find the first 0 (empty slot)
		if (position == -1) {
			for (int i = 0; i < this.key.length; i++) {
				if (this.key[i] == 0) {
					this.key[i] = key;
					position = i;
					break;
				}				
			}
		}
		
		//check the length of key array, if it is full then double the length
		if (this.key[position] == this.key.length - 1) {
			int [] temp = new int[this.key.length * 2];
			for (int i = 0; i < this.key.length; i++ ) {
				temp[i] = this.key[i];
			}
			this.key = temp;
		}
		
		//now we know the correct key position we use that and scroll through the
		//array at that position and store the new string in the first empty slot.
		for (int j = 0; j < this.values[position].length; j++) {
			if (this.values[position][j] == null) {
				this.values[position][j] = name;
				//check to see that this array is not full, if it is then double the size of it.
				if (j == this.values[position].length - 1) {
					String[] temp = new String[this.values[position].length * 2];
					for (int k = 0; k < this.values[position].length; k++) {
						temp[k] = this.values[position][k];								
					}
					this.values[position] = temp;												
				}
				break;				
			} 
		}		
		return name;
	}
	
	/**
	* Returns all the names associated with that key,
	* or null if there is none.
	*/
	public String[] get(int key) {
		//find the position of the key 
		int position = -1;
		for (int i = 0; i < this.key.length; i++) {
			if (this.key[i] == key) {
				position = i;
				break;
			}
		}
		//now return the array at that position
		return this.values[position];		
	}
	
	/**
	* Removes a name from the map.
	*/
	public void remove(int key, String name) {
		//find the position of the key 
		int position = -1;
		for (int i = 0; i < this.key.length; i++) {
			if (this.key[i] == key) {
				position = i;
				break;
			}
		}
		//find the name to delete and set to null
		for (int i = 0; i < this.values[position].length; i++) {
			if (this.values[position][i] != null) {
				if (this.values[position][i].equals(name)) {
					this.values[position][i] = null;
				}
			}
		}		
	}
	
	/**
	* Returns true if there are no workers in the map,
	* false otherwise
	*/
	public boolean isEmpty() {
		for (int i = 0; i < this.values.length; i++) {
			for (int j = 0; j < this.values[i].length; j++) {
				if (this.values[i][j] != null) {
					return false;
				}
			}
		}
		return true;
	}
}