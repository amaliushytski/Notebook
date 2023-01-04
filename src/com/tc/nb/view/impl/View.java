package com.tc.nb.view.impl;

public class View {

	public void view(String response) {

		if (response == null) {
			System.out.println("No records found");
		} else {

			System.out.println(response);
			System.out.println("-------------");

		}
	}

}