import javax.swing.*;
import javax.swing.ImageIcon;
public class Button extends JButton
{
	ImageIcon image1, image2;
	boolean check;
	
	public Button(ImageIcon image,ImageIcon back)
	{
		image1 = image;
		image2 = back;
		check = true;
	}
	
	public void clickButton()
	{
		if(check)
		{
			setIcon(image1);
			check=false;
		}
	}
	
	public void returnImage()
	{
		setIcon(image2);
		check=true;
	}
}
