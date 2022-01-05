package tvvcr;

public class TVCRMain {

	public static void main(String[] args) {
		TV tv = new TV();
		tv.power();
		tv.power();
		
		System.out.println("------------------------");
		
		TVCR tvcr = new TVCR();
		tvcr.power();
		tvcr.power();
		tvcr.power();

		System.out.println(tvcr);
		
		System.out.println("채널 업 전: "+ tvcr);
		
		
		for(int i=1; i<=10; i++) {
			tvcr.channelUP();
		}
		System.out.println("채널 업 후: "+ tvcr);
		
	}
	
	
	
}
