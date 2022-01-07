/*
 * Player가 있고 이 Player가 게임을 합니다.
 * 게임에서 Player가 가지는 레벨(3가지: 초 중 고급)에 따라 할 수 있는 3가지 기능이 있습니다.
 * 바로 run(), jump(), turn()입니다.
 * 
 *  -초보자 레벨: 천천히 달림
 *  -중급자 레벨: 빠르게 달리고 점프함
 *  -고급자 레벨: 빠르게 달리고 점프하고 턴함
 */

package gamelevel;

public class Player {
	private PlayerLevel level;//'레벨'을 가진 선수(포함관계)

	//생성자
	public Player() {
		//new PlayerLavel(); //추상 클래스는 객체 생성 안 됨 : 미완성이라
		level = new BeginnerLevel(); //초급 레벨부터 시작
		level.showLevelMessage();
		
	}
	
	//14행 private PlayerLevel level;이 private이기 때문에 get set생성
	public PlayerLevel getLevel() { //타입이 클래스타입이면 (PlayerLevel)
		return level; //주소 리턴
	}

	public void upgradeLebel(PlayerLevel level) {
		this.level = level;
		level.showLevelMessage();
	}

	//외부에 노출된 버튼
	public void play(int count) {
		level.go(count); //실질적인 기능
	}



}