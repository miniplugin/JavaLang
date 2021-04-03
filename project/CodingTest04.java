package project;

import java.util.Scanner;
class CodingTest04 {
	public static void main(String[] args) throws Exception {
		int n,insert,comp,Key;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int Numbers[] = new int[n];
		for(int i=0; i<n; i++) {
			Numbers[i] = sc.nextInt();
		}
		for(insert=1; insert<n; insert++) {
			Key = Numbers[insert];
            for(comp=insert-1; comp>=0; comp--) {
                if(Numbers[comp] > Key) { //key의 앞자리를 하나씩 보면서 비교
                    Numbers[comp+1] = Numbers[comp]; //앞자리 값이 key값보다 크다면 뒤로 이동
                }else{
                    break;
                }
            }
            // Number[comp+1]이 Number[comp]로 채워졌기 때문에, 
            // Number[comp] 자리가 빈 상태. Numbers[comp] 채워야함
            // comp-- 후 아래 코드 실행이기 때문에 comp+1을 해서 Key 값으로 채운다.
            Numbers[comp+1] = Key;
        }
		for(int i=0; i<n; i++) {
			System.out.print(Numbers[i]+" ");
		}
	}
}