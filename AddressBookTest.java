package com.blz.addressbook;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class AddressBookTest {

	static AddressBook addressBook;

	@BeforeClass
	public static void createAddressBookObj() {
		addressBook = new AddressBook(null);
	}

	@Test
	public void given2EmployeeDetails_whenWrittenToFile_ShouldMatchWithEntries() {
		ContactPerson[] arrayOfEmps = {
				new ContactPerson("Siva", "Upparapalli", "mcl", "Tpt", "Ap", "517536", "8745963210", "abc@gmail.com"),
				new ContactPerson("Mahesh", "Petlur", "ela", "Tpt", "Ap", "517520", "7896541230", "xyz@gmail.com") };
		addressBook = new AddressBook(Arrays.asList(arrayOfEmps));
		AddressBook.writeAddressBookData(com.blz.addressbook.AddressBook.IOService.FILE_IO);
		long entries = AddressBookFileIOService.countEntries(com.blz.addressbook.AddressBook.IOService.FILE_IO);
		Assert.assertEquals(2, entries);
	}

}
