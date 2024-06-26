package edu.training.web.controller.concrete;

import java.util.HashMap;
import java.util.Map;

import edu.training.web.controller.concrete.impl.DoAuth;
import edu.training.web.controller.concrete.impl.DoLogout;
import edu.training.web.controller.concrete.impl.DoRegistration;
import edu.training.web.controller.concrete.impl.GoToAddingPage;
import edu.training.web.controller.concrete.impl.GoToBusinessPage;
import edu.training.web.controller.concrete.impl.GoToGoodNewsPage;
import edu.training.web.controller.concrete.impl.GoToIndexPage;
import edu.training.web.controller.concrete.impl.GoToMainPage;
import edu.training.web.controller.concrete.impl.GoToSignInPage;
import edu.training.web.controller.concrete.impl.GoToRegistrationPage;
import edu.training.web.controller.concrete.impl.NoSuchCommand;
import edu.training.web.controller.concrete.impl.ShowTheWeather;

public class CommandProvider {

	private Map<CommandName, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put(CommandName.DO_LOGOUT, new DoLogout());
		commands.put(CommandName.DO_AUTH, new DoAuth());
		commands.put(CommandName.DO_REGISTRATION, new DoRegistration());

		commands.put(CommandName.GO_TO_INDEX_PAGE, new GoToIndexPage());
		commands.put(CommandName.GO_TO_MAIN_PAGE, new GoToMainPage());
		commands.put(CommandName.GO_TO_SIGN_IN_PAGE, new GoToSignInPage());
		commands.put(CommandName.GO_TO_REGISTRATION_PAGE, new GoToRegistrationPage());
		commands.put(CommandName.GO_TO_ADDING_PAGE, new GoToAddingPage());
		commands.put(CommandName.GO_TO_BUSINESS_PAGE, new GoToBusinessPage());
		commands.put(CommandName.GO_TO_GOODNEWS_PAGE, new GoToGoodNewsPage());
		commands.put(CommandName.SHOW_THE_WEATHER, new ShowTheWeather());

		commands.put(CommandName.NO_SUCH_COMMAND, new NoSuchCommand());
	}

	public Command takeCommand(String userCommand) {
		CommandName commandName;
		Command command;

		try {
			commandName = CommandName.valueOf(userCommand.toUpperCase());
			command = commands.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			command = commands.get(CommandName.NO_SUCH_COMMAND);
		}

		return command;
	}

}
