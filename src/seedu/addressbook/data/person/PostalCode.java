package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class PostalCode {
	
	public static final String POSTALCODE_ADDRESS_CONSTRAINTS = "Postal Code must contain 6 numbers";
	public static final String POSTALCODE_VALIDATION_REGEX = "\\d{6}";
	
	private String postalCode;
	
    public PostalCode(String postalCode) throws IllegalValueException {
        if (!isValidPostalCode(postalCode)) {
            throw new IllegalValueException(POSTALCODE_ADDRESS_CONSTRAINTS);
        }
        this.postalCode = postalCode;
    }

	public static boolean isValidPostalCode(String test) {
		return test.matches(POSTALCODE_VALIDATION_REGEX);
	}

	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return;
	}
}