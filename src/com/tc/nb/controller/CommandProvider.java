package com.tc.nb.controller;

import java.util.HashMap;
import java.util.Map;

import com.tc.nb.controller.command.Command;
import com.tc.nb.controller.command.CommandName;
import com.tc.nb.controller.command.impl.Save;
import com.tc.nb.controller.command.impl.SearchByContent;
import com.tc.nb.controller.command.impl.SearchByDate;
import com.tc.nb.controller.command.impl.SearchByDateRange;
import com.tc.nb.controller.command.impl.SearchByTitle;
import com.tc.nb.controller.command.impl.View;
import com.tc.nb.controller.command.impl.WrongRequest;

final class CommandProvider {

	private final Map<CommandName, Command> repository = new HashMap();

	CommandProvider() {
		repository.put(CommandName.SAVE, new Save());
		repository.put(CommandName.SEARCH_BY_TITLE, new SearchByTitle());
		repository.put(CommandName.SEARCH_BY_DATE, new SearchByDate());
		repository.put(CommandName.SEARCH_BY_DATE_RANGE, new SearchByDateRange());
		repository.put(CommandName.SEARCH_BY_CONTENT, new SearchByContent());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
		repository.put(CommandName.VIEW, new View());
	}

	Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;

		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch (IllegalArgumentException e) {
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}

}
