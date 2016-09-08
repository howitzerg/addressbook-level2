package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Unit {
	
	public static final String UNIT_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
	public static final String UNIT_VALIDATION_REGEX = ".+";
	
	private String unit;
	
    public Unit(String unit) throws IllegalValueException {
        if (!isValidUnit(unit)) {
            throw new IllegalValueException(UNIT_ADDRESS_CONSTRAINTS);
        }
        this.unit = unit;
    }

	public static boolean isValidUnit(String test) {
		return test.matches(UNIT_VALIDATION_REGEX);
	}

	public String getUnit() {
		return unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
		return;
	}
}