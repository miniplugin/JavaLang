package project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
* Main클래스는 돈을 입력받아서 화폐단위별로 몇개씩 존재하는지 출력하는 기능
* 5만원 단위포함. 화폐단위 50000->10000->5000->1000->500->100->50->10->5->1
* 규칙: 5만/5->1만/2->5천/5->1천/2->500/5->100/2->50/5->10/2->5/5->1/2->0.5
*/
class CodingTest01 {
	public static void main(String[] args) throws Exception {
		int MONEY=0;
		int UNIT=50000,NUM=0,SW=0;
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		MONEY=Integer.parseInt(br.readLine());
		//System.out.println("디버그:"+MONEY);
		while(true){ //종료값을 확실하지 않을때, for문 종료하고,증가하는 값이 일정할때
			NUM=(int)MONEY/UNIT;
			if(NUM>0){
				System.out.println("화폐단위 "+UNIT+" 원의 개수는 "+NUM+" 개");
			}
			if(UNIT>1){
				//구현될때 제일 끈의 화폐단위가 UNIT=1 -> 0.5
				MONEY=MONEY-(UNIT*NUM);//1회반복일때 66666-50000=16666
				if(SW==0){
					UNIT=UNIT/5;
					SW=1;
				}else{
					UNIT=UNIT/2;
					SW=0;
				}
			}else{
				break;//반복문 종료
			}
		}
	}
}