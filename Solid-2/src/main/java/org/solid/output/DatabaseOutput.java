package org.solid.output;

import java.util.List;

public class DatabaseOutput implements IOutput{

private IOutput output;
	
	public DatabaseOutput(IOutput output) {
		this.output = output;
	}
	@Override
	public void process(List<String> list) {
		if(output != null) {
			output.process(list);
		}
		System.out.println("Database output");
		System.out.println(list);
	}

}
