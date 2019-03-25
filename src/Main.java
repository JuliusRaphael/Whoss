
public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		PictureMaker p = new PictureMaker();
		GameEngine g = new GameEngine(p);
		Gui gui = new Gui(g);
		

	}

}
