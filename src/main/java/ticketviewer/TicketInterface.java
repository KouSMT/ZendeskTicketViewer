package ticketviewer;

/**
* TickerInterface is used as the view. Mostly displays messages/errors 
* and prints tickets.
* TODO: Rename class to something more appropriate
*/
public class TicketInterface 
{
	public TicketInterface() {}
	
	public void displayLoading()
	{
		System.out.println("\nLoading tickets...");
	}
	
	public void displayLoadError()
	{
		System.out.println("\nError: Problem in loading tickets");
	}
	
	public void displayWelcome()
	{
		System.out.println("Welcome to Dennis' Ticket Viewer");
	}

	public void displayMenu()
    	{
        	System.out.println("\nPlease insert a number from the following choices below and press Enter: ");
        	System.out.println("\n[1] - View all tickets");
        	System.out.println("\n[2] - View single ticket");
        	System.out.println("\n[3] - Quit");
        	System.out.print("Input:\n");
    	}
	
	public void displayTicketPageNumber(int currentPage, int maxPage)
    	{
       		System.out.println("\nYou are on page " + currentPage + " of " + maxPage);
        	promptPageNumber();
	}
	
	public void displayTicketIDRequest()
    	{
        	System.out.println("\nPlease input a ticket number: \n");
    	}
	
	public void displayInputError()
    	{
        	System.out.println("\nError: Your input was invalid.");
    	}
	
	public void displayConnectError()
    	{
        	System.out.println("\nError: There is a connection issue or the API is currently unavailable");
    	}
	
	public void displayShutdownMessage()
    	{
        	System.out.println("\nGoodbye");
    	}
	
	public void printTicket(Ticket ticket, int index)
	{
		System.out.println("\n[" + index + "] - Ticket " + Long.toString(ticket.getId()) + 
				" with subject '" + ticket.getSubject() +
				"' opened by " + ticket.getSubmitter_id());
	}
	
	public void printTicket(Ticket ticket, String ticketDescription, int index)
	{
		System.out.println("\n[" + index + "] - Ticket " + Long.toString(ticket.getId()) + 
				" with subject '" + ticket.getSubject() +
				"' opened by " + ticket.getSubmitter_id());
		System.out.println("Content:\n" + ticketDescription);
	}

	public void displayNoTicketFoundError() 
	{
		System.out.println("\nError: No ticket found with that index");	
	}
	
	public void promptPageNumber() {
		System.out.println("\nPlease enter the page number you would like to view and press Enter (enter 0 to return to main menu):\n");
	}
}
