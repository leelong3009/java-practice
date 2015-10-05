package org.solid.output;

import java.util.List;

public class LoggerOuput implements IOutput {

private IOutput output;
	
	public LoggerOuput(IOutput output) {
		this.output = output;
	}
	@Override
	public void process(List<String> list) {
		if(output != null) {
			output.process(list);
		}
		System.out.println("Logger output");
		System.out.println(list);
	}

}
