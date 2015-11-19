public class MapLink {
	private int key;
	private String value;
	private MapLink next;
	
	public MapLink(int key, String value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}
	
	public MapLink getNext() {
		return next;
	}
	
	public void setNext(MapLink next) {
		this.next = next;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}