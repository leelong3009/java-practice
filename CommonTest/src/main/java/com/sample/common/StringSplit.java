package com.sample.common;

public class StringSplit {

	public static void main(String[] args) {
		String url = "config-dp-OutStandingReport_search.action";
		String x = url.split("(_.)")[0];
		System.out.println(x);

	}

}
