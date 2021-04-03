package project;

import java.util.Scanner;
class CodingTest03 {
	public static void main(String[] args) throws Exception {
		int n=0, bubble, idx, Temp;
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int Numbers[] = new int[n];
		//System.out.println("디버그: "+n);
		for(int i=0; i<n; i++) {
			Numbers[i] = sc.nextInt();
		}
		//중복 for문 시작
		for(bubble=0; bubble<n; bubble++) {
			for(idx=0;idx<(n-1);idx++) {
				if(Numbers[idx] > Numbers[idx+1]) {
					Temp = Numbers[idx];
					Numbers[idx] = Numbers[idx+1];
					Numbers[idx+1] = Temp;
				}
			}
		}
		//정렬한 결과 출력
		System.out.println();//줄바꿈 역할
		for(int i=0; i<n; i++) {
			System.out.print(Numbers[i]+" ");
		}
	}
}