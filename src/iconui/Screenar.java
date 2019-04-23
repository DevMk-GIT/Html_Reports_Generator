package iconui;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Screenar implements MouseListener,MouseWheelListener{
	private Robot robot;
	private int x=0,y=0;
	private JFrame frame;
	private String filename;
	public Screenar(String filename){
		this.filename=filename;
		this.init();
	}
	
	public void init(){
		frame=new JFrame();
		frame.setUndecorated(true);
        frame.setSize(1367, 770);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setOpacity(0.01f);
        frame.setCursor(Cursor.CROSSHAIR_CURSOR);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        frame.addMouseListener(this);
        frame.addMouseWheelListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX()+"|"+e.getY());
	}
	@Override
	public void mousePressed(MouseEvent e) {
		try {
			robot=new Robot();
			x=e.getX(); y=e.getY();
			System.out.println("Mouse Pressed: "+x+"|"+y);
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		try {
			System.out.println("Mouse Released: "+e.getX()+"|"+e.getY());
			String rootpath=System.getProperty("user.home");
			rootpath+="/ManualReports/"+filename+"/Screenshots";
			if(e.getX()>x && e.getY()>y){
				BufferedImage screenShot = robot.createScreenCapture(new Rectangle(new Point(x, y), new Dimension(e.getX()-x, e.getY()-y)));	
				ImageIO.write(screenShot, "jpg", new File(rootpath+"/"+screenshotNumber(filename)+".jpg"));
			}else{
				BufferedImage screenShot = robot.createScreenCapture(new Rectangle(new Point(e.getX(), e.getY()), new Dimension(x-e.getX(), y-e.getY())));
				ImageIO.write(screenShot, "jpg", new File(rootpath+"/"+screenshotNumber(filename)+".jpg"));
			}
			frame.setVisible(false);
		}catch (IllegalArgumentException e2) {
			System.out.println("Reactangle problem");
			// TODO: handle exception
		}
		catch(Exception e1){
			e1.printStackTrace();
		}
	}
	public int screenshotNumber(String filename){
		String rootpath=System.getProperty("user.home");
		rootpath+="/ManualReports/"+filename+"/Screenshots";
		File file=new File(rootpath);
		File list[]=file.listFiles();
		return list.length+1;
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
	}
}
