package Lib;

import java.io.Serializable;
import java.util.Date;

public class TimeController extends Thread
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Center CNTR;
	public boolean Work = false;
	
	public TimeController(Center cNTR) {
		super();
		CNTR = cNTR;
	}


	public Center getCNTR() {
		return CNTR;
	}


	public void setCNTR(Center cNTR) {
		CNTR = cNTR;
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

			Long secdif = ((now.getTime()-before.getTime()) /1000);
			Date newdate = TimeController.addMinutesToDate(secdif, CNTR.getTimeNOW());
			CNTR.setTimeNOW(newdate);
			//timeworks
			
			//flightworks
			for(Flight f : CNTR.getFlights())
			{
				if(f.getStatus() == FlightStatus.OnGround) // waiting for landing time
				{
					if(f.getDepDate().getTime() > CNTR.getTimeNOW().getTime()) // time to landing
					{
						f.setStatus(FlightStatus.InLineForTakeOff); // go to the line
					}
				}
				
				if(f.getStatus() == FlightStatus.InLineForTakeOff)
				{
					if(f.getDepAirport().getcTower().isAvailableForTakeOff())
					{
						f.getDepAirport().getcTower().Takeoff();
						f.setStatus(FlightStatus.OnAir);
					}
				}
				
				if(f.getStatus() == FlightStatus.OnAir)
				{
					if(f.getMp().equals(f.getArrAirport().getCity().getMp())) // plane on the city
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
			System.out.println(secdif);
		
		
		}
	}
	
	private static Date addMinutesToDate(Long minutes, Date beforeTime){
	    final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs

	    long curTimeInMs = beforeTime.getTime();
	    Date afterAddingMins = new Date(curTimeInMs + (minutes * ONE_MINUTE_IN_MILLIS));
	    return afterAddingMins;
	}
}
