import java.io.FileInputStream;
import java.util.*;

public class Exam_00 {

	/**
	 * @param args
	 */
	static int N, Answer;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/data/exam00.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int L = sc.nextInt();
			int P = sc.nextInt();
			String input = sc.next();
			
			//System.out.println(input);
			List li = new ArrayList();
			TreeSet<String> ts = new TreeSet<String>();
			
			for (int i = 0; i < input.length(); i++) {
				if(i+P < L) {
					li.add(input.substring(i, i+P));
					ts.add((String) input.substring(i, i+P));
				}
			}	
			List<String> li2 = new ArrayList<String>(ts);
			Answer = 0;
			int cnt;
			int max = 0;
			for (int i = 0; i < li2.size(); i++) {
				cnt = 0;
				for (int j = 0; j < li.size(); j++) {
					//System.out.println(li2.get(i) + " : " + li.get(j));
					if(li2.get(i).equals(li.get(j))) {
						cnt++;
						if(max < cnt) {
							max = cnt;
						}
					}
				}
				if(cnt >= 2) {
					Answer = max;
					//System.out.println(max);
				}
			}
			
			System.out.println("# " + (tc+1) + " " + Answer);
		}
	}

}
