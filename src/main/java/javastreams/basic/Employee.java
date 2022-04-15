package javastreams.basic;

public class Employee {
	private String name ;
	private Boolean enriched = false;
	private Integer id;
	private String contactNumber;
	
	
	public Employee(String name, Boolean enriched, Integer id, String contactNumber) {
		super();
		this.name = name;
		this.enriched = enriched;
		this.id = id;
		this.contactNumber = contactNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Boolean getEnriched() {
		return enriched;
	}


	public void setEnriched(Boolean enriched) {
		this.enriched = enriched;
	}


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


	@Override
	public String toString() {
		return "Employee [name=" + name + ", enriched=" + enriched + ", id=" + id + ", contactNumber=" + contactNumber
				+ "]";
	}
}
