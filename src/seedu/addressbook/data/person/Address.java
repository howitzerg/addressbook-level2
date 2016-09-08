package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book. Guarantees: immutable; is
 * valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

	public static final String EXAMPLE = "123, some street";
	public static final String MESSAGE_ADDRESS_CONSTRAINTS =
		"Person addresses must contain _BLOCK_, _STREET_, _UNIT_ and _POSTALCODE_ separated by \", \"";
	public static final String ADDRESS_VALIDATION_REGEX = ".+(, ).+(, ).+(, ).+";

	static final int BLOCK = 0;
	static final int STREET = 1;
	static final int UNIT = 2;
	static final int POSTALCODE = 3;

	private boolean isPrivate;
	private Block block;
	private Street street;
	private Unit unit;
	private PostalCode postalCode;

	/**
	 * Validates given address.
	 *
	 * @throws IllegalValueException
	 *             if given address string is invalid.
	 */

	public Address() {}
	
	public Address(String address, boolean isPrivate) throws IllegalValueException {
		this.isPrivate = isPrivate;
		if (!isValidAddress(address)) {
			throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
		}
		String[] parts = address.split(", ");
		if (Block.isValidBlock(parts[BLOCK]) && Street.isValidStreet(parts[STREET]) &&
				Unit.isValidUnit(parts[UNIT]) && PostalCode.isValidPostalCode(parts[POSTALCODE])) {
			this.block = new Block(parts[BLOCK]);
			this.street = new Street(parts[STREET]);
			this.unit = new Unit(parts[UNIT]);
			this.postalCode = new PostalCode(parts[POSTALCODE]);
		}
	}

	/**
	 * Returns true if a given string is a valid person email.
	 */
	public static boolean isValidAddress(String test) {
		return test.matches(ADDRESS_VALIDATION_REGEX);
	}

	public String getAddress() {
		String address = block.getBlock() + ", " + street.getStreet() + ", " + unit.getUnit() + ", "
				+ postalCode.getPostalCode();
		return address;
	}

	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
				|| (other instanceof Address // instanceof handles nulls
						&& this.getAddress().equals(((Address) other).getAddress())); // state
																						// check
	}

	@Override
	public int hashCode() {
		return getAddress().hashCode();
	}

	public boolean isPrivate() {
		return isPrivate;
	}
}