package Tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class ReadFile {
	public static void main(String args[]) {
		String filePath="";
		try {
			Files.lines(Paths.get(filePath)).forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
