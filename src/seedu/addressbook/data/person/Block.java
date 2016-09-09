package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Block {
	
	public static final String BLOCK_ADDRESS_CONSTRAINTS =
						"Block must be in number format, may end with an alphabet";
	public static final String BLOCK_VALIDATION_REGEX = "\\d*\\D{0,1}";
	
	private String block;
	
    public Block(String block) throws IllegalValueException {
    	if (!isValidBlock(block)) {
    		throw new IllegalValueException(BLOCK_ADDRESS_CONSTRAINTS);
    	}
        this.block = block;
    }

	public static boolean isValidBlock(String test) {
		return test.matches(BLOCK_VALIDATION_REGEX);
	}

	public String getBlock() {
		return block;
	}
	
	public void setBlock(String block) {
		this.block = block;
		return;
	}
}