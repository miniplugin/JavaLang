package project;

import java.util.Scanner;
/*
* 이 클래스는 카카오 2020년 코딩 테스트 문제 풀이를 개선한 내용 입니다.
* 참조: https://yeti.tistory.com/234?category=684647
*/
class CodingTest09Kakao {
	//김일국 추가 시작
	String endString = ""; //입력 문자열의 끝에 균형 문자열 누적 변수
    int count = 0;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		//키보드 받기
		String p = sc.nextLine();//키보드 입력 커서 발생
		CodingTest09Kakao main = new CodingTest09Kakao();
		String r = main.recursive(p);
		if(p.equals(r)) {
			System.out.println("올바른 괄호문자열 입니다.\n"+r);
		}else{
			System.out.println( "잘못된 괄호문자열 입니다.\n입력값"+p+" -> 수정값"+r);
		}
		sc.close();
	}
	//김일국 끝

	private String recursive(String w) {
			// 입력이 빈 문자열인 경우, 빈 문자열을 반환
			if (w == null || w.equals("")) {
                    System.out.println("재귀count:"+count+"마지막");
					return w + endString;//김일국 추가 + endString 출력결과에 균형 문자열 누적 변수
			}
			// 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
			//// 균형잡힌 괄호에 대해 확인
			int balancedIndex = getBalancedIndex(w);
			String u = w.substring(0, balancedIndex+1);
			String v = w.substring(balancedIndex+1);
			// 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
			boolean isValidString = isValidString(u);
			if (isValidString) {
					//김일국 시작 w파싱한 u값이 "(" 문자라면 닫힘 균형 문자 누적: getBalancedIndex(w) 파싱규칙 확인
					if("(".equals(u)) endString += ")";
					//김일국 끝
					// 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
          System.out.println("재귀count: " + count++ + " W를 분해: Unit값: "+u+" Viewr값: "+v);
					u += recursive(v);
          System.out.println("재귀"+count+ "이후 View값으로: "+v+" Unit값누적: "+u);
					return u;
			} else {
					// 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
					String createString = "(";
					// 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
					createString += recursive(v);
					// ')'를 다시 붙입니다. 
					createString += ")";
                    System.out.println("디버그둘: " + createString);
					// u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
					createString += reArrange(u);
                    System.out.println(u + " 디버그셋: " + createString);
					return createString;
			}
	}

	private String reArrange(String u) {
			String arrangeString = "";
			for (int i = 1; i < u.length()-1; i++) {
					String tmpChar = u.substring(i, i+1);
					if ("(".equals(tmpChar)) {
							arrangeString += ")";
					} else if (")".equals(tmpChar)) {
							arrangeString += "(";
					}
			}
			return arrangeString;
	}
	
	private boolean isValidString(String u) {
			int balanceCount = 0;		
			for (int i = 0; i < u.length(); i++) {
					String tmpChar = u.substring(i, i+1);
					if ("(".equals(tmpChar)) {
							balanceCount++;
					} else if (")".equals(tmpChar)) {
							balanceCount--;
					}
					if (balanceCount < 0) {
							return false;
					}
			}
			return true;
	}

	private int getBalancedIndex(String w) {
			int index = 0;
			int balanceCount = 0;
			for (int i = 0; i < w.length(); i++) {
					String tmpChar = w.substring(i, i+1);
					if ("(".equals(tmpChar)) {
							balanceCount++;
					} else if (")".equals(tmpChar)) {
							balanceCount--;
					}
					if (balanceCount == 0) {
							index = i;
							break;
					}
			}
			return index;
	}
}