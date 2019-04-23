package report;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenShotSaver {
	public void saveScreenShot(String filename){
		try {
			String rootpath=System.getProperty("user.home");
			rootpath+="/ManualReports/"+filename+"/Screenshots";
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage capture = new Robot().createScreenCapture(screenRect);
			ImageIO.write(capture, "jpg", new File(rootpath+"/"+screenshotNumber(filename)+".jpg"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
/*mukul*/
			e.printStackTrace();
		}
	}
	public int screenshotNumber(String filename){
		String rootpath=System.getProperty("user.home");
		rootpath+="/ManualReports/"+filename+"/Screenshots";
		File file=new File(rootpath);
		File[] list=file.listFiles();
		return list.length+1;
	}
}
