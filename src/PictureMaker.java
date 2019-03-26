import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;


import javax.swing.ImageIcon;

public class PictureMaker {
	
	private ArrayList<GameIcon> pics;
	private ArrayList<GameIcon> scoreValues;
	
	
	public PictureMaker() {
		scoreValues = new ArrayList<>();
		pics = new ArrayList<>();
		makePics();
	}

	public void makePics() {
		final File f = new File(PictureMaker.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));
		
		for(File file: files) {
			
			if(file.getName().toString().startsWith("sammy") && file.getName().toString().endsWith(".jpg")) {
				
				
				GameIcon i = new GameIcon(getClass().getResource(file.getName().toString()));
				i.setKey(file.getName().toString());
				i.setHasPlayed(false);
				pics.add(i);
				
			} else if(file.getName().toString().startsWith("johnny") && file.getName().toString().endsWith(".jpg")) {
				
				
				
				GameIcon i = new GameIcon(getClass().getResource(file.getName().toString()));
				
				i.setKey(file.getName().toString());
				i.setHasPlayed(false);
				pics.add(i);
				
			} else if(file.getName().toString().startsWith("val")) {
				
				
				GameIcon i = new GameIcon(getClass().getResource(file.getName().toString()));
				
				String[] tokens = file.getName().toString().split("l");
				String[] lastTokens = tokens[1].split(".png");
				
				i.setKey(lastTokens[0]);
				
				
				
				scoreValues.add(i);
				
			}
			
			
		}
		
		
		
	}
	public ArrayList<GameIcon> getPicMap(){
		return pics;
	}
	
	public ArrayList<GameIcon> getScoreValues() {
		return scoreValues;
	}
	
	public ImageIcon getPics(int i) {
		return pics.get(i);
	}
	
	

}
