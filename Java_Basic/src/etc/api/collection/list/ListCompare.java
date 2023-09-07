package etc.api.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListCompare {

	public static void main(String[] args) {

		List<Integer> array = new ArrayList<>();
		List<Integer> linked = new LinkedList<>();
		
		for(int i=0; i<100000; i++) {
			array.add(i);
			linked.add(i);
		}
		
		long start, end; //시작시간, 끝시간
		
		//배열리스트에서 데이터 제어
		start =System.currentTimeMillis();
		
		for(int i=0; i<array.size(); i++) {
			array.remove(0);
		}
		
		end = System.currentTimeMillis();
		System.out.printf("배열리스트의 소요시간: %dms\n", end-start);
		
		//연결리스트에서 데이터 제어
		for(int i=0; i<array.size(); i++) {
			array.remove(0);
		}
		
		end = System.currentTimeMillis();
		System.out.printf("연결리스트의 소요시간: %dms\n", end-start);

	}

}
