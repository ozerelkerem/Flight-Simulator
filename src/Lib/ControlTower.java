package Lib;

import java.io.Serializable;

public class ControlTower implements Serializable,Runnable
{

	private static final long serialVersionUID = 1L;

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
		return (landingTimer < 0) ? true : false;
	}
	
	public boolean isAvailableForTakeOff()
	{
		return (takeoffTimer< 0) ? true : false;
	}

	public void Land()
	{
		landingTimer = landingDelay;
	}
	
	public void Takeoff()
	{
		takeoffTimer = takeoffDelay;
	}

	public void run() {
		while(takeoffTimer > 0 || landingTimer > 0)
		{
			if(takeoffTimer > 0)
				takeoffTimer--;
			if(landingTimer > 0)
				landingTimer--;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			
		
	}
}
