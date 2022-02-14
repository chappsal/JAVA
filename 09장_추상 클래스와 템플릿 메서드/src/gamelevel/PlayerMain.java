package gamelevel;

public class PlayerMain {

	public static void main(String[] args) {
		Player p = new Player();
		p.play(1);
		
		p.upgradeLebel(new AdvencedLevel());
		p.play(2);
		
		p.upgradeLebel(new SuperLevel());
		p.play(3);
		
	} //main

}
