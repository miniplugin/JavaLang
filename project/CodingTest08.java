package project;

import java.util.Scanner;
class CodingTest08 {
	public static void main(String[] args) throws Exception {
		int n=0, MaxCnt=0, Top=0, Max=0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int Vote[] = new int[n];//주의, C의 배열변수와 차이있음.
		for(int i=0; i<n; i++) {
			Vote[i] = sc.nextInt();
			if(Vote[i] > Max) { //배열 입력값중 최고높은값을 구하는 로직
				Max = Vote[i];
			}
		}
		int Index[] = new int[Max+1];//반복할 배열의 크기 선언
		//핵심로직(아래)
		for(int i=0; i<n; i++) {
			Index[Vote[i]] = Index[Vote[i]] + 1;//투표한 값 = 인덱스의 인덱스값 => + 1
		}
		//예) Vote[0]=5, Vote[1]=1, Vote[2]=5
		// 1회전: Index[5] = Index[5] + 1  => 1
		// 2회전: Index[1] = Index[1] + 1 => 1
		// 3회전: Index[5] = Index[5] + 1 => 2 최종결과 15 룰 투표한 사람이 2명
		// 인덱스가 0, 1, 2, 3, 4, 5 = 배열의 크기는 6개 필요
		for(int i=0; i<Max+1; i++) { //MaxCnt, Top 구하는 for문 로직
			if(Index[i] > MaxCnt) {
				MaxCnt = Index[i]; //최다 선택한 값의 개수
				Top = i; //최다 선택한 값
			}
		}
		System.out.println("최다 선택값: "+Top+", 선택한 회수: "+MaxCnt);
	}
}