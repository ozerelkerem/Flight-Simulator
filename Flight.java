import java.sql.Date;

public class Flight
{
	private String ID;
	private Airport depAirport;
	private Airport arrAirport;
	private Date depDate;
	private Date arrDate;
	private Aircraft aircraft;
	private FlightStatus status;
	private MapPoint mp;
	
	public Flight(String iD, Airport depAirport, Airport arrAirport, Date depDate, Date arrDate, Aircraft aircraft,
			FlightStatus status) {
		ID = iD;
		this.depAirport = depAirport;
		this.arrAirport = arrAirport;
		this.depDate = depDate;
		this.arrDate = arrDate;
		this.aircraft = aircraft;
		this.status = status;
	}

	public String getID()
	{
		return ID;
	}

	public void setID(String iD)
	{
		ID = iD;
	}

	public Airport getDepAirport()
	{
		return depAirport;
	}

	public void setDepAirport(Airport depAirport)
	{
		this.depAirport = depAirport;
	}

	public Airport getArrAirport()
	{
		return arrAirport;
	}

	public void setArrAirport(Airport arrAirport)
	{
		this.arrAirport = arrAirport;
	}

	public Date getDepDate()
	{
		return depDate;
	}

	public void setDepDate(Date depDate)
	{
		this.depDate = depDate;
	}

	public Date getArrDate()
	{
		return arrDate;
	}

	public void setArrDate(Date arrDate)
	{
		this.arrDate = arrDate;
	}

	public Aircraft getAircraft()
	{
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft)
	{
		this.aircraft = aircraft;
	}

	public FlightStatus getStatus()
	{
		return status;
	}

	public void setStatus(FlightStatus status)
	{
		this.status = status;
	}

	public MapPoint getMp()
	{
		return mp;
	}

	public void setMp(MapPoint mp)
	{
		this.mp = mp;
	}
	
	
	
}
