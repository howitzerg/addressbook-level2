package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Street {
	
	public static final String STREET_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
	public static final String STREET_VALIDATION_REGEX = ".+";
	
	private String street;
	
    public Street(String street) throws IllegalValueException {
        if (!isValidStreet(street)) {
            throw new IllegalValueException(STREET_ADDRESS_CONSTRAINTS);
        }
        this.street = street;
    }

	public static boolean isValidStreet(String test) {
		return test.matches(STREET_VALIDATION_REGEX);
	}

	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
		return;
	}
}