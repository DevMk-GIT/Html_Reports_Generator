package report;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;

import iconui.Screenar;


public class FileGenerator {
	String filename;
	
	
	public FileGenerator(String filename){
		this.filename=filename;
	}
	
	public void generate_new_directry(){
		try {
			String rootpath=System.getProperty("user.home")+"/ManualReports/"+filename;
			File newfile=new File(rootpath);
			File screenShot=new File(rootpath+"/Screenshots");
			File screenShotHtml=new File(rootpath+"/ScreenshotHtml");
			newfile.mkdir();
			screenShot.mkdir();
			screenShotHtml.mkdir();
			File _file=new File(newfile,filename+".html");
			
			FileOutputStream outputStream=new FileOutputStream(_file);
			BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream));
			bufferedWriter.write("<html>\n");
			bufferedWriter.write("<head>\n");
			bufferedWriter.write("</head>\n");
			bufferedWriter.write("<body bgcolor='#AAF1D5'>\n");
			bufferedWriter.write("<table cellpadding='8' cellspacing='3' width='90%' align='center' border='1'>\n");
			bufferedWriter.write("<tr bgcolor='#30D3FF' align='center'><td><h2 color='red'>Report Name: "+filename+"</h2></td></tr>\n");
			bufferedWriter.write("<tr bgcolor='#30D3FF' align='center'><td><h2>Date Created: "+Calendar.getInstance().getTime()+"</h2></td></tr>\n");
			bufferedWriter.write("</table>\n");
			bufferedWriter.write("<tr><td colspan='2'></tr>\n");
			bufferedWriter.write("<table border='1' align='center' width='90%' cellpadding='5' cellspacing='2'>\n");
			bufferedWriter.write("<tr bgcolor='#30D3FF'><td align='center'><h3>Step No.</h3></td><td align='center'><h3>Step Name</h3></td><td align='center'><h3>Description</h3></td><td align='center'><h3>Screenshots</h3></td></tr>\n");
			bufferedWriter.write("</table>\n");
			bufferedWriter.write("</body>\n");
			bufferedWriter.write("</html>");
			bufferedWriter.close();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void updateDirectry(){
		
		try {
			String rootpath=System.getProperty("user.home")+"/ManualReports/"+filename;
			File screenShot=new File(rootpath+"/ScreenshotHtml");
			File screenshotHtml=new File(screenShot,screenshotNumber()+".html");
			FileOutputStream stream=new FileOutputStream(screenshotHtml);
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(stream));
			writer.write("<html><head></head><body><img src='"+screenshotNumber()+".jpg' align='center'></body></html>");
			writer.close();
			stream.close();
			
			File file=new File(rootpath,filename+".html");
			FileOutputStream outputStream=new FileOutputStream(file,true);
			BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream));
			Path path = Paths.get(rootpath+"/"+filename+".html");
			List<String> lines = Files.readAllLines(path);
			String extraLine = "<tr bgcolor='#B5EBF8'><td>"+screenshotNumber()+"</td><td>Null</td><td>Null</td><td align='center'><a href='Screenshots/"+screenshotNumber()+".jpg'><img src='Screenshots/"+screenshotNumber()+".jpg' height='400' width='500'></td></tr>\n";  
			lines.add(lines.size()-3, extraLine);
			Files.write(path, lines);
			bufferedWriter.close();
			outputStream.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
	
	public int screenshotNumber(){
		String rootpath=System.getProperty("user.home");
		rootpath+="/ManualReports/"+filename+"/Screenshots";
		File file=new File(rootpath);
		File[] list=file.listFiles();
		return list.length;
	}
}
