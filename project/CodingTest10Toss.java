package project;

/*
* 이 클래스는 로또번호를 입력 받아서 3가지조건에 맞는지 확인한 값 출력하는 기능
*/
import java.util.Scanner;
class CodingTest10Toss {
	//전역변수(멤버변수)
	
	public static void main(String[] args) throws Exception {
		int n; 
		boolean Real;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int Lotto[] = new int[n];
		for(int i=0; i<n; i++){
			Lotto[i] = sc.nextInt();
		}
		CodingTest10Toss main = new CodingTest10Toss();
		Real = main.isValid(Lotto, n);
		if(Real == true) {
			System.out.println("Result = True");
		}else{
			System.out.println("Result = False");
		}
        sc.close();
	}
	
	public boolean isValid(int Lotto[], int size) {
		if(size != 6) {
			return false;
		}else{
			//중복숫자검사
			for(int i=0; i<size-1; i++) {
				if(Lotto[i] == Lotto[i+1]) {
					return false;
				}
			}
			//숫자범위검사
			for(int i=0; i<size; i++) {
				if(Lotto[i] < 1 || Lotto[i] > 45) {
					return false;
				}
			}
			//오름차순정렬검사
			for(int i=0; i<size-1; i++) {
				if(Lotto[i] > Lotto[i+1]) {
					return false;
				}
			}
		}
		return true;
	}
}