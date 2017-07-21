package ticketviewer;

import java.util.ArrayList;

/**
* TicketViewer handles the core business logic of displaying single and multiple tickets as well as pagination.
*/
public class TicketViewer {
	private TicketInterface ui = new TicketInterface();
	private static int PAGE_LIMIT = 25;
	
	public boolean moreThanOnePage(ArrayList<Ticket> ticketDatabase)
	{
		if (ticketDatabase.size() > PAGE_LIMIT)
			return true;
		else
			return false;
	}

	public void displayAllTickets(ArrayList<Ticket> ticketDatabase, int currentPage) 
	{
		if (ticketDatabase.size() <= PAGE_LIMIT)
		{
			for (int i = 0; i < ticketDatabase.size(); i++)
			{
				ui.printTicket(ticketDatabase.get(i), i+1);
			}
		}
		else
		{
			try
			{
				int currentIndex = (currentPage - 1) * PAGE_LIMIT;
				int indexLimit = ticketDatabase.size() - currentIndex;
				if (indexLimit > PAGE_LIMIT)
					indexLimit = currentIndex + PAGE_LIMIT;
				for (int i = currentIndex; i < currentIndex + indexLimit; i++)
				{
					ui.printTicket(ticketDatabase.get(i), i+1);
				}
			}
			catch (IndexOutOfBoundsException error)
			{
				ui.displayInputError();
			}
		}
		
	}

	public void viewTicket(ArrayList<Ticket> ticketDatabase, int index)
	{
		try
		{
			// As the user inputs a number that's not 0 based, index must be decremented
			ui.printTicket(ticketDatabase.get(index-1), ticketDatabase.get(index-1).getDescription(), index);
		}
		catch (NullPointerException error)
		{
			ui.displayNoTicketFoundError();
		}
		catch (IndexOutOfBoundsException error)
		{
			ui.displayNoTicketFoundError();
		}
	}
}
