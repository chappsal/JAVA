package tvvcr_abstract_test;

import java.util.ArrayList;

public class TVCRArrayListMain {

	public static void main(String[] args) {
		
		ArrayList<Electronics> e = new ArrayList<Electronics>();
		
		e.add(new TV());
		e.add(new VCR());
		e.add(new TVCR());
		
		System.out.println("===============각 전자제품의 정보 한꺼번에 출력===================");
		
		
		System.out.println();//구분위한 빈줄
		
		System.out.println("===============각 전자제품의 정보 각각 출력===================");
		System.out.println("-------[for문]---------");
		
		
		System.out.println();//구분위한 빈줄
		
		System.out.println("------[향상된 for문]------");
		
		
		System.out.println();//구분위한 빈줄
		
		System.out.println("=========각 전자제품의 메서드 호출 후 정보 출력===================");
		
		
	
	}

}

