import java.util.Arrays;

public class Directory {
	
	//DATA FIELDS
	public Person[] persons = new Person[0]; 		//this is the only field; it is an array of Person objects
	
	
	//CONSTRUCTORS
	public Directory() {} 							//no-arg constructor
	
	
	//METHODS
	public void addNewPerson(Person person) { 				//person object is passed in by the PhoneBookTest createNewPerson() method
		
		Person[] temp = new Person[persons.length + 1]; 	//creates a temporary Person array that will hold one more element 
															//than what the Person array (persons) currently holds bc you can't
															//directly change the size of an existing array
		
		for (int i = 0; i < persons.length; i++) { 			//won't run when adding the very first entry in persons
			
			temp[i] = persons[i]; 							//copy what is already existing in persons into temp so nothing in persons gets lost
			
		}//end for loop
		
		temp[temp.length - 1] = person; //the person object passed in from PhoneBookTest createNewPerson() (line 13) 
										//is assigned to the LAST element of Person[] temp, i.e., [temp.length - 1]
										
		persons = temp;	//overwrite whatever was in Person[] persons with what is now in temp, which consists of everything that WAS
						//in persons (line 21) PLUS the new person object (line 25)
		
	}//end addNewPerson

	public void deletePerson(Person targetPerson) {
		
		Person[] temp = new Person[persons.length - 1]; 	//temp array of reduced size to hold source, but NOT the entry to delete
																	//we're deleting one entry so size is source - 1
		int i = 0;										//counter to control foreach-style loop
		for (Person person : persons) { 				//loop through person objects in myPhonebook (outer loop)
			if(!person.equals(targetPerson)) {			//if there's no match we want to keep the entry
				temp[i] = person;						//add object to be retained to temp array
				i++;									//increment counter
			}
		}

		persons = temp;
				
	}
	
	public Person[] searchByFirstName(String name) {
		
		name = name.trim();
		int length = 0;	//initialize a counter to hold number of matches found in the next block
		
		for (Person person : persons) {
			if (name.equals(person.getPersonFirstName())) {
				length +=1;
			}
		}
		
		//now, create a result array with a [length] equal to the number of matches found above
		Person[] result = new Person[length];	// () invokes the no-arg constructor to create space for what we find in the for loop
		
		//initialize a new counter to control the result array (not persons array) so elements are not overwritten in successive iterations
		int j = 0;
		
		for (Person person : persons) {
			if (name.equals(person.getPersonFirstName())) {
				result[j] = person;
				j++;
			}
		}

		return result;
		
	}//end searchByFirstName
	
	public Person[] searchByLastName(String name) {
		
		name = name.trim();
		//initialize a counter to hold number of matches found in the next block
		int length = 0;
		
		for (Person person : persons) {
			if (name.equals(person.getPersonLastName())) {
				length +=1;
			}
		}
		
		//now, create a result array with a [length] equal to the number of matches found above
		Person[] result = new Person[length];	// () invokes the no-arg constructor to create space for what we find in the for loop
		
		//initialize a new counter to control the result array (not persons array) so elements are not overwritten in successive iterations
		int j = 0;
		
		for (Person person : persons) {
			if (name.equals(person.getPersonLastName())) {
				result[j] = person;
				j++;
			}
		}

		return result;
		
	}//end searchByLastName

	public Person[] searchByFullName(String name) {
		
		name = name.trim();
		//initialize a counter to hold number of matches found in the next block
		int length = 0;

		for (Person person : persons) {
			if (name.equals(person.getFullName())) {
				length +=1;
			}
		}//end for
		
		Person[] result = new Person[length];
		
		//initialize a counter to control access to the result array elements
		int j = 0;

		for (Person person : persons) {
			if (name.equals(person.getFullName())) {
				result[j] = person;
				j++;
			}
		}//end for

		return result;
		
	}//end searchByFullName
	
	public Person[] searchByCity(String city) {
		
		city = city.trim();
		int length = 0;
		
		for (Person person : persons) {
			if (city.equals(person.getPersonAddress().getCity())) {
				length +=1;
			}
		}
		
		Person[] result = new Person[length];	
		int j = 0;

		for (Person person : persons) {
			if (city.equals(person.getPersonAddress().getCity())) {
				result[j] = person;
				j++;
			}
		}//end for

		return result;
		
	}//end searchByCity
	
	public Person[] searchByState (String state) {

		state = state.toUpperCase().trim();
		int length = 0;
		
		for (Person person : persons) {
			if (state.equals(person.getPersonAddress().getState())) {
				length +=1;
			}
		}
		
		Person[] result = new Person[length];	
		int j = 0;

		for (Person person : persons) {
			if (state.equals(person.getPersonAddress().getState())) {
				result[j] = person;
				j++;
			}
		}//end for

		return result;
		
	}//end searchByState
	
	public Person searchByPhone (String phone) {
		
		phone = phone.trim();
		
		Person result = new Person();
		
		for (Person person : persons ) {
			if (phone.equals(person.getPersonPhone())) {
				result = person;
			}
		}
		
		return result;
		
	}// end searchByPhone
	
	public void printArray(Person[] foundPersons) {
		
		for (Person person : foundPersons) {
			if (person.getPersonMiddleName() != null && person.getPersonMiddleName() != "") {
				System.out.println(person.getPersonFirstName() + " " + person.getPersonMiddleName() + " " + person.getPersonLastName() +
						", " + person.getPersonAddress().getStreetAddress() + ", " + person.getPersonAddress().getCity() +
						", " + person.getPersonAddress().getState() + ", " + person.getPersonAddress().getZip() + 
						", " + person.getPersonPhone());
			} else {
				System.out.println(person.getPersonFirstName() + " " + person.getPersonLastName() +
						", " + person.getPersonAddress().getStreetAddress() + ", " + person.getPersonAddress().getCity() +
						", " + person.getPersonAddress().getState() + ", " + person.getPersonAddress().getZip() + 
						", " + person.getPersonPhone());
			}//end if else
			
		}//end for
		
	}//end printArray
	
	public void printPerson(Person person) {
		if (person.getPersonMiddleName() != null && person.getPersonMiddleName() != "") {
			System.out.println(person.getPersonFirstName() + " " + person.getPersonMiddleName() + " " + person.getPersonLastName() +
					", " + person.getPersonAddress().getStreetAddress() + ", " + person.getPersonAddress().getCity() +
					", " + person.getPersonAddress().getState() + ", " + person.getPersonAddress().getZip() + 
					", " + person.getPersonPhone());
		} else {
			System.out.println(person.getPersonFirstName() + " " + person.getPersonLastName() +
					", " + person.getPersonAddress().getStreetAddress() + ", " + person.getPersonAddress().getCity() +
					", " + person.getPersonAddress().getState() + ", " + person.getPersonAddress().getZip() + 
					", " + person.getPersonPhone());
		}//end if else
		
	}//end for
	
	
	//GETTERS & SETTERS
	public Person[] getPersons() {
		return persons;
	}
	public void setPersons(Person[] persons) {
		this.persons = persons;
	}
                     
}//end class
