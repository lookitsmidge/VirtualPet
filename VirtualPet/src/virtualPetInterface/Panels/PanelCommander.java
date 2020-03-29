package virtualPetInterface.Panels;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utilities.BuildUtilitiesVPV1;
/**
 * This Class is aimed to be the way that all the panels are switched - Might be removed tho
 * dont know if i am going to use this yet - depends on efficiency
 * @author 90jma
 *
 */
public class PanelCommander extends BuildUtilitiesVPV1 {
	JFrame frame = new JFrame("VirtualPet");
	static JTabbedPane tabs; // making this static is what enables the thread action listeners to work
	
	WindowListener exitListener = new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			printt("Exit Event found");
		}
	};
	
	//List of all panels
	StartPanel SP;
	JPanel startPanel = new JPanel(null);
	NewPetPanel NPP;
	JPanel newPetPanel = new JPanel(null);
	
	
	/*
	 * This constructor is to run all of the threads that are to build the panels
	 */
	public PanelCommander() {
	}
	public void startPanelCommander() {
		setTag("PNLCOMM");
		//Thread Init
		SP = new StartPanel();
		Thread buildStartPanel = new Thread( SP );
		NPP = new NewPetPanel();
		Thread buildNewPetPanel = new Thread( NPP );
		
		//Thread Run
		buildStartPanel.start();
		buildNewPetPanel.start();
		
		try {
			buildStartPanel.join();
			buildNewPetPanel.join();
			this.startPanel = SP.returnPanel();
			this.newPetPanel = NPP.returnPanel();
			initFrame();
		} catch ( InterruptedException e) {
			errPrint("An Error Occurred while Making GUI");
			e.printStackTrace();
		}
		
		
	}
	public void initFrame() {
		printt( "initialising the frame" );
//		this.frame = new JFrame("VirtualPetFrame");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(300, 300);
		this.frame.addWindowListener(exitListener);//this adds the exit Listener
		initTabs();
		this.frame.add(tabs);
		this.frame.setVisible(true);
		//this.frame.setLayout( new GridLayout(1, 1) );
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
		}
		toNewPetPanel();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
		}
		toStartPanel();
	}
	public void initTabs() {
		tabs = new JTabbedPane();
		tabs.setSize(300, 350);
		tabs.setLocation(0, -50);
		printt("adding tab");
		tabs.addTab( "start", startPanel );
		tabs.setEnabledAt(0, false);
		printt("adding tab");
		tabs.addTab( "newPet", newPetPanel );
		tabs.setEnabledAt(1, false);
		tabs.setSelectedIndex(0);
	}
	public void toNewPetPanel() {
		printt( "running changing panel method" );
		//switch Active Index
		tabs.setSelectedIndex(1);
	}
	public void toStartPanel() {
		tabs.setSelectedIndex(0);
	}
}
