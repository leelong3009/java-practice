package com.sample.design.pattern.chainofresponsibility;

public interface DispenseChain {
	void setNextChain(DispenseChain nextChain);
    
    void dispense(Currency cur);
}
