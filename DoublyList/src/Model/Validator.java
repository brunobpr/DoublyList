package Model;

public class Validator {
  
	protected boolean notOnlyLetters(String input) {
		if(input.matches("[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ']+")) {
			//It is a string without number
			return false;
		}
		return true;
	}
	
	protected boolean isNotValidPass(String input) {
		if(input.matches("[a-zA-Z0-9]+")) {
			return false;
		}
		return true;
	}
	
}
