package ticketviewertests;

import ticketviewer.TicketClient;
import ticketviewer.TicketViewer;
import ticketviewer.Ticket;
import static org.junit.Assert.*;

import org.junit.Test;

public class TicketViewerTest {

	// Correct with current ticket database (20/07/2017 10:24pm AEST)
	// FIXME: Test Isolation Problem - If the amount of tickets is changed this test may no longer pass
	// TODO: Create enough tickets such that pagination should work
	@Test
	public void testOverPageLimit() 
	{
		TicketClient client = new TicketClient();
		TicketViewer viewer = new TicketViewer();
		client.loadTicketDatabase();
		
		assertTrue(viewer.moreThanOnePage(client.getTicketDatabase()));
	}
	
	/**
	 * TODO: Mock out UI and assert that displayNoTicketFoundError() was called at least once
	@Test(expected = IndexOutOfBoundsException.class)
	public void testUnavailableSingleTicket() 
	{
		TicketClient client = new TicketClient();
		TicketViewer viewer = new TicketViewer();
		client.loadTicketDatabase();
		viewer.viewTicket(client.getTicketDatabase(), -1);
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testUnavailableTicketRange() 
	{
		TicketClient client = new TicketClient();
		TicketViewer viewer = new TicketViewer();
		client.loadTicketDatabase();
		viewer.displayAllTickets(client.getTicketDatabase(), 4);
	}
	*/

}
