package project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
class GroomSample {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 난이도의 문제 받기
		int[] questions = new int[N];
		String str = br.readLine();
		String[] split = str.split(" ");
		for(int i = 0; i < N; ++i){
			questions[i] = Integer.parseInt(split[i]);
		}
		
		//Arrays.sort(questions);//개발자가 만든 클래스의 sort메서드를 사용(아래)
		for(int before:questions) {//정렬전 입력된 배열 출력
			System.out.print(before+" ");
		}
		//UserArray.sort(questions);//sort매서드는 static 로 만들면 실행가능한(메모리에 로딩) 메서드
		UserArray userArray = new UserArray();//new 키워드로 객체(실행가능한 클래스)를 만듭니다.
		userArray.sort(questions);//스프링에서 new 객체를 만들면, 일정시간이 지나면, 자동으로 메모리에서 날립니다.=IoC제어의역전이라고 함.
		//userArray.close(); 스프링에서는 이런 명령어가 필요X
		System.out.println();
		for(int next:questions) {//정렬후 입력된 배열 출력
			System.out.print(next+" ");
		}
		
		int count = 1;
		int before = questions[0];
		for(int i : questions){
			if(before != i)
				count++;
			else if (count == 3)
				break;
			before = i;
		}
		if(count < 3)
			System.out.print("NO");
		else
			System.out.print("YES");
		
		br.close();
	}
}

class UserArray {
	public int[] sort(int[] Numbers) throws Exception {
		int n,prev,next,Temp;
		n = Numbers.length;//자바에서 내장된 length겟셋변수를 사용 정렬할 숫자의 개수를 입력받는다.
		//입력받은 배열을 정렬하는 로직 prev, next(아래)
		for(prev=0; prev<n-1; prev++) {
			for(next=prev+1; next<n; next++) {
				//아래 로직은 prev와 next변수값을 바뀌는 로직 입니다.
				if(Numbers[prev]>Numbers[next]) {
					Temp = Numbers[prev];
					Numbers[prev] = Numbers[next];
					Numbers[next] = Temp;
				}
			}
		}
		//정렬된 결과를 리턴합니다.(아래)
		return Numbers;
	}
}