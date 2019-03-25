

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class GameIcon extends ImageIcon implements Icon {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String key;
	private boolean hasPlayed;

	public GameIcon(String fileName) {
		
		super(fileName);
		this.key = fileName;
		this.hasPlayed = false;
		
	}

	public GameIcon(URL resource) {
		super(resource);
		this.hasPlayed = false;
	}

	public boolean isHasPlayed() {
		return hasPlayed;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setHasPlayed(boolean hasPlayed) {
		this.hasPlayed = hasPlayed;
	}
	
	public boolean getHasPlayed() {
		return hasPlayed;
	}

	

}
