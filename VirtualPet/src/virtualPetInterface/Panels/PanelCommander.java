package virtualPetInterface.Panels;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utilities.BuildUtilitiesVPV1;

/**
 * This Class is aimed to be the way that all the panels are switched
 * don't know if i am going to use this yet - depends on efficiency
 * @author James Martland 24233781
 *
 */
public class PanelCommander extends BuildUtilitiesVPV1 {
	JFrame frame = new JFrame("VirtualPet");
	static JTabbedPane tabs; // making this static is what enables the thread action listeners to work
	static boolean newPetAdded = false;
	WindowListener exitListener = new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			printt("Exit Event found");
			turnOff(); // this method is in initialiser
		}
	};
	
	
	//List of all panels
	StartPanel SP;
	JPanel startPanel = new JPanel( null );
	NewPetPanel NPP;
	JPanel newPetPanel = new JPanel( null );
	ExistingPetPanel EPP;
	JPanel existingPetPanel = new JPanel( null );
	InteractPetPanel IPP;
	JPanel interactPetPanel = new JPanel( null );
	
	
	/*
	 * This Constructor is just to test
	 */
	public PanelCommander() {
		//frameSizeCalculator();
	}
	
	public void frameReziser() {
		Thread frameResizerThread = new Thread ( new Runnable() {
			@Override
			public void run() {
				while ( true ) {
					recFrame = frame.getBounds();
					tmpFrameSizeX = recFrame.width;
					tmpFrameSizeY = recFrame.height;
					if ( tmpFrameSizeX == frameSizeX  && tmpFrameSizeY == frameSizeY) {
						//Do Nothing - go to delay
					} else {
						//this is if there is a change in size
						frameSizeX = tmpFrameSizeX;
						frameSizeY = tmpFrameSizeY;
						
						//set up object with two params - frame size - re-add to the tabs
						//reInit all of the frame sizes
						
					}
					//check if  currentSize is different to lastSize
					
					//resize all panels if so
					
					
					//delay
					delay(5000);
				} // EndWhile
				
			}
		}
		);
		frameResizerThread.start();
	}
	
	public void frameSizeCalculator() {
		printt( "Set Frame Sizes" );
		recFrame = frame.getBounds();
		frameSizeX = recFrame.width;
		frameSizeY = recFrame.height;
		printt( "Width: " + frameSizeX + "\n\tHeight: " + frameSizeY);
	}
	
	/**
	 * This method is for creating the threads to set up the panels
	 */
	public void startPanelCommander() {
		setTag("PNLCOMM");
		
		initFrame();
		frameSizeCalculator();
		buildPanels();
	}
	
	/**
	 * This method is to set up the frame
	 * ONLY CALLED ONCE
	 */
	public void initFrame() {
		printt( "Initialising the frame" );
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(400, 400);
		this.frame.setMinimumSize( new Dimension(350, 400) );
		this.frame.addWindowListener(exitListener);//this adds the exit Listener
		this.frame.setLayout(null);
		this.frame.setResizable(true);
		printt( "Frame Init Complete" );
	}
	
	/**
	 * This method organises the threads and this is what will be called to reinitialise the system when the layout changes
	 */
	public void buildPanels() {
		
		printt( "Starting Thread Initialisation" );
		
		//NB need to check if responsive Layout works without making new Object ( resource Intensive )
		//Thread Initialisation
		SP = new StartPanel();
		Thread buildStartPanel = new Thread( SP );
		NPP = new NewPetPanel();
		Thread buildNewPetPanel = new Thread( NPP );
		EPP = new ExistingPetPanel();
		Thread buildExistingPetPanel = new Thread ( EPP );
		IPP = new InteractPetPanel();
		Thread buildInteractPetPanel = new Thread ( IPP );
		
		//Thread Run
		printt( "Starting Threads" );
		buildStartPanel.start();
		buildNewPetPanel.start();
		buildExistingPetPanel.start();
		buildInteractPetPanel.start();
			
		try {
			//Synchronise the ending of the thread
			printt( "Syncing Threads" );
			buildStartPanel.join();
			buildNewPetPanel.join();
			buildExistingPetPanel.join();
			buildInteractPetPanel.join();
			
			printt( "Returning panels" );
			this.startPanel = SP.returnPanel();
			this.newPetPanel = NPP.returnPanel();
			this.existingPetPanel = EPP.returnPanel();
			this.interactPetPanel = IPP.returnPanel(); // this needs to be updated on the fly
			initTabs();
				
		} catch ( InterruptedException e) {
			errPrint("An Error Occurred while Making GUI");
			e.printStackTrace();
		}
	}
	
	/**
	 * This initialises the tabs for the tabbed pane
	 */
	public void initTabs() {
		printt( "Initialising Tabs" );
		tabs = new JTabbedPane(); // need to think if this is going to be needed here
		tabs.setSize(frameSizeX - 16, frameSizeY + 10 );
		tabs.setLocation(0, -50);
		
		printt( "adding Start tab" );
		tabs.addTab( "start", startPanel );
		tabs.setEnabledAt(0, false);
		
		printt( "adding Newpet tab" );
		tabs.addTab( "newPet", newPetPanel );
		tabs.setEnabledAt(1, false);
		
		printt( "adding Existingpet tab" );
		tabs.addTab( "ExistingPet", existingPetPanel );
		tabs.setEnabledAt(2, false);
		
		printt( "adding InteractPet tab" );
		tabs.addTab( "InteractPet", interactPetPanel );
		tabs.setEnabledAt(3, false);
		
		tabs.setSelectedIndex(0);
		
		//moved this - the frame would show before it was ready to
		this.frame.add(tabs);
		this.frame.setVisible(true);

	}
	
	
	/**
	 * This makes the user see the New pet Panel
	 */
	public void toNewPetPanel() {
		printt( "running changing panel method" );
		tabs.setSelectedIndex(1);
	}
	
	/**
	 * This makes the user see the Existing pet Panel
	 */
	public void toExistingnPetPanel() {
		printt( "running changing panel method" );
		tabs.setSelectedIndex(2);
	}
	
	/**
	 * This makes the user see the start panel
	 */
	public void toStartPanel() {
		tabs.setSelectedIndex(0);
	}
	
	/**
	 * This makes the user see the interact panel
	 */
	public void toInteractPanel() {
		printt("toInteractPanel");
		
		IPP = new InteractPetPanel();
		Thread buildAgain = new Thread( IPP );
		buildAgain.start();
		
		try { 
			buildAgain.join(); 
			printt( "Threads Finished " );
			tabs.removeTabAt(3);
			tabs.addTab("Interact",  IPP.returnPanel() );
			
		} catch( InterruptedException e ) { 
			errPrint( "An Error Occurred: " + e ); 
		}
		
		tabs.setSelectedIndex(3);
	}
}
