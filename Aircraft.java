
public class Aircraft
{
	private String name;
	private AirlinesCompany comp;
	
	public Aircraft(String name, AirlinesCompany comp)
	{
		this.name = name;
		this.comp = comp;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public AirlinesCompany getComp()
	{
		return comp;
	}

	public void setComp(AirlinesCompany comp)
	{
		this.comp = comp;
	}
	
	
	
	
}