package queue.mail;

public class Mail {
	private String toSome;//사람 이름
	private String mailTitle;//메일 제목
	
	//생성자
	public Mail(String toSome, String mailTitle) {
		super();
		this.toSome = toSome;
		this.mailTitle = mailTitle;
	}


	//메서드
	public String getToSome() {
		return toSome;
	}


	public String getMailTitle() {
		return mailTitle;
	}


	@Override
	public String toString() {
		return "Mail [이름=" + toSome + ", 제목=" + mailTitle + "]";
	}



}