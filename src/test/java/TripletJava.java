import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TripletJava {
	
	public static void main(String[] args) {
		int[] a = {5,2,0,-1,-1};
		List<List<Integer>> aList = new ArrayList<>();
		Arrays.sort(a);
		
		for(int i =0; i<a.length-2; i++) {
			
			
			
			if(i>0 && a[i] == a[i-1]) {
				continue;	
			}
			 int left = i+1; int right = a.length-1;
			while(left<right) {
				System.out.println("0000");
				int sum = a[i]+a[left]+a[right];
				if(sum == 0) {
					aList.add(Arrays.asList(a[i],a[left],a[right]));
					while( a[left] == a[left+1]) {
						left++;
					}
					while(a[right] == a[right-1]) {
						right--;
					}
					left++;
					right--;
				} else if(sum>0) {
					right--;
				} else{
					left++;
				}
			}
		}
		
		System.out.println(aList);
	}


}
