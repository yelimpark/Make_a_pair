import java.util.Timer;
import java.util.TimerTask;

public class timer 
{
	private int time=0;
	private CardFrame view;
	
	
	public timer(int start, CardFrame v)
	{
		Timer g_timer = new Timer();
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
					g_timer.cancel();
				}
			}
		};
		g_timer.schedule(task, 100, 1000);
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

/*import java.awt.event.*;
public class CountController implements ActionListener {
private Frame2b view;
private Counter model;
public CountController(Counter m, Frame2b v) {
view = v; model = m;
}
public void actionPerformed(ActionEvent e) {
model.increment();
view.update();
}
}*/
