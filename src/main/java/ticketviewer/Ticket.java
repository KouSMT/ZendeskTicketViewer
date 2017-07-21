package ticketviewer;

/**
* The main Ticket POJO. Properties are based off of ticket fields.
* Other fields were not added as these were the bare minimum needed to be displayed
* TODO add more fields for the other ticket fields, such as URL
*/
public class Ticket 
{
	private long id;
	private String subject;
	private String description;
	private String status;
	private long submitter_id;
    
	public Ticket() {}
    
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
    	}
	
    	public String getSubject() {
        	return subject;
    	}
	
    	public void setSubject(String subject) {
        	this.subject = subject;
    	}
	
 	public String getDescription() {
		return description;
    	}
	
	public void setDescription(String description) {
       	 	this.description = description;
    	}
	
    	public String getStatus() {
        	return status;
    	}
	
    	public void setStatus(String status) {
        	this.status = status;
    	}
	
    	public long getSubmitter_id() {
        	return submitter_id;
    	}
	
    	public void setSubmitter_id(long submitter_id) {
        	this.submitter_id = submitter_id;
    	}
}
