public class HashTableScript {
	public static void main(String[] args) {
		HashTableImp myImp = new HashTableImp();
		myImp.put(5, "Jim");
		myImp.put(5, "Ben");		
		myImp.put(5, "Tom");
		myImp.put(5, "Ali");
		myImp.put(5, "Ali");
		myImp.put(5, "Ali");
		myImp.put(5, "Ali");
		myImp.put(5, "Ali");
		myImp.put(5, "Ali");
		myImp.put(5, "Ali");
		myImp.put(5, "Ali");		
		String[] x = new String[10];
		x = myImp.get(5);
		for (int i = 0; i < x.length; i++) { 
			System.out.println(x[i]);
		}
		System.out.println();
		myImp.remove(5, "Tom");
		x = myImp.get(5);
		for (int i = 0; i < x.length; i++) { 
			System.out.println(x[i]);
		}
		System.out.println();
		System.out.println(myImp.isEmpty());
		myImp.remove(5, "Jim");
		myImp.remove(5, "Ben");
		myImp.remove(5, "Ali");
		System.out.println(myImp.isEmpty());
		x = myImp.get(5);
		for (int i = 0; i < x.length; i++) { 
			System.out.println(x[i]);
		}
	}
}