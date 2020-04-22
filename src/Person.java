
public class Person implements Comparable<Person>{

	//DATA FIELDS
	private String personFirstName;
	private String personMiddleName;
	private String personLastName;
	private String personPhone;
	
	private Address personAddress;
	
	private String fullName;
	
	
	//CONSTRUCTORS
	public Person() {}
	public Person (String personFirstName, String personMiddleName, String personLastName, String personPhone, Address address) {
		this.personFirstName = personFirstName;
		this.personMiddleName = personMiddleName;
		this.personLastName = personLastName;
		this.personPhone = personPhone;
		
		this.personAddress = address;
		
		setFullName(personFirstName, personMiddleName, personLastName); //used to search by full name; the data is there so do it now
	}
	
	
	//METHODS
	@Override
    public int compareTo(Person person) {
        return this.fullName.compareTo(person.fullName);
    }
	
	
	//GETTERS & SETTERS	
	public String getPersonFirstName() {
		return personFirstName;
	}
	public void setPersonFirstName(String personFirstName) {
		this.personFirstName = personFirstName;
	}
	
	public String getPersonMiddleName() {
		return personMiddleName;
	}
	public void setPersonMiddleName(String personMiddleName) {
		this.personMiddleName = personMiddleName;
	}
	
	public String getPersonLastName() {
		return personLastName;
	}
	public void setPersonLastName(String personLastName) {
		this.personLastName = personLastName;
	}
	
	public String getPersonPhone() {
		return personPhone;
	}
	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}	
	
	public Address getPersonAddress() {
		return personAddress;
	}
	public void setPersonAddress(Address personAddress) {
		this.personAddress = personAddress;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String personFirstName, String personMiddleName, String personLastName) {
		 if ( personMiddleName != null && personMiddleName != "") {
			 this.fullName = personFirstName + " " + personMiddleName + " " + personLastName;
		 }else {
			 this.fullName = personFirstName + " " + personLastName;
		 }
		
	}
	
	
	
	
	
	
}//end class
