package project;

import java.util.Scanner;
/*
* 이 클래스는 십진수 2진수로 바꾸는 기능, 2을 나누는 값으로 상수로 사용
*/
class CodingTest05 {
	public static void main(String[] args) throws Exception {
		int Bin[] = new int[100];//배열변수 생성하는데, 배열의 크기를 초기화 필수.
		int Dec, idx=0, Mok, Nmg;
		Scanner sc = new Scanner(System.in);
		Dec = sc.nextInt();
		//System.out.println("십진수 "+Dec+" 의 이진수 변환결과는: ");
		while(true) {
			Mok = (int)Dec/2;
			Nmg = Dec - (Mok*2);
			//디버그용 System.out.println(Mok);
			Bin[idx] = Nmg;
			//System.out.println("십진수 "+Dec+" 의 몫="+Mok+" 나머지="+Nmg+" 인덱스="+idx);
			idx = idx + 1;
			if(Mok == 0) { break;}
			Dec = Mok;
		}
		for(int i=idx-1; i>=0; i--) {
			System.out.print(Bin[i]);
		}
	}
}