package ticketviewer;

import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

/**
* InputHandler is the controller of the program, handling all the user input
*/

public class InputHandler 
{
	// Scanner is used for reading user input
	private Scanner input = new Scanner(System.in);
	// Used to exit the main loop
	private boolean quit = false;
	
	private TicketInterface ui = new TicketInterface();
	
	public InputHandler() {}
	
	public boolean isQuit() { return quit; }
	public void setQuit(boolean quit) { this.quit = quit; }
	
	private void scrollPages(TicketClient client, TicketViewer viewer)
	{
		int currentPage = 1;
		// TODO: Better organize access to PAGE_LIMIT
		int maxPage = (int) Math.ceil(client.getTicketDatabase().size() / 25.0); 
		while (currentPage != 0)
		{
			try 
			{
				if ((currentPage <= maxPage) && (currentPage > 0))
				{
					viewer.displayAllTickets(client.getTicketDatabase(), currentPage);
					ui.displayTicketPageNumber(currentPage, maxPage);
				}
				else
				{
					ui.displayInputError();
					ui.promptPageNumber();
				}
				currentPage = input.nextInt();
			}
			catch (InputMismatchException error)
			{
				input.nextLine();
				ui.displayInputError();
			}
		}
	}
	
	public void getMenuChoice(TicketClient client)
	{
		TicketViewer viewer = new TicketViewer();
		
		try
		{
			switch(input.nextInt())
			{
			case 1:
				if (!viewer.moreThanOnePage(client.getTicketDatabase()))
					viewer.displayAllTickets(client.getTicketDatabase(), 0);
				else
				{
					scrollPages(client, viewer);
				}
				break;
			case 2:
				getTicketFromID(client);
				break;
			case 3:
				setQuit(true);
				break;
			default:
				ui.displayInputError();
				break;
			}
		}
		catch (InputMismatchException error)
		{
			input.nextLine();
			ui.displayInputError();
		}
	}

	private void getTicketFromID(TicketClient processor) 
	{
		TicketViewer viewer = new TicketViewer();
		
		try
		{
			ui.displayTicketIDRequest();
			viewer.viewTicket(processor.getTicketDatabase(), input.nextInt());
		}
		catch (InputMismatchException error)
		{
			input.nextLine();
			ui.displayInputError();
		}
	}
	
}
