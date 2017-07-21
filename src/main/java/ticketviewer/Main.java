package ticketviewer;

import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		// TODO: handle exception here
		TicketClient client = new TicketClient();
		InputHandler input = new InputHandler();
		TicketInterface ui = new TicketInterface();
	
		client.loadTicketDatabase();
		
		ui.displayWelcome();
		while (!input.isQuit())
		{
			ui.displayMenu();
			input.getMenuChoice(client);
		}
		ui.displayShutdownMessage();
	}
}
