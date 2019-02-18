package model.vo;

/**
 * Representation of a Trip object
 */
public class VOMovingViolations {

	
	private int objectId;
	
	private String location;
	
	private String ticketIssueDate;
	
	private int totalPaid;
	
	private String accidentIndicator;
	
	private String violationDesc;
	
	private String violationCode;
	
	
	
	public VOMovingViolations(int pId, String pLocation, String pTicketIssueDate, int pTotalPaid, String pAccidentIndicator, String pViolationDescription,String pViolationCode)
	{
		objectId = pId;
		location = pLocation;
		ticketIssueDate = pTicketIssueDate;
		totalPaid = pTotalPaid;
		accidentIndicator = pAccidentIndicator;
		violationDesc = pViolationDescription;
		violationCode = pViolationCode;

	}
	/**
	 * @return id - Identificador único de la infracción
	 */
	public int objectId()
	{
		// TODO Auto-generated method stub
		return objectId;
	}	
	
	
	/**
	 * @return location - Dirección en formato de texto.
	 */
	public String getLocation() 
	{
		// TODO Auto-generated method stub
		return location;
	}

	/**
	 * @return date - Fecha cuando se puso la infracción .
	 */
	public String getTicketIssueDate() 
	{
		// TODO Auto-generated method stub
		return ticketIssueDate;
	}
	
	/**
	 * @return totalPaid - Cuanto dinero efectivamente pagó el que recibió la infracción en USD.
	 */
	public int getTotalPaid() 
	{
		// TODO Auto-generated method stub
		return totalPaid;
	}
	
	/**
	 * @return accidentIndicator - Si hubo un accidente o no.
	 */
	public String  getAccidentIndicator() {
		// TODO Auto-generated method stub
		return accidentIndicator;
	}
		
	/**
	 * @return description - Descripción textual de la infracción.
	 */
	public String  getViolationDescription() 
	{
		// TODO Auto-generated method stub
		return violationDesc;
	}
	
	/**
	 * @return description - Descripción textual de la infracción.
	 */
	public String  getViolationCode() 
	{
		// TODO Auto-generated method stub
		return violationCode;
	}
}
