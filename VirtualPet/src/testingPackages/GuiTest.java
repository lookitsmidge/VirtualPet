package testingPackages;

import javax.swing.*;
import utilities.BuildUtilitiesVPV1;
public class GuiTest extends BuildUtilitiesVPV1{
	
	JFrame frame = new JFrame("Test");
	JTabbedPane tabs = new JTabbedPane();
	
	//JLabel lblHello = new JLabel("Hello");
	
	JPanel panel1 = new JPanel();
	JLabel lbl1 = new JLabel();
	JPanel panel2 = new JPanel();
	JLabel lbl2 = new JLabel();
	
	public static void main (String[] args) {
		GuiTest GT = new GuiTest();
		GT.start();
	}
	public void start() {
		print("starting");
		frame.setTitle("Test");
		frame.setSize(300, 300);
		frame.setLocation(200, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//frame.add(lblHello);
		//panel1
		panel1.setLayout(null);
		
		addLabel(lbl1, panel1, 0, 0, "Label 1", 100, 50);
		//panel2
		panel2.setLayout(null);
		addLabel(lbl2, panel2, 0, 0, "Label 2", 100, 50);
		tabs.setSize(300, 300);
		tabs.addTab("Tab1", panel1);
		tabs.addTab("Tab2", panel2);
//		
		frame.add(tabs);
		tabs.setSelectedIndex(0);
		print("Finished");
	}
	public void print(String text) {
		System.out.println(text);
	}
	
}
