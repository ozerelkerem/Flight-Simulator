	
public class Airport
{
	private String name;
	private City city;
	private ControlTower cTower;
	
	public Airport(String name, City city, ControlTower cTower)
	{
		this.name = name;
		this.city = city;
		this.cTower = cTower;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public City getCity()
	{
		return city;
	}

	public void setCity(City city)
	{
		this.city = city;
	}

	public ControlTower getcTower()
	{
		return cTower;
	}

	public void setcTower(ControlTower cTower)
	{
		this.cTower = cTower;
	}
	
	
	
	
}
