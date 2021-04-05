package project;
/*
* 이 클래스는 작업한 코딩 소스중에 괄호문자가 올바른 괄호문자인지 체크하고, 누락된 괄호를 자동으로 추가해주는 기능
* 단, 입력할 코딩의 괄호문자는 균형을 맞춰야 합니다.(문자와 )문자의 개수가 같아야 함.
*/
import java.util.Scanner;
class CodingTest09Error {
	String endString;
	int count;//디버그용 카운트
	public static void main(String[] args) throws Exception {
		CodingTest09Error main = new CodingTest09Error();
		Scanner sc = new Scanner(System.in);
		String w;//체크할 코딩문자열
		w = sc.nextLine();
		String r = main.recursive(w);
		if(w.equals(r)) {
			System.out.println("올바른 괄호문자열 입니다. " + r);
		}else{
			System.out.println("잘못된 괄호문자열 입니다. 입력걊 "+w+" 수정값 "+r);
		}
	}
	
	public String recursive(String w) {
		String u="",v="";
		if(w==null || w.equals("")) {
			return w + endString;
		}else{
			int balancedIndex = getBalancedIndex(w);//w를 u,v로 파싱힐때 사용할 시작 인덱스값 추출
			u = w.substring(0, balancedIndex+1);//파싱주의 substring(시작인덱스, 끝인덱스-1)
			v = w.substring(balancedIndex+1);
			boolean isValidCheck = isValidString(u);//올바른 괄호문자열인지 확인 예, ()
			if(isValidCheck==true) {
				if(u.equals("(")) {
					endString += ")";
				}else{
					System.out.println("상)재귀count: " + count++ + " W를 분해: Unit값: "+u+" Viewr값: "+v);
					u += recursive(v);//재귀함수 호출하면서 u값 누적.
				}
				return u;
			}else{//올바른 괄호문자열이 아니라면.
				String createString = "(";
				createString += recursive(v);//재귀함수 호출하면서 createString값 누적.
				createString += ")";
				createString += reArrange(u);//올바른 괄호문자열 만들기
				return createString;
			}
		}
	}
	//올바른 괄호문자열 만들기
	public String reArrange(String u) {
		String arrangeString = "";
		for(int i=1; i<u.length()-1; i++) {
			String tmpChar = u.substring(i, i+1);//파싱주의 substring(시작인덱스, 끝인덱스-1)
			if(tmpChar.equals("(")) {
				arrangeString += ")";
			}else if(tmpChar.equals(")")) {
				arrangeString += "(";
			}
		}
		return arrangeString;
	}
	//올바른 문자열인지 확인 예, ()
	public boolean isValidString(String u) {
		int balanceCount = 0;
		for(int i=1; i<u.length()-1; i++) {
			String tmpChar = u.substring(i, i+1);//파싱주의 substring(시작인덱스, 끝인덱스-1)
			if(tmpChar.equals("(")) {
				balanceCount++;
			}else if(tmpChar.equals(")")) {
				balanceCount--;
			}
		}
		if(balanceCount < 0) {
			return false;
		}else{
			return true;
		}
	}
	//w를 u,v로 파싱힐때 사용할 시작 인덱스값 추출
	public int getBalancedIndex(String w) {
		int index=0, balanceCount=0;
		for(int i=1; i<w.length(); i++) {
			String tmpChar = w.substring(i, i+1);//파싱주의 substring(시작인덱스, 끝인덱스-1)
			if(tmpChar.equals("(")) {
				balanceCount++;
			}else if(tmpChar.equals(")")) {
				balanceCount--;
			}
			if(balanceCount == 0) { //균형이 맞는 w 라면
				index = i;
				break;
			}
		}
		return index;//균형이 맞지 않으면 0
	}
}