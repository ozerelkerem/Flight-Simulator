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
		while(true)
		{
			before = now;
			now = new Date();
			
			Long secdif = ((now.getTime()-before.getTime()) /1000);
			Date newdate = TimeController.addMinutesToDate(secdif, CNTR.getTimeNOW());
			CNTR.setTimeNOW(newdate);
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
