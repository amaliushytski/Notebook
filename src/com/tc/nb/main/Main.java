package com.tc.nb.main;

import com.tc.nb.controller.Controller;
import com.tc.nb.controller.NoteResponse;

public class Main {

	public static void main(String[] args) throws Exception {
	
		Controller controller = new Controller();
		
		NoteResponse response = controller.executeTask("save New title from controller; Content from controller");
		controller.executeTask("VIEW " + response.getResponse());

		response = controller.executeTask("SEARCH_BY_TITLE text");
		controller.executeTask("VIEW " + response.getResponse());

		response = controller.executeTask("SEARCH_BY_CONTENT controller");
		controller.executeTask("VIEW " + response.getResponse());

		response = controller.executeTask("SEARCH_BY_DATE 2022-12-09T15:20:34.209");
		controller.executeTask("VIEW " + response.getResponse());

		response = controller.executeTask("SEARCH_BY_DATE_RANGE 2022-12-09T15:20:34.209 | 2022-12-29T15:20:34.209");
		controller.executeTask("VIEW " + response.getResponse());

	}
}
