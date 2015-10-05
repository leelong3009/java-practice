package org.solid.output;

import java.util.List;

public class ConsoleOutput implements IOutput {
	private IOutput output;
	
	public ConsoleOutput(IOutput output) {
		this.output = output;
	}
	@Override
	public void process(List<String> list) {
		if(output != null) {
			output.process(list);
		}
		System.out.println("Console output");
		System.out.println(list);
	}

}
