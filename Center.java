import java.util.ArrayList;

public class Center
{
	private ArrayList<Flight> flights;
	private ArrayList<City> cities;
	
	public Center(ArrayList<Flight> flights, ArrayList<City> cities)
	{
		this.flights = flights;
		this.cities = cities;
	}

	public ArrayList<Flight> getFlights()
	{
		return flights;
	}

	public void setFlights(ArrayList<Flight> flights)
	{
		this.flights = flights;
	}

	public ArrayList<City> getCities()
	{
		return cities;
	}

	public void setCities(ArrayList<City> cities)
	{
		this.cities = cities;
	}
	
	public boolean addCity(City c)
	{
		for(City cty : cities)
		{
			if(cty.getName().equals(c.getName()))
				return false;
		}
		cities.add(c);
		return true;
	}
	
	public boolean deleteCity(City c)
	{
		for(Flight f : flights)
		{
			if(f.getArrAirport().getCity().equals(c) || f.getDepAirport().getCity().equals(c))
				return false;
		}
		cities.remove(c);
		return true;
	}
	
	public boolean addFlight(Flight f) throws FlightException
	{
		flights.add(f);
		return true;
	}
	
	public boolean addDelayToFlight(Flight f, int min)
	{
		/*todo*/
		return true;
	}
	
	public boolean cancelFlight(Flight f)
	{
		/*todo*/
		return true;
	}
	
	
	
}
