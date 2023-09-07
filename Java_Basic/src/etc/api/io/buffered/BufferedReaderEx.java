package etc.api.io.buffered;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderEx {

	public static void main(String[] args) {
		
		FileReader fr = null;
		BufferedReader br = null;
		//BufferedReader에는 readLine() 메서드가 있고
        //한 줄을 통째로 읽어서 String으로 리턴합니다.
        //더 이상 읽어들일 데이터가 없다면 null을 리턴.
		try {
			fr = new FileReader("C:/Mywork/hello.txt");
			br = new BufferedReader(fr);
			
			String str;
			while((str = br.readLine()) != null) {
				System.out.println(str);
			}
			
//			System.out.println(br.readLine());
//			System.out.println(br.readLine());
//			System.out.println(br.readLine());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
