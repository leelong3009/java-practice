package org.solid.validate;

public class notNegativeZeroValidator implements IValidator {

	@Override
	public boolean validate(String input) {
		Integer i = null;
		try{
			i = Integer.valueOf(input);
		}catch(NumberFormatException e){
			return false;
		}
		if(i.compareTo(new Integer(0)) <= 0) return false;
		return true;
	}

}
