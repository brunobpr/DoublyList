package Model;

public class Validator {
  
	protected boolean isNotString(String input) {
		if(input.matches("[a-z]+") || input.matches("[A-Z]+") || input.matches("[a-zA-Z]+")) {
			return false;
		}
		return true;
	}
	
	protected boolean isNotValidPass(String input) {
		if(input.matches("[a-z]+") || input.matches("[A-Z]+") || input.matches("[a-zA-Z]+") || input.matches("[0-9]+")) {
			return false;
		}
		return true;
	}
	
}
