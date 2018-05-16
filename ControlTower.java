
public class ControlTower
{
	private int landingDelay;
	private int takeoffDelay;
	private int landingTimer;
	private int takeoffTimer;
	
	
	
	
	public ControlTower(int landingDelay, int takeoffDelay)
	{
		this.landingDelay = landingDelay;
		this.takeoffDelay = takeoffDelay;
		this.landingTimer = 0;
		this.takeoffTimer = 0;
	}

	public int getLandingDelay()
	{
		return landingDelay;
	}

	public void setLandingDelay(int landingDelay)
	{
		this.landingDelay = landingDelay;
	}

	public int getTakeoffDelay()
	{
		return takeoffDelay;
	}

	public void setTakeoffDelay(int takeoffDelay)
	{
		this.takeoffDelay = takeoffDelay;
	}

	public int getLandingTimer()
	{
		return landingTimer;
	}

	public void setLandingTimer(int landingTimer)
	{
		this.landingTimer = landingTimer;
	}

	public int getTakeoffTimer()
	{
		return takeoffTimer;
	}

	public void setTakeoffTimer(int takeoffTimer) {
		this.takeoffTimer = takeoffTimer;
	}

	public boolean isAvailableForLanding()
	{
		return true;
	}
	
	public boolean isAvailableForTakeOff()
	{
		return true;
	}
}
