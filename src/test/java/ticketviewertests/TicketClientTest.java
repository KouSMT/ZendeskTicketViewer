package ticketviewertests;

import ticketviewer.TicketClient;
import ticketviewer.Ticket;
import static org.junit.Assert.*;

import org.junit.Test;

public class TicketClientTest {

	@Test
	public void testLoadTickets() 
	{
		// TODO: Upload first and lastTicket to Zendesk
		// FIXME: Test Isolation Problem - If these tickets are deleted/modified this test will no longer pass
		Ticket firstTicket = new Ticket();
		Ticket lastTicket = new Ticket();
		int ticketDatabaseSize = 26;
		firstTicket.setDescription("Hi Dennis,\n\nEmails, chats, voicemails, and tweets are captured in Zendesk Support as tickets. Start typing above to respond and click Submit to send. To test how an email becomes a ticket, send a message to support@dennisinternship.zendesk.com.\n\nCurious about what your customers will see when you reply? Check out this video:\nhttps://demos.zendesk.com/hc/en-us/articles/202341799\n");
		firstTicket.setId(1);
		firstTicket.setStatus("open");
		firstTicket.setSubject("Sample ticket: Meet the ticket");
		firstTicket.setSubmitter_id(114277759871L);
		lastTicket.setDescription("Test pagination");
		lastTicket.setId(31);
		lastTicket.setStatus("open");
		lastTicket.setSubject("Test31");
		lastTicket.setSubmitter_id(114277759871L);
		
		TicketClient client = new TicketClient();
		client.loadTicketDatabase();
		
		assertEquals(firstTicket.getDescription(), client.getTicketDatabase().get(0).getDescription());
		assertEquals(lastTicket.getDescription(), client.getTicketDatabase().get(25).getDescription());
		assertEquals(ticketDatabaseSize, client.getTicketDatabase().size());
	}
	
	// TODO: Test for invalid authentication

}
