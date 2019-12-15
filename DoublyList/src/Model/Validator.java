package Model;

public class Validator {

	// Validator to check all the inputs entered by the user using regex
	// If the input its NOT VALID the conditions will be TRUE
	// If the input its VALID the conditions will be false
	// NOT VALID -> TRUE
	// VALID -> FALSE

	protected boolean notOnlyLetters(String input) {
		if (input.matches("[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ']+")) {
			// It is a string without number
			return false;
		}
		return true;
	}

	protected boolean isNotValidPass(String input) {
		if (input.matches("[a-zA-Z0-9]+")) {
			return false;
		}
		return true;
	}

	protected boolean isNotValidDate(String input) {
		if (input.matches("^[0-9 /]{8}")) {
			return false;
		}
		return true;
	}

	protected boolean isNotOnlyNumbers(String input) {
		if (input.matches("[0-9]+")) {
			return false;
		}
		return true;
	}

}
