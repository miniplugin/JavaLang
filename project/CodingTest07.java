package project;

import java.util.Scanner;
class CodingTest07 {
	public static void main(String[] args) throws Exception {
		int n=0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int Score[] = new int[n];
		int Rank[] = new int[n];
		for(int i=0; i<n; i++) {
			Score[i] = sc.nextInt();
			Rank[i] = 0;//랭크의 초기값을 0으로 설정.
		}
		for(int i=0; i<n; i++) {
			for(int comp=0; comp<n; comp++) {
				if(Score[i] < Score[comp]) {
					Rank[i] = Rank[i] + 1;//Rank[i]의 순위가 낮아지는 부분
				}
			}
			Rank[i] = Rank[i] + 1;//0등은 + 1= 1등
		}
		for(int i=0; i<n; i++) {
			System.out.println(i+"번 학생의 점수는 "+Score[i]+", 등수는 "+Rank[i]);
		}
        sc.close();//사용하지 않는 객체를 메모리에서 삭제하는 명령.
	}
}