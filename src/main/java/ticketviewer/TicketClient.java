package ticketviewer;

import java.util.ArrayList;
import java.util.Base64;

import javax.naming.AuthenticationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
* TicketClient authenticates and loads/save ticket data from Zendesk account.
*/
public class TicketClient 
{
	// TODO: Add methods to change subdomain, username and password during execution
	private String zendeskUrl = "https://dennisinternship.zendesk.com/api/v2/tickets.json";
	private String username = "dennis.siaril@gmail.com";
	private String password = "Dennisdede1";
	private TicketInterface ui = new TicketInterface();
	
	private ArrayList<Ticket> ticketDatabase = new ArrayList<Ticket>();
	
	public TicketClient() {}
	
	private String encryptUserDetails()
	{
		String toEncrypt = username + ":" + password;
		return Base64.getEncoder().encodeToString(toEncrypt.getBytes());
	}
	
	public void loadTicketDatabase()
	{
		try
		{	
			JSONArray rawData = getJSONTicketData();	
			for (int i = 0; i < rawData.length(); i++)
			{
				JSONObject ticketData = rawData.getJSONObject(i);
				this.ticketDatabase.add(getTicket(ticketData));
			}
		}
		catch (IOException error)
		{
			ui.displayLoadError();
		}
		catch (JSONException error)
		{
			ui.displayLoadError();
		}
	}
	
	private Ticket getTicket(JSONObject ticketData)
	{
		// TODO: Deserialize JSON ticket into ticket using GSON library
		Ticket result = new Ticket();
		result.setId(ticketData.optLong("id"));
		result.setSubject(ticketData.optString("subject"));
		result.setDescription(ticketData.optString("description"));
		result.setStatus(ticketData.optString("status"));
		result.setSubmitter_id(ticketData.optLong("submitter_id"));
		return result;
	}
	
	private JSONArray getJSONTicketData() throws JSONException, IOException
	{
		StringBuilder data = new StringBuilder();
		try
		{
			// Connect to Zendesk API using hardcoded details
			URL url = new URL(zendeskUrl);
			URLConnection uc = url.openConnection();
			String basicAuth = "Basic " + encryptUserDetails();
			uc.setRequestProperty("Authorization", basicAuth);
			
			int httpResult = ((HttpURLConnection) uc).getResponseCode();
			if (httpResult == HttpURLConnection.HTTP_OK)
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
				String input;
				
				// Get all ticket data from the servers - UNSAFE if large amount of records is retrieved
				// save up to 100. 100 max. Then request more after the 4's page turn. Otherwise have a moving queue. Remove back 25 for more 25 and vice versa
				// TODO: Investigate API pagination
				while ((input = br.readLine()) != null)
				{
					data.append(input + "\n");
				}
				br.close();
			}
			else
			{
				ui.displayConnectError();
			}
		}
		catch (MalformedURLException error)
		{
			ui.displayConnectError();
		}
		JSONObject object = new JSONObject(data.toString());
		JSONArray result = object.getJSONArray("tickets");
		return result;
	}

	public ArrayList<Ticket> getTicketDatabase() {
		return ticketDatabase;
	}
}
