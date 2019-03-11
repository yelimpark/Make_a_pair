package project;

import java.util.Timer;
import java.util.TimerTask;

public class timer 
{
	private int time=0;
	private CardFrame view;
	private Timer g_timer = new Timer();
	
	public timer(int start, CardFrame v)
	{
		time = start;
		view = v;
		TimerTask task = new TimerTask() 
		{
			public void run()
			{
				if(time!=0)
				{
					time--;
					view.update();
				}
				else
				{
					view.TimeOut();
					g_timer.cancel();
				}
			}
		};
		g_timer.schedule(task, 100, 1000);
	}
	
	public void Cancle()
	{
		g_timer.cancel();
	}
	
	public int gettime()
	{
		return time;
	}
	
	public void timeadd(int i)
	{
		time = time + i;
		view.update();
	}
}