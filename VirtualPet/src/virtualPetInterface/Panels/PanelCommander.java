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
	
	WindowListener exitListener = new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			printt("Exit Event found");
			turnOff(); // this method is in initialiser
		}
	};
	
	//This is for responsive Layout
	private Rectangle recFrame;
	static protected int frameSizeX;
	protected int tmpFrameSizeX;
	static protected int frameSizeY;
	protected int tmpFrameSizeY;
	//end of responsive Layout options
	
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
						//nothing needs to happen as there is no change in size
					} else {
						
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
		printt( "initialising the frame" );
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(300, 300);
		this.frame.addWindowListener(exitListener);//this adds the exit Listener
		this.frame.setLayout(null);
		this.frame.setResizable(true);
	}
	
	public void buildPanels() {
		
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
		buildStartPanel.start();
		buildNewPetPanel.start();
		buildExistingPetPanel.start();
		buildInteractPetPanel.start();
			
		try {
			//Synchronise the ending of the thread
			buildStartPanel.join();
			buildNewPetPanel.join();
			buildExistingPetPanel.join();
			buildInteractPetPanel.join();
			
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
		tabs = new JTabbedPane();
		tabs.setSize(frameSizeX, frameSizeY + 50);
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
	
	/*
	 * This method is to get the size of buttons based on the size of the frame
	 */
	public static int getBtnSizeXLarge() {
		return (int) Math.round( (0.333)*frameSizeX - (0.05)*frameSizeX );
	}
	public int getBtnSizeYLarge() {
		return (int) Math.round( (0.167) * frameSizeY );
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
		tabs.setSelectedIndex(3);
	}
}
