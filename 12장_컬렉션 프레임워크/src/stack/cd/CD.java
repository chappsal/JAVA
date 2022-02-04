package stack.cd;

public class CD {
	private String cdTitle; //제목

	//생성자
	public CD(String cdTitle) {
		super();
		this.cdTitle = cdTitle;
	}

	//메서드
	public String getCdTitle() {
		return cdTitle;
	}

	public void setCdTitle(String cdTitle) {
		this.cdTitle = cdTitle;
	}

	
	
	@Override
	public String toString() {
		return "CD [cdTitle=" + cdTitle + "]";
	}
	
	
	
	
	
}