import java.util.Observable;
import java.util.Random;



public class GameEngine extends Observable{
	PictureMaker pics;
	Random rand;
	GameIcon currentIcon;
	boolean gameOver;
	int count;
	

	public GameEngine(PictureMaker p) {
		
		this.pics = p;
		rand = new Random();
	}
	
	public GameIcon initiateGame() {
		GameIcon first = getPics().getPicMap().get(rand.nextInt(getPics().getPicMap().size()));
		first.setHasPlayed(true);
		return first;
	}
	
	public GameIcon getScoreIcon(int score) {
		for(GameIcon g: pics.getScoreValues()) {
			String x = ""+score;
			if(x.equals(g.getKey())) {

				return g;
			}
		}
		return null;
	}
	
	public void nextPic() {
		
		currentIcon = pics.getPicMap().get(rand.nextInt(pics.getPicMap().size()));
		while(currentIcon.isHasPlayed()){
			currentIcon = pics.getPicMap().get(rand.nextInt(pics.getPicMap().size()));
			
		}
		currentIcon.setHasPlayed(true);
		count ++;
		setChanged();
		notifyObservers(currentIcon);
		
	}

	
	public void reset() {
		count = 0;
		for(GameIcon g : pics.getPicMap()) {
			g.setHasPlayed(false);
		}
		
	}
	
	
	
	public PictureMaker getPics() {
		return pics;
	}
	
	public boolean isGameOver() {
		if(count == 10){
			return true; 
		}
		else return false;
	}
}