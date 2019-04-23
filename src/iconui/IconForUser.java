package iconui;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import report.FileGenerator;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;

public class IconForUser{	
	private JPanel contentPane;
	private FileName file;
	private JFrame frame;
	private Robot robot;
	private int x=0,y=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IconForUser icon = new IconForUser();
					icon.init1();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	private void init2(){
		frame=new JFrame();
		frame.setUndecorated(true);
        frame.setSize(1367, 770);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setOpacity(0.01f);
        frame.setCursor(Cursor.CROSSHAIR_CURSOR);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        frame.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					// TODO Auto-generated method stub
					System.out.println("Mouse Released: "+e.getX()+"|"+e.getY());
					String rootpath=System.getProperty("user.home");
					rootpath+="/ManualReports/"+file.getFileName()+"/Screenshots";
					if(e.getX()>x && e.getY()>y){
						System.out.println(file.getFileName());
						BufferedImage screenShot = robot.createScreenCapture(new Rectangle(new Point(x, y), new Dimension(e.getX()-x, e.getY()-y)));	
						ImageIO.write(screenShot, "jpg", new File(rootpath+"/"+screenshotNumber(file.getFileName())+".jpg"));
					}else{
						BufferedImage screenShot = robot.createScreenCapture(new Rectangle(new Point(e.getX(), e.getY()), new Dimension(x-e.getX(), y-e.getY())));
						ImageIO.write(screenShot, "jpg", new File(rootpath+"/"+screenshotNumber(file.getFileName())+".jpg"));
					}
					FileGenerator generator=new FileGenerator(file.getFileName());
					generator.updateDirectry();
					frame.setVisible(false);
					init1();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					robot=new Robot();
					x=e.getX(); y=e.getY();
					System.out.println("Mouse Pressed: "+x+"|"+y);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	private void init1(){
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton("Click Me");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(file==null){
					
				}else{
					frame.setVisible(false);
					init2();
				}
			}
		});
		btnNewButton.setBounds(0, 0, 100, 53);
		contentPane.add(btnNewButton);
		
		JButton btnNewFile = new JButton("Select File");
		btnNewFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				file=new FileName();
				file.initialize();
			}
		});
		btnNewFile.setBounds(0, 52, 99, 48);
		contentPane.add(btnNewFile);
		frame.setSize(100, 100);
		frame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width-100,Toolkit.getDefaultToolkit().getScreenSize().height-150);

		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
	}
	public int screenshotNumber(String filename){
		String rootpath=System.getProperty("user.home");
		rootpath+="/ManualReports/"+filename+"/Screenshots";
		File file=new File(rootpath);
		File list[]=file.listFiles();
		return list.length+1;
	}
}
