import java.util.Arrays;
import java.util.Scanner;

public class PhonebookTest {
	
	public static Scanner scanner = new Scanner(System.in);	

	public static void main(String[] args) {
		
		Directory myPhoneBook = new Directory(); 	//this creates a new Directory object (which, per the single data field in the 
													//Directory class, will hold an ARRAY of Person OBJECTS
		myPhoneBook.addNewPerson(createNewPerson("John Doe, 114 Market St, St Louis, MO, 63403, 6366435698"));
		myPhoneBook.addNewPerson(createNewPerson("John E Doe, 324 Main St, St Charles, MO,63303, 8475390126"));
		myPhoneBook.addNewPerson(createNewPerson("John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375"));
		myPhoneBook.addNewPerson(createNewPerson("Ann E Cuthbert,4509 Green Gables Way,Smalltown,PEI,00100,2015554885"));
		myPhoneBook.addNewPerson(createNewPerson("Mark J Brown,4 Antrim Drive,Fairview Heights,IL,62208,6188060404"));
		myPhoneBook.addNewPerson(createNewPerson("John G Doe,4110 Gravois St,St Louis,MO,63403,3148583333"));
		myPhoneBook.addNewPerson(createNewPerson("John X Doe,5440 Southern Dr,fairview Heights,IL,62208,6184527676"));
		
		int selection = -1; //variable to hold user's selection input
		
		while (selection != 0) { //the menu will continue to run until the user enters 0 at the menu prompt
			
			selection = printMainMenu();
			
			switch (selection) {
			case 0:
				System.out.println("Thank you for using Phonebook. Bye!");
				break;
			case 1: 			
				System.out.println("Please enter the full name, full address, and phone number for the new person: ");
				String newEntry = scanner.nextLine();
				int checkCount = myPhoneBook.persons.length;			//determine array size BEFORE adding new entry
				myPhoneBook.addNewPerson(createNewPerson(newEntry)); 	//.addNewPerson() (a Directory class method which I can call because 
																		//myPhoneBook, a Directory object created on line 8, is in scope here)
																		//adds the Person object created in createNewPerson() to myPhoneBook; 
																		//'newEntry', a String which contains all the data fields needed to 
																		//instantiate a new Person object (separated by commas), is received 
																		//from the user and is passed to addEntry() as an argument
				
				if (myPhoneBook.persons.length == checkCount + 1) {		//test array size AFTER adding entry; if +1, the add was successful
					System.out.println("Name successfully added to the phone book\n");
				}else {
					//NOTE: anything else results in an exception, which isn't dealt with now
				}
				break;
			case 2: //edit entry
				System.out.println("Enter the phone number of the person you want to edit.");
				String phoneForPersonToEdit = scanner.nextLine().toString();
				Person personToEdit = myPhoneBook.searchByPhone(phoneForPersonToEdit);
				System.out.println("Select the option for the edit you wish to make: ");
				int selectionEditMenu = -1;
				
				while (selectionEditMenu != 0) {
					selectionEditMenu = printEditMenu();
					
					switch (selectionEditMenu) {
					case 0:
						System.out.println("Returning to the Main Menu now.");
						break;
					case 1:	//edit first name
						System.out.println("Please enter the new first name: ");
						String newFirst = scanner.nextLine().trim();
						personToEdit.setPersonFirstName(newFirst);
						System.out.println("The person's record has been updated as shown below.\n");
						myPhoneBook.printPerson(personToEdit);
						break;
					case 2:	//edit middle name
						System.out.println("Please enter the new middle name: ");
						String newMiddle = scanner.nextLine().trim();
						personToEdit.setPersonMiddleName(newMiddle);
						System.out.println("The person's record has been updated as shown below.\n");
						myPhoneBook.printPerson(personToEdit);
						break;
					case 3:	//edit last name
						System.out.println("Please enter the new last name: ");
						String newLast = scanner.nextLine().trim();
						personToEdit.setPersonLastName(newLast);
						System.out.println("The person's record has been updated as shown below.\n");
						myPhoneBook.printPerson(personToEdit);
						break;
					case 4:	//edit street address
						System.out.println("Please enter the new street address: ");
						String newStreetAddress = scanner.nextLine().trim();
						personToEdit.getPersonAddress().setStreetAddress(newStreetAddress);
						System.out.println("The person's record has been updated as shown below.\n");
						myPhoneBook.printPerson(personToEdit);
						break;
					case 5:	//edit city
						System.out.println("Please enter the new city: ");
						String newcity = scanner.nextLine().trim();
						personToEdit.getPersonAddress().setCity(newcity);
						System.out.println("The person's record has been updated as shown below.\n");
						myPhoneBook.printPerson(personToEdit);
						break;
					case 6:	//edit state
						System.out.println("Please enter the new state: ");
						String newState = scanner.nextLine().trim();
						personToEdit.getPersonAddress().setState(newState); 
						System.out.println("The person's record has been updated as shown below.\n");
						myPhoneBook.printPerson(personToEdit);
						break;
					case 7:	//edit zip
						System.out.println("Please enter the new zip: ");
						String newZip = scanner.nextLine().trim();
						personToEdit.getPersonAddress().setZip(newZip);
						System.out.println("The person's record has been updated as shown below.\n");
						myPhoneBook.printPerson(personToEdit);
						break;
					case 8:	//edit phone
						System.out.println("Please enter the new phone: ");
						String newPhone = scanner.nextLine().trim();
						personToEdit.setPersonPhone(newPhone);
						System.out.println("The person's record has been updated as shown below.\n");
						myPhoneBook.printPerson(personToEdit);
						break;
					default:
						System.out.println("Please enter a valid selection number from the menu below.");
						break;
					}//end nested switch
				}//end nested while
				break;
			case 3:	//delete entry
				System.out.println("Enter the phone number of the person you want to delete: ");
				String phoneForPersonToDelete = scanner.nextLine();
				Person resultDeleteByThisPhone = myPhoneBook.searchByPhone(phoneForPersonToDelete); 
				if (resultDeleteByThisPhone == null) {
					System.out.println("Nothing deleted. There were no entries in the Phonebook with that phone number.");
				}else {
					int choice = 2;	//sentinel value;
					System.out.println("This will delete the person at phone mumber: " + phoneForPersonToDelete + 
							".\nEnter '1' to delete or '2' to cancel.");
					choice = scanner.nextInt();
					scanner.nextLine();	//consume newline character left after scanning in the int
					if (choice == 1) {
						myPhoneBook.deletePerson(resultDeleteByThisPhone);
						System.out.println("Person with phone number " + phoneForPersonToDelete + " deleted.");
					}//if choice != 1 then control returned to caller without any action
				}//end else
				break;			
			case 4:	//search by first name
				System.out.println("Enter the first name of the person(s) you want to find: ");
				String findFirstName = scanner.nextLine();
				Person[] resultSearchByFirst = myPhoneBook.searchByFirstName(findFirstName);
				if (resultSearchByFirst.length == 0) {
					System.out.println("There were no entries in the Phonebook matching that search parameter.");
				} else {
					myPhoneBook.printArray(resultSearchByFirst);
				}
				break;
			case 5:	//search by last name
				System.out.println("Enter the last name of the person(s) you want to find: ");
				String findLastName = scanner.nextLine();
				Person[] resultSearchByLast = myPhoneBook.searchByLastName(findLastName);
				if (resultSearchByLast.length == 0) {
					System.out.println("There were no entries in the Phonebook matching that search parameter.");
				} else {
					myPhoneBook.printArray(resultSearchByLast);
				}
				break;
			case 6:	//search by full name
				System.out.println("Enter the full name of the person you want to find: ");
				String findFullName = scanner.nextLine();
				Person[] resultSearchByFull = myPhoneBook.searchByFullName(findFullName);
				if (resultSearchByFull.length == 0) {
					System.out.println("There were no entries in the Phonebook matching that search parameter.");
				}else {
					myPhoneBook.printArray(resultSearchByFull);
				}
				break;
			case 7:	//search by city
				System.out.println("Enter the city of the person(s) you want to find: ");
				String cityToFind = scanner.nextLine();
				Person[] resultSearchByCity = myPhoneBook.searchByCity(cityToFind);
				if (resultSearchByCity.length == 0) {
					System.out.println("There were no entries in the Phonebook matching that search parameter.");
				}else {
					myPhoneBook.printArray(resultSearchByCity);
				}
				break;
			case 8:	//search by state
				System.out.println("Enter the state of the person(s) you want to find: ");
				String stateToFind = scanner.nextLine();
				Person[] resultSearchByState = myPhoneBook.searchByState(stateToFind);
				if (resultSearchByState.length == 0) {
					System.out.println("There were no entries in the Phonebook matching that search parameter.");
				}else {
					myPhoneBook.printArray(resultSearchByState);
				}
				break;
			case 9: //search by zip code
				System.out.println("This selection doesn't do anything yet.");
				break;
			case 10: //search by phone
				System.out.println("Enter the phone number of the person you want to find: ");
				String searchPhone = scanner.nextLine().toString();
				Person resultSearchByPhone = myPhoneBook.searchByPhone(searchPhone);
				if (resultSearchByPhone == null) {
					System.out.println("There were no entries in the Phonebook matching that search parameter.");
				} else {
					myPhoneBook.printPerson(resultSearchByPhone);	
				}
				break;
			case 11:	//sort A-Z
				System.out.println("Here is a list of all persons in the Phonebook by full name, in ascending order: \n");
				Arrays.sort(myPhoneBook.getPersons());
				myPhoneBook.printArray(myPhoneBook.getPersons());
				break;
			default:
				System.out.println("Please enter a valid selection number from the menu below.");
				break;
			
			}//end switch
		}//end while loop

	}//end main()
	
	
	//CLASS METHODS	
	
	public static int printMainMenu() {
		
		System.out.println( "\n********PHONEBOOK APPLICATION MENU********\n" + 
				"Enter 1 to add a new entry.\n" + 
				"Enter 2 to edit an entry.\n" + 
				"Enter 3 to delete an entry.\n" +
				"Enter 4 to search for a person by first name.\n" + 
				"Enter 5 to search for a person by last name.\n" + 
				"Enter 6 to search for a person by full name.\n" + 
				"Enter 7 to search for a person by city.\n" +  
				"Enter 8 to search for a person by state.\n" + 
				"Enter 9 to search for a person by zipcode.\n" +
				"Enter 10 to search for a person by phone number.\n" +
				"Enter 11 to print everyone in the phone book by first name in ascending order.\n\n" +

				"Enter 0 to exit this application.\n\n" + 
				"ENTER YOUR SELECTION HERE: ");

		int selection = scanner.nextInt();
		scanner.nextLine(); //consume the 'newline' character Scanner leaves behind after it receives an int/double, etc.
		return selection;
	}
	
	public static int printEditMenu() {
		int selection = -1;

		System.out.println( "\n********PHONEBOOK EDIT ENTRY MENU********\n" + 
				"Enter 1 to edit the first name.\n" + 
				"Enter 2 to edit the middle name.\n" + 
				"Enter 3 to edit the last name.\n" +
				"Enter 4 to edit the street address.\n" + 
				"Enter 5 to edit the city.\n" + 
				"Enter 6 to edit the state.\n" + 
				"Enter 7 to edit the zip\n" +  
				"Enter 8 to edit the phone\n\n" + 
				
				"Enter 0 to exit the Edit Menu.\n\n" + 
				"ENTER YOUR SELECTION HERE: ");//		
		selection = scanner.nextInt();
		scanner.nextLine(); //consume the 'newline' character Scanner leaves behind after it receives an int/double, etc.

		return selection;
	}
	
	private static Person createNewPerson (String newEntry) { //receives a String and returns a Person object
		
		//clean up and split the String into an array
		newEntry = newEntry.trim();					//remove leading/trailing white space in newEntry, if any
		String[] tokens = newEntry.split(",");		//split the newEntry string into tokens on the "," character
		
		//handle the name
		String[] subTokens = tokens[0].split(" ");					//split the first token (user's name) into First, Middle, Last
		String firstName = subTokens[0].trim();						//assign name at first index to firstName
		String lastName = subTokens[subTokens.length - 1].trim();	//assign name at last index to lastName
		String middleName = "";										//create variable to hold the middle name
		for (int i = 1; i < subTokens.length - 1; i++) {			//loop through the subToken array
																	//start at the second element [1] (to skip firstName)
																	//end at the next-to-last element ( < .length - 1) to skip the last name
			if (subTokens[i] != null) {
				middleName += subTokens[i] + " ";					//if its not a first or last name, it gets assigned to middleName
			}
		}
		
		middleName = middleName.trim();						//trim any whitespace (most likely trailing rather than leading)
		
		//handle the address
		String streetAddress = tokens[1].trim();			//assign elements of the tokens array to fields for an Address object
		String city = tokens[2].trim();
		String state = tokens[3].trim();
		String zip = tokens[4].trim();
		String phone = tokens[5].trim();	
		
		//instantiate a new person object (class Person) using the full constructor
		Person person = new Person(firstName, middleName, lastName, phone, new Address(streetAddress, city, state, zip));
		
		return person;	//returns the new Person object (person) to the caller on line 43
		
	}//end addEntry()

}//end Class
