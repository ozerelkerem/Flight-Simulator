import java.util.ArrayList;

public class City
{
	private String name;
	private ArrayList<Airport> airports;
	private ArrayList<Flight> flights;
	private MapPoint mp;
	
	public City(String name, ArrayList<Airport> airports, ArrayList<Flight> flights, MapPoint mp)
	{
		this.name = name;
		this.airports = airports;
		this.flights = flights;
		this.mp = mp;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public ArrayList<Airport> getAirports()
	{
		return airports;
	}

	public void setAirports(ArrayList<Airport> airports)
	{
		this.airports = airports;
	}

	public MapPoint getMp()
	{
		return mp;
	}

	public void setMp(MapPoint mp)
	{
		this.mp = mp;
	}
	
	
	public ArrayList<Flight> getFlights()
	{
		return flights;
	}

	public void setFlights(ArrayList<Flight> flights)
	{
		this.flights = flights;
	}
	
	public boolean addAirport(Airport a)
	{
		for(Airport ap : airports)
		{
			if(a.getName().equals(ap.getName()))
				return false;
		}
		airports.add(a);
		return true;
	}
	
	public boolean deleteAirport(Airport a)
	{
		for(Flight f : flights)
		{
			if(f.getArrAirport().equals(a) || f.getDepAirport().equals(a))
			{
				return false;
			}
		}
		airports.remove(a);
		return true;
	}
	
	
	
	
}
