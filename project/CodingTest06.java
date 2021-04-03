package project;

import java.util.Scanner;
/*
* 이 클래스는 n팩토리얼을 구하는 클래스, 예 5! = 5x4x3x2x1 
*/
class CodingTest06 {
	//멤버변수(전역)
	static long Factorial = 1;
	public static void main(String[] args) throws Exception {
		int n;
		long Result;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Result = fact(n);
		System.out.println(n+" 팩토리얼 = "+Result);
        sc.close();
	}
	
	public static long fact(int n) {
		if(n==1) {
			return Factorial;
		}else{
			Factorial = Factorial * n;
			n = n - 1;
			return fact(n);//재귀함수를 호출해서 for반복문 역할.
		}
	}
}