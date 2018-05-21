package Lib;
import java.io.Serializable;
import java.util.ArrayList;

public class AirlinesCompany implements Serializable
{

	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<Aircraft> aircrafts;
	
	public AirlinesCompany(String name, ArrayList<Aircraft> aircrafts)
	{
		this.name = name;
		this.aircrafts = aircrafts;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public ArrayList<Aircraft> getAircrafts()
	{
		return aircrafts;
	}

	public void setAircrafts(ArrayList<Aircraft> aircrafts)
	{
		this.aircrafts = aircrafts;
	}
	
	public void addAircraft(Aircraft a)
	{
		aircrafts.add(a);
	}
	
	
	
	
}
