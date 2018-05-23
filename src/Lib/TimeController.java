package Lib;


import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TimeController extends Thread
{
	/**
	 * 
	 */

	private ExecutorService pool = Executors.newCachedThreadPool();
	private ExecutorService pool2 = Executors.newCachedThreadPool();
	private Center CNTR;
	public boolean Work = false;
	
	public TimeController(Center cNTR) {
		super();
		CNTR = cNTR;
		for(City c  : CNTR.getCities())
		{
			for(Airport a : c.getAirports())
			{
				addTowerToPool(a.getcTower());
			}
		}
		for(Flight f  : CNTR.getFlights())
		{
			if(f.getStatus() == FlightStatus.OnAir)
				pool2.execute(f);
		}
	}


	public Center getCNTR() {
		return CNTR;
	}


	public void setCNTR(Center cNTR) {
		CNTR = cNTR;
	}

	public void addTowerToPool(ControlTower c)
	{
		pool.execute(c);
	}

	public void run()
	{
		Date now = new Date();
		Date before;
		while(Work)
		{
			//timeworks
			before = now;
			now = new Date();

			Long secdif = ((now.getTime()-before.getTime()) / Center.Speed);
			Date newdate = TimeController.addMinutesToDate(secdif, CNTR.getTimeNOW());
			CNTR.setTimeNOW(newdate);
			//timeworks
			
			//flightworks
			for(Flight f : CNTR.getFlights())
			{
				//System.out.println(f.getStatus() + " " + f.getID() );
				//System.out.println(f.getArrAirport().getcTower().getTakeoffTimer() + " " + f.getID() );
				if(f.getStatus() == FlightStatus.OnGround) // waiting for landing time
				{
					if(f.getDepDate().getTime() < CNTR.getTimeNOW().getTime()) // time to landing
					{
						f.setStatus(FlightStatus.InLineForTakeOff); // go to the line
					}
				}
				
				if(f.getStatus() == FlightStatus.InLineForTakeOff)
				{
					if(f.getDepAirport().getcTower().isAvailableForTakeOff())
					{

						pool2.execute(f);
						f.setRealdepDate(CNTR.getTimeNOW());
						f.getDepAirport().getcTower().Takeoff();
						f.setStatus(FlightStatus.OnAir);
					}
				}
				
				if(f.getStatus() == FlightStatus.OnAir)
				{
					if(Helper.distance2D(f.getLocation(), f.getArrAirport().getCity().getMp()) < 10) // plane on the city
					{
						f.setStatus(FlightStatus.InLineForLanding);
					}
				}
			
				if(f.getStatus() == FlightStatus.InLineForLanding)
				{
					if(f.getArrAirport().getcTower().isAvailableForLanding()) // plane on the city
					{
						f.getArrAirport().getcTower().Land();
						f.setDepDate(CNTR.getTimeNOW());
						f.setStatus(FlightStatus.Completed);
					}
				}
			}
			//flightworks
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(secdif);
		
		
		}
		System.out.println("durdum");
	}
	
	private static Date addMinutesToDate(Long minutes, Date beforeTime){
	    final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs

	    long curTimeInMs = beforeTime.getTime();
	    Date afterAddingMins = new Date(curTimeInMs + (minutes * ONE_MINUTE_IN_MILLIS));
	    return afterAddingMins;
	}
}
