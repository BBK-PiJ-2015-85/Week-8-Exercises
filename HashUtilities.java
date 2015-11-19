public class HashUtilities {
	
	public static int shortHash(int val) {
		if (val >= 0 && val <= 1000) {
			return val;
		} else if (val < 0 && val >= -1000) {
			return Math.abs(val);			
		} else if (val < -1000) {
			return Math.abs(val) % 1000;
		} else {
			return val % 1000;
		}
	}
	
	public static void main(String[] args) {
		String str;
		do {
		System.out.println("Give me a string and I will calculate its hash code. (Type END when finished.)");
		str = System.console().readLine();
		if (!str.equals("END")){
			int hash = str.hashCode();
			System.out.println("Hash = " + hash + ".");
			int smallHash = HashUtilities.shortHash(hash);
			System.out.println("Small Hash = 0 < " + smallHash + " < 1000.");
		}
		} while (!str.equals("END"));
	}
}