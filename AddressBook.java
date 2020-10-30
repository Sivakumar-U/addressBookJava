package com.blz.addressbook;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {

	public static List<ContactPerson> person = new ArrayList<ContactPerson>();
	public static List<AddressBookNew> listBookName = new ArrayList<>();
	public static Map<Integer, String> listBooks = new HashMap<>();
	public static Map<String, String> personsByCity = new HashMap<>();
	boolean result;

	static Scanner sc = new Scanner(System.in);

	private void addContacts() {
		System.out.println("Enter contact details");
		System.out.println("Enter FirstName:");
		String firstName = sc.next();
		System.out.println("Enter LastName:");
		String lastName = sc.next();
		System.out.println("Enter Address:");
		String address = sc.next();
		System.out.println("Enter City:");
		String city = sc.next();
		System.out.println("Enter State:");
		String state = sc.next();
		System.out.println("Enter Zip:");
		int zip = sc.nextInt();
		System.out.println("Enter PhoneNumber:");
		int phoneNumber = sc.nextInt();
		System.out.println("Enter Email:");
		String email = sc.next();
		ContactPerson contact = new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber, email);
		person.add(contact);
		System.out.println("Details are uploaded successfully..");

	}

	private void printContacts() {
		if (person.isEmpty()) {
			System.out.println("There are no contacts to display");
		} else {
			for (ContactPerson ab : person) {
				System.out.println(ab);
			}
		}

	}

	private void editContacts() {
		if (person.isEmpty()) {
			System.out.println("There are no contacts to print");
		} else {
			String address, city, state;
			int zip, id, phoneNumber;
			for (ContactPerson contact : person) {
				System.out.println("ID " + person.indexOf(contact) + ":\n" + contact);
			}
			System.out.println("Enter ID of contact to edit: ");
			id = sc.nextInt();
			System.out.println(person.get(id));
			System.out.println(
					"Please select the option to edit\n1.Address\n2.City\n3.State\n4.zipCode\n5.Mobile Number");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Address: ");
				address = sc.nextLine();
				person.get(id).setAddress(address);
				break;
			case 2:
				System.out.println("Enter City: ");
				city = sc.nextLine();
				person.get(id).setCity(city);
				break;
			case 3:
				System.out.println("Enter State: ");
				state = sc.nextLine();
				person.get(id).setState(state);
				break;
			case 4:
				System.out.println("Enter Zip Code: ");
				zip = sc.nextInt();
				person.get(id).setZip(zip);
				break;
			case 5:
				System.out.println("Enter Mobile Number: ");
				phoneNumber = sc.nextInt();
				person.get(id).setPhoneNumber(phoneNumber);
				break;
			default:
				System.out.println("Error!! Choose correct Option");
				editContacts();
			}
		}
	}

	private void deleteContact() {
		if (person.isEmpty()) {
			System.out.println("There are no contacts to delete in the addressbook");
		} else {
			System.out.println("Enter firstname to delete the person");
			String firstName = sc.next();
			for (int count = 0; count < person.size(); count++) {
				if (person.get(count).getFirstName().equals(firstName)) {
					person.remove(person.get(count));
				}
			}
		}
	}

	private void addMultipleContacts() {
		System.out.println("Enter number of persons to add to Address Book: ");
		int noOfPersons = sc.nextInt();
		int count = 1;
		while (count <= noOfPersons) {
			addContacts();
			count++;
		}
	}

	private void addressBookWithUniqueName() {
		System.out.println("Enter the Address Book Id and Name : ");
		int id = sc.nextInt();
		String name = sc.next();
		AddressBookNew books = new AddressBookNew(id, name);

		if (listBookName.isEmpty()) {
			System.out.println("check");
			listBookName.add(books);
			listBooks.put(id, name);
			System.out.println("Address Book Added Successfully: ");
			for (AddressBookNew i : listBookName) {
				System.out.println(i.bookName);
			}
		} else {
			for (int i = 0; i < listBookName.size(); i++) {
				if (listBookName.get(i).getBookName().equals(name)) {
					result = listBookName.get(i).getBookName().equals(name);
					System.out.println("Address Book Already Exists");
					break;
				}
			}
			if (!result) {
				listBookName.add(books);
				listBooks.put(id, name);
				System.out.println("Address Book Added Successfully: ");
			}

		}
	}

	public void displayAddressBookRecord() {
		for (Map.Entry m : listBooks.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
	}

	public void searchPersonInACity() {
		System.out.println("Enter the city to search");
		String city = sc.next();
		person.stream().filter(element -> element.getCity().equals(city))
				.forEach(i -> System.out.println("Person Found : " + i.firstName));

	}

	public void viewPersonsByCity() {
		System.out.println("Enter the city to search: ");
		String city = sc.next();
		person.stream().filter(element -> element.getCity().equals(city))
				.forEach(i -> personsByCity.put(i.firstName, city));
		for (Map.Entry m : personsByCity.entrySet()) {
			System.out.println(m.getKey() + " : " + m.getValue());
		}
	}

	public void getPersonsCountByCity() {
		System.out.println("Enter the city to search: ");
		String city = sc.next();

		long count = person.stream().filter(element -> element.getCity().equals(city)).count();
		System.out.println("Number of Persons By City : " + count);

	}

	public static void main(String[] args) {
		int choice = 0;
		System.out.println("Hello there...Welcome to address book problem");
		AddressBook ab = new AddressBook();
		while (true) {
			System.out.println("1.Add contacts");
			System.out.println("2.Print contacts");
			System.out.println("3.Edit contacts");
			System.out.println("4.Delete contact");
			System.out.println("5.Add multiple persons");
			System.out.println("6.Add Unique Contact");
			System.out.println("7.Display Adress Book Record");
			System.out.println("8.Search Person In a City");
			System.out.println("9.View person By city");
			System.out.println("10.Get Persons Count By City");
			System.out.println("11.Exit");

			choice = sc.nextInt();
			switch (choice) {
			case 1:
				ab.addContacts();
				break;
			case 2:
				ab.printContacts();
				break;
			case 3:
				ab.editContacts();
				break;
			case 4:
				ab.deleteContact();
				break;
			case 5:
				ab.addMultipleContacts();
				break;
			case 6:
				ab.addressBookWithUniqueName();
				break;
			case 7:
				ab.displayAddressBookRecord();
				break;
			case 8:
				ab.searchPersonInACity();
				break;
			case 9:
				ab.viewPersonsByCity();
				break;
			case 10:
				ab.getPersonsCountByCity();
				break;
			case 11:
				System.exit(0);
			default:
				System.out.println("Error! Choose right option from the below..");
				break;
			}
		}

	}
}
