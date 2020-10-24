package com.blz.addressbook;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

	static final int FIRST = 1;
	static final int SECOND = 2;
	static final int THIRD = 3;
	static final int FOURTH = 4;
	static final int FIFTH = 5;

	public static List<ContactPerson> person = new ArrayList<ContactPerson>();
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
			System.out.println("There are no contacts to edit");
		} else {
			String address, city, state;
			int phone, zip;
			int id;
			for (ContactPerson ab : person) {
				System.out.println("ID: # " + person.indexOf(ab) + " : " + ab);
			}
			System.out.println("Enter ID of contact to Edit : ");
			id = sc.nextInt();
			System.out.println(person.get(id));
			System.out
					.println("please select the option to edit...\n1.Address\n2.city\n3.state\n4.zip\n5.phone number");
			int choice = sc.nextInt();
			switch (choice) {
			case FIRST:
				System.out.println("Enter Address: ");
				address = sc.nextLine();
				person.get(id).setAddress(address);
				break;
			case SECOND:
				System.out.println("Enter City: ");
				city = sc.nextLine();
				person.get(id).setCity(city);
				break;
			case THIRD:
				System.out.println("Enter State: ");
				state = sc.nextLine();
				person.get(id).setState(state);
			case FOURTH:
				System.out.println("Enter Zip: ");
				zip = sc.nextInt();
				person.get(id).setZip(zip);
				break;
			case FIFTH:
				System.out.println("Enter Mobile number: ");
				phone = sc.nextInt();
				person.get(id).setPhoneNumber(phone);
				break;
			default:
				System.out.println("Please Enter Valid Option: ");
				editContacts();
			}
		}

	}

	private void deleteContact() {
		if (person.isEmpty()) {
			System.out.println("There are no contacts to delete");
		} else {
			System.out.println("Enter firstname to delete:");
			String firstName = sc.nextLine();
			for (int count = 0; count < person.size(); count++) {
				if (person.get(count).getFirstName().equals(firstName)) {
					person.remove(person.get(count));
				}
			}
		}
	}

	public static void main(String[] args) {
		int choice = 0;
		System.out.println("Hello there...Welcome to address book problem");
		AddressBook ab = new AddressBook();
		while (choice < 5) {
			System.out.println("1.Add contacts");
			System.out.println("2.Print contacts");
			System.out.println("3.Edit contacts");
			System.out.println("4.Delete contacts");
			System.out.println("5.Exit");
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
			}
		}

	}
}
