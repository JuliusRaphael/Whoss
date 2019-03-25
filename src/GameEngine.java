import java.util.ArrayList;

import java.util.Random;



public class GameEngine{
	PictureMaker pics;
	Random rand;
	ArrayList<GameIcon> activeIcons;
	boolean gameOver;
	int count;
	

	public GameEngine(PictureMaker p) {
		activeIcons = new ArrayList<>();
		this.pics = p;
		rand = new Random();
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
	
	public GameIcon nextPic() {
		
		GameIcon gc = pics.getPicMap().get(rand.nextInt(pics.getPicMap().size()));
		while(gc.isHasPlayed()){
			gc = pics.getPicMap().get(rand.nextInt(pics.getPicMap().size()));
			
		}
		gc.setHasPlayed(true);
		count ++;

		return gc;
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