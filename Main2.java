import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Main2 {
	
	public static void main(String[] args)  throws IOException {
		
		ArrayList<Elephant> list=new ArrayList<>();
		int idCount=1;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String strLine;
	    while ((strLine = br.readLine()) != null) {
	        String[] str = strLine.split(" ");
	        int p = Integer.parseInt(str[0]);
	        int f = Integer.parseInt(str[1]);
	        list.add(new Elephant(p, f,idCount));
	        idCount++;
	    }
		
	    Collections.sort(list);
		
		int [] lis=new int [list.size()];
		lis[0]=1;
		for (int i=1;i<lis.length;i++) {
			lis[i]=Math.max(1, lis[i]);
			for (int i2=0;i2<i;i2++) {
				if (list.get(i).iq<list.get(i2).iq && list.get(i).weight>list.get(i2).weight) {
					lis[i]=Math.max(lis[i2]+1, lis[i]);
				}
			}
		}
		
		int max=0;
		for (int i : lis) {
			max=Math.max(i, max);
		}
		
		System.out.println(max);
		int [] solution=new int [max];
		
		boolean first=true;
		int last=0;
		for (int i=lis.length-1;i>=0 && max>0;i--) {
			if (lis[i]==max && (first || last<list.get(i).iq)) {
				last=list.get(i).iq;
				solution[--max]=list.get(i).id;
				first=false;
			}
		}
		
		for (int i=0;i<solution.length;i++) {
			System.out.println(solution[i]);
		}
	}
	public static class Elephant implements Comparable<Elephant> {
		int weight, iq, id;
		
		
		public Elephant(int weight, int iq, int id) {
			this.weight=weight;
			this.iq=iq;
			this.id=id;
		}
		public int compareTo(Elephant e) {
			return this.weight-e.weight;
		}
}
}