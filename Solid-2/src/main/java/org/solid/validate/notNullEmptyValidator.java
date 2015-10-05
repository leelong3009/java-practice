package org.solid.validate;

public class notNullEmptyValidator implements IValidator{

	@Override
	public boolean validate(String input) {
		return (input != null && !input.isEmpty());
	}

}
