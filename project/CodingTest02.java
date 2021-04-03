package project;

import java.util.Scanner;
//CodingTest02 클래스는 오름차순을 구현= java.util.Array.sort() 매서드를 대신해서 만들기
class CodingTest02 {
	public static void main(String[] args) throws Exception {
		int[] Numbers;
		int n,prev,next,Temp;
		
		Scanner sc = new Scanner(System.in);//키보드로 입력받는 클래스, 바이트단위(문자)=키보드로 입력받는의미5
		n = sc.nextInt();//1줄에 있는 모든 내용을 읽어들이는 매서드., 정렬할 숫자의 개수를 입력받는다.
		//System.out.println("디버그 정렬할 숫자의 개수는:"+n);
		Numbers = new int[n];
		for(int i=0; i<n; i++) {
			Numbers[i] = sc.nextInt();
		}
		/* 정렬 전 출력 */
		for(int number:Numbers) {
			System.out.print(number+" ");
		}
		//입력받은 배열을 정렬하는 로직 prev, next(아래)
		for(prev=0; prev<n-1; prev++) {
			for(next=prev+1; next<n; next++) {
				//아래 로직은 prev와 next변수값을 바뀌는 로직 입니다.
				if(Numbers[prev]>Numbers[next]) {//내림차순 부등호만 바꾸면OK
					Temp = Numbers[prev];
					Numbers[prev] = Numbers[next];
					Numbers[next] = Temp;
				}
			}
		}
		//정렬 후 출력(아래)
		System.out.println();
		for(int number:Numbers){
			System.out.print(number+" ");
		}
	}
}