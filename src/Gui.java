import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;


public class Gui extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JToggleButton sammyButton;
	private JToggleButton johnnyButton;
	private JToggleButton startButton;
	private JToggleButton quitButton;
	private ImageIcon startButtonIcon;
	private ImageIcon startSelectedButtonIcon;
	private ImageIcon quitButtonIcon;
	private ImageIcon quitSelectedButtonIcon;
	private GridBagConstraints gbc = new GridBagConstraints();
	private GridBagConstraints gbc1 = new GridBagConstraints();
	private JPanel lobbyPanel;
	private JPanel picPanel;
	private JPanel pickPanel;
	private JPanel buttonPanel;
	private JPanel gameOverPanel;
	private JPanel gameOverButtonPanel;
	private JPanel scorePanel;
	private JLabel picLabel;
	private JLabel pickOne;
	private JLabel gameOverLabel;
	private JLabel scoreLabel;
	private JLabel scoreValue;
	private GameEngine engine;
	private ImageIcon sammyButtonIcon;
	private ImageIcon sammySelectedButtonIcon;
	private ImageIcon johnnyButtonIcon;
	private ImageIcon johnnySelectedButtonIcon;
	private ImageIcon scoreIcon;
	private ImageIcon gameLogo;
	private ImageIcon gameOverIcon;
	private int count = 0;
	private int score = 0;
	String[] val;
	
	public Gui(GameEngine engine) {
		
		this.engine = engine;
		gameLogo  = new ImageIcon(getClass().getResource("gameLogo.png"));
		gameOverIcon = new ImageIcon(getClass().getResource("gameover.png"));
		scoreIcon = new ImageIcon(getClass().getResource("score.png"));
		gbc.gridx = 0;
		gbc.gridy = 500;
		gbc1.gridy = 100;	
		makeButtonIcons();
		makeLobby();
		
		
	}
	
	private void makeButtonIcons() {
		sammyButtonIcon = new ImageIcon(this.getClass().getResource("sammyKnapp.png"));
		sammySelectedButtonIcon = new ImageIcon(this.getClass().getResource("sammySelected.png"));
		johnnyButtonIcon = new ImageIcon(this.getClass().getResource("johnnyKnapp.png"));
		johnnySelectedButtonIcon = new ImageIcon(this.getClass().getResource("johnnySelected.png"));
		
		startButtonIcon = new ImageIcon(this.getClass().getResource("spela.png"));
		startSelectedButtonIcon = new ImageIcon(this.getClass().getResource("spelaHover.png"));
		quitButtonIcon = new ImageIcon(this.getClass().getResource("avsluta.png"));
		quitSelectedButtonIcon = new ImageIcon(this.getClass().getResource("avslutaHover.png"));
		
	}

	private void makeLobby() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setTitle("WHO'S WHO?!");
		setPreferredSize(new Dimension(550,650));
		setResizable(false);
		getContentPane().setBackground(Color.BLACK);
		
		JLabel gameLogoLabel = new JLabel();
		gameLogoLabel.setIcon(gameLogo);
		
		lobbyPanel = new JPanel(new FlowLayout());
		lobbyPanel.setBackground(Color.black);
		
		startButton = new JToggleButton(startButtonIcon);
		quitButton = new JToggleButton(quitButtonIcon);
		
		startButton.setBorder(new EtchedBorder());
		quitButton.setBorder(new EtchedBorder());
		
		startButton.setBounds(400,20,0,0);
		quitButton.setBounds(400, 400, 0, 0);
		
		startButton.setRolloverIcon(startSelectedButtonIcon);
		quitButton.setRolloverIcon(quitSelectedButtonIcon);
		
		startButton.addActionListener(e -> startGame());
		quitButton.addActionListener(e -> System.exit(0));
		
		startButton.setContentAreaFilled(false);
		quitButton.setContentAreaFilled(false);
		lobbyPanel.add(gameLogoLabel);
		lobbyPanel.add(startButton);
		lobbyPanel.add(quitButton);
		lobbyPanel.setOpaque(true);
		add(lobbyPanel);
		pack();
		setVisible(true);
		
	}

	private void startGame() {
		getContentPane().removeAll();
		score=0;
		
		makeFrame();
	
	}

	private void makeFrame(){
		engine.reset();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setTitle("WHO'S WHO?!");
		setPreferredSize(new Dimension(550,650));
		setLayout(new GridBagLayout());
		setResizable(false);
		getContentPane().setBackground(Color.BLACK);
		
		makePickPanel();
		
		makePic();
		
		makeButtons();
		
		add(pickPanel,gbc1);
		add(picPanel);
		add(buttonPanel,gbc);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
		pack();
		setVisible(true);
	}
	
	public void makePickPanel() {
		
		pickPanel = new JPanel();
		pickPanel.setBackground(Color.BLACK);
		pickOne = new JLabel();
		pickOne.setIcon(new ImageIcon(this.getClass().getResource("pickme.png")));
		pickOne.setBackground(Color.BLACK);
		pickPanel.add(pickOne);
	}
	
	public void makeButtons() {
		buttonPanel = new JPanel(new FlowLayout());
		
		sammyButton = new JToggleButton(sammyButtonIcon);
		johnnyButton = new JToggleButton(johnnyButtonIcon);
		
		
		johnnyButton.setContentAreaFilled(false);
		sammyButton.setContentAreaFilled(false);
		
		sammyButton.setBorder(new EtchedBorder());
		johnnyButton.setBorder(new EtchedBorder());
		
		
		sammyButton.setRolloverIcon(sammySelectedButtonIcon);
		johnnyButton.setRolloverIcon(johnnySelectedButtonIcon);
		
		sammyButton.addActionListener(e -> nextPic("samm"));
		johnnyButton.addActionListener(e -> nextPic("johnn"));
		
		buttonPanel.add(sammyButton);
		buttonPanel.add(johnnyButton);
		buttonPanel.setBackground(Color.BLACK);
	}
	
	private void nextPic(String key) {
		val = ((GameIcon)picLabel.getIcon()).getKey().split("y");
		
		GameIcon i = engine.nextPic();

		if(!engine.isGameOver()) {	
			
			picLabel.setIcon(i);
			
			sammyButton.setSelected(false);
			johnnyButton.setSelected(false);
			
			if(key.equals(val[0])) {
				score++;
			}
		}else{
			System.out.print("GameOver vid " + engine.count + " bilder");
			makeGameOver();
		
		}
	
		
	}

	private void makeGameOver() {
		
		getContentPane().removeAll();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		setTitle("WHO'S WHO?!");
		setPreferredSize(new Dimension(550,650));
		setResizable(true);
		getContentPane().setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		
		gameOverLabel = new JLabel(gameOverIcon);
		
		
		gameOverPanel = new JPanel(new FlowLayout());
		gameOverPanel.setBackground(Color.BLACK);
		
		gameOverButtonPanel = new JPanel(new FlowLayout());
		gameOverButtonPanel.setBackground(Color.BLACK);
		
		scorePanel = new JPanel(new FlowLayout());
		scorePanel.setBackground(Color.BLACK);
		
		scoreLabel = new JLabel(scoreIcon);
		scoreValue = new JLabel(engine.getScoreIcon(score));
		
		
		startButton = new JToggleButton(startButtonIcon);
		quitButton = new JToggleButton(quitButtonIcon);
		
		startButton.setBorder(new EtchedBorder());
		quitButton.setBorder(new EtchedBorder());
		
		
		startButton.setRolloverIcon(startSelectedButtonIcon);
		quitButton.setRolloverIcon(quitSelectedButtonIcon);
		
		startButton.addActionListener(e -> startGame());
		quitButton.addActionListener(e -> System.exit(0));
		
		startButton.setContentAreaFilled(false);
		quitButton.setContentAreaFilled(false);
		
		scorePanel.add(scoreLabel);
		scorePanel.add(scoreValue);
		gameOverPanel.add(gameOverLabel);
		gameOverButtonPanel.add(startButton);
		gameOverButtonPanel.add(quitButton);
		
		
		gameOverPanel.setOpaque(true);
		add(gameOverPanel, BorderLayout.NORTH);
		add(scorePanel, BorderLayout.CENTER);
		add(gameOverButtonPanel,BorderLayout.SOUTH);
		pack();
		setVisible(true);
		
		
	}

	public void makePic() {
		picPanel = new JPanel(new GridLayout(0,1));
		picPanel.setPreferredSize(new Dimension(800,500));
		picPanel.setOpaque(true);
		
		GameIcon first = engine.getPics().getPicMap().get(0);
		first.setHasPlayed(true);
		picLabel = new JLabel(first);
		
		
		
		picLabel.setPreferredSize(new Dimension(400, 200));
		pickOne.setVerticalAlignment(JLabel.CENTER);
		picLabel.setBackground(Color.BLACK);
		
		
		picPanel.add(picLabel);
	}
	

}
