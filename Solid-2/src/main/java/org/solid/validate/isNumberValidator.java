package org.solid.validate;

public class isNumberValidator implements IValidator {

	@Override
	public boolean validate(String input) {
		try{
			Integer i = Integer.valueOf(input);
			return i != null;
		}catch(NumberFormatException e){
			return false;
		}
	}

}
