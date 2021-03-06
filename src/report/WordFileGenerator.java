package report;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class WordFileGenerator {
	/*String rootpath;
	String filename;
	public WordFileGenerator(String rootpath, String filename){
		try {
			this.filename=filename;
			this.rootpath=rootpath;
			XWPFDocument document = new XWPFDocument(); 
			FileOutputStream out = new FileOutputStream(rootpath+"/"+filename+".docx");
			XWPFParagraph paragraph = document.createParagraph();
			XWPFRun run = paragraph.createRun();
			run.setText("Welcome to my channel. Chillyfacts.com created word document. Test test");
			document.write(out);
		    out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addPictire(){
		try {
			XWPFDocument docx = new XWPFDocument();
			XWPFParagraph par = docx.createParagraph();
			XWPFRun run = par.createRun();
			File file=new File(rootpath+"/Screenshots");
			InputStream pic = new FileInputStream(rootpath+"/Screenshots/"+screenshotNumber(filename)+".jpg");
			String id=docx.addPictureData(pic, Document.PICTURE_TYPE_JPEG);
			BufferedImage image = ImageIO.read(new File(rootpath+"/Screenshots/"+screenshotNumber(filename)+".jpg"));
			createPicture(id,
					docx.getNextPicNameNumber(Document.PICTURE_TYPE_PNG),
					image.getWidth(), image.getHeight(),docx);
			FileOutputStream out = new FileOutputStream(rootpath+"/"+filename+".docx"); 
			docx.write(out); 
			pic.close();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void createPicture(String blipId, int id, int width, int height,XWPFDocument docx) {
		final int EMU = 9525;
		width *= EMU;
		height *= EMU;
		//String blipId = getAllPictures().get(id).getPackageRelationship().getId();
		
		CTInline inline = docx.createParagraph().createRun().getCTR().addNewDrawing().addNewInline();
		
		String picXml = "" +
		        "<a:graphic xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\">" +
		        "   <a:graphicData uri=\"http://schemas.openxmlformats.org/drawingml/2006/picture\">" +
		        "      <pic:pic xmlns:pic=\"http://schemas.openxmlformats.org/drawingml/2006/picture\">" +
		        "         <pic:nvPicPr>" +
		        "            <pic:cNvPr id=\"" + id + "\" name=\"Generated\"/>" +
		        "            <pic:cNvPicPr/>" +
		        "         </pic:nvPicPr>" +
		        "         <pic:blipFill>" +
		        "            <a:blip r:embed=\"" + blipId + "\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\"/>" +
		        "            <a:stretch>" +
		        "               <a:fillRect/>" +
		        "            </a:stretch>" +
		        "         </pic:blipFill>" +
		        "         <pic:spPr>" +
		        "            <a:xfrm>" +
		        "               <a:off x=\"0\" y=\"0\"/>" +
		        "               <a:ext cx=\"" + width + "\" cy=\"" + height + "\"/>" +
		        "            </a:xfrm>" +
		        "            <a:prstGeom prst=\"rect\">" +
		        "               <a:avLst/>" +
		        "            </a:prstGeom>" +
		        "         </pic:spPr>" +
		        "      </pic:pic>" +
		        "   </a:graphicData>" +
		        "</a:graphic>";
		
		//CTGraphicalObjectData graphicData = inline.addNewGraphic().addNewGraphicData();
		XmlToken xmlToken = null;
		try {
		    xmlToken = XmlToken.Factory.parse(picXml);
		} catch(XmlException xe) {
		    xe.printStackTrace();
		}
		inline.set(xmlToken);
		//graphicData.set(xmlToken);
		
		inline.setDistT(0);
		inline.setDistB(0);
		inline.setDistL(0);
		inline.setDistR(0);
		
		CTPositiveSize2D extent = inline.addNewExtent();
		extent.setCx(width);
		extent.setCy(height);
		
		CTNonVisualDrawingProps docPr = inline.addNewDocPr();
		docPr.setId(id);
		docPr.setName("Picture " + id);
		docPr.setDescr("Generated");
    }
	public int screenshotNumber(String filename){
		String rootpath=System.getProperty("user.home");
		rootpath+="/ManualReports/"+filename+"/Screenshots";
		File file=new File(rootpath);
		File[] list=file.listFiles();
		return list.length;
	}
*/}
