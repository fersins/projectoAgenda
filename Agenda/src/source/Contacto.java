package source;

public class Contacto {

	private String name;
	private long phoneNumber;

	public Contacto(long phoneNumber, String name) {
		this.phoneNumber = phoneNumber;
		this.name = name;

	}

	public String getName() {
		return this.name;
	}

	public long getPhoneNumber() {
		return this.phoneNumber;
	}
}
