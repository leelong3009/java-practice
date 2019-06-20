package com.sample.common;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		DecimalFormat formatter = new DecimalFormat("#,##0.00");
		System.out.println(formatter.format(new BigDecimal(13434939.333)));
	}

}
