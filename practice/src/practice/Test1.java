package practice;

import java.util.Scanner;

public class Test1 {

	public static void main(String args[]) {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		String s = br.readLine();
//		
//		int i  = Integer.parseInt(s);
//		br.close();
//		
//		bw.write("입력받은 값 : "+s);
//		bw.newLine();
//		bw.write("입력받은 값 +10 : "+(10+i)+"\n" );
//		bw.write("이것도 가능한가요?\n");
//		bw.write("인생 최적화");
//		bw.flush();
//		bw.close();
		 Scanner sc = new Scanner(System.in);
	        System.out.println("숫자를 입력하세요");
	        int num = sc.nextInt();

	        for(int i=0; i<=num; i++){
	            for(int j=0; j<=num; j++){
	                System.out.print("*");
	            }
	            System.out.println();
	}
}
}
