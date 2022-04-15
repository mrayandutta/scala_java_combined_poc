package javastreams.basic;

public class Contact {
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	private Integer id;
	private String contactNumber;
	@Override
	public String toString() {
		return "Contact [id=" + id + ", contactNumber=" + contactNumber + "]";
	}
	public Contact(Integer id, String contactNumber) {
		super();
		this.id = id;
		this.contactNumber = contactNumber;
	}
	
	

}
