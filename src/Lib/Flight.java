package Lib;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class Flight implements Serializable,Runnable
{

	private static final long serialVersionUID = 1L;
	private String ID;
	private Airport depAirport;
	private Airport arrAirport;
	private Date depDate;
	private Date arrDate;
	private Date realdepDate;
	private Aircraft aircraft;
	private FlightStatus status;
	private Center CNTR;
	
	private MapPoint maploc=new MapPoint(0, 0);
	
	public Flight(Center c,String iD, Airport depAirport, Airport arrAirport, Date depDate, Aircraft aircraft,
			FlightStatus status) {
		CNTR = c;
		ID = iD;
		this.depAirport = depAirport;
		this.arrAirport = arrAirport;
		this.depDate = depDate;
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

	public void setDepDate(Date date)
	{
		this.depDate = date;
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

	
	public Date getRealdepDate() {
		return realdepDate;
	}

	public void setRealdepDate(Date realdepDate) {
		this.realdepDate = realdepDate;
	}

	public double getRotation()
	{
		float x1,x2,y1,y2;
		x1=getArrAirport().getCity().getMp().getX();
		x2=getDepAirport().getCity().getMp().getX();
		y1=getArrAirport().getCity().getMp().getY();
		y2=getDepAirport().getCity().getMp().getY();
		
		return Helper.getAngle(getDepAirport().getCity().getMp(),getArrAirport().getCity().getMp());
	}
	
	public MapPoint getLocation()
	{
		return maploc;
	}
	
	public static Flight getFlightFromID(ArrayList<Flight> l,String id)
	{
		for(Flight f : l)
			if(f.getID().equals(id))
				return f;
		return null;
	}
	
	public Vector<String> toVector()
    {
        Vector<String> v = new Vector<>();
        v.add(getID());
        v.add(getDepAirport().getCity().toString());
        v.add(getDepAirport().toString());
        v.add(getArrAirport().getCity().toString());
        v.add(getArrAirport().toString());
        v.add(depDate.toString());
        v.add(realdepDate == null ? "" : realdepDate.toString());
        v.add(arrDate == null ? "" :arrDate.toString());
        v.add(status.toString());
        return v;
    }

	@Override
	public void run() {
		while(getStatus()==FlightStatus.OnAir)
		{
			MapPoint mp1= new MapPoint(0, 0);
			double speed = (double) ((CNTR.getTimeNOW().getTime() - realdepDate.getTime()))/10000000;
			double distance = Helper.distance2D(getArrAirport().getCity().getMp(), getDepAirport().getCity().getMp());
			mp1.setX((float) (distance * speed * Math.cos(getRotation())));
			mp1.setY((float) (distance * speed * Math.sin(getRotation())));
			maploc = getDepAirport().getCity().getMp().plus(mp1.getX(), mp1.getY());
		}
	}
	@Override
	public String toString() {
		return ID;
	}

	
	
	
}
