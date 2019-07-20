package iconui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import report.FileGenerator;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FileName{
	private String filename="";
	private JTextField textField;
	private JFrame frame;
	private JButton btnChooseExistingFile;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	
	public String getFileName(){
		return filename;
	}
	/**
	 * Initialize the contents of the f
	 */
	public void initialize() {
		frame=new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 110, 450, 200);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterFileName = new JLabel("Enter File Name");
		lblEnterFileName.setBounds(21, 35, 118, 25);
		frame.getContentPane().add(lblEnterFileName);
		
		

		
		textField = new JTextField();
		textField.setBounds(21, 71, 390, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnCreateFiel = new JButton("Submit");
		btnCreateFiel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filename=textField.getText().toString();
				String rootpath=System.getProperty("user.home")+"/ManualReports/"+filename;
				File file=new File(rootpath+"/"+filename+".html");
				try {
					if(file.exists()){
						
					}else{
						FileGenerator generator=new FileGenerator(filename);
						generator.generate_new_directry();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				frame.setVisible(false);	
			}
		});
		btnCreateFiel.setBounds(21, 107, 118, 23);
		frame.getContentPane().add(btnCreateFiel);
		
		btnChooseExistingFile = new JButton("Browse");
		btnChooseExistingFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				String rootpath=System.getProperty("user.home");
				rootpath+="/ManualReports";
		        chooser.setCurrentDirectory(new File(rootpath));
		        int result = chooser.showOpenDialog(null);
		        if(JFileChooser.APPROVE_OPTION == result){
		        	String temp=chooser.getSelectedFile().getName().toString();
		        	System.out.println(temp);
		        	filename=temp.substring(0, temp.indexOf('.'));
		        	textField.setText(filename);
		        }
			}
		});
		btnChooseExistingFile.setBounds(21+119, 107, 118, 23);
		frame.getContentPane().add(btnChooseExistingFile);
		
		/*lblNewLabel = new JLabel("Enter File Name");
		lblNewLabel.setBounds(21, 178, 118, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 141, 434, 2);
		frame.getContentPane().add(separator);
		
		textField_1 = new JTextField();
		textField_1.setBounds(21, 207, 296, 25);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Create New Report");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(149, 11, 134, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Select Existing Report");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(149, 143, 156, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnSubmit.setBounds(21, 243, 118, 23);
		frame.getContentPane().add(btnSubmit);*/
	}
}
