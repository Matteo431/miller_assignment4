package miller_problem2;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;



public class DuplicateCounter {
	static Map<String,Integer> wordCounter=new TreeMap<String,Integer>();
	
	public void count(String datafile) throws IOException {	
		String data = new String(Files.readAllBytes(Paths.get(datafile))).toLowerCase(); 
		String[] arr = data.split(" ");  
		
		for(int i = 0;i < arr.length;i++){
			if(wordCounter.containsKey(arr[i]))
				wordCounter.put(arr[i], 1 + wordCounter.get(arr[i]));
					
			else
				wordCounter.put(arr[i], 1);
		}
		
	}
	
	public void write(String outputFile) throws IOException {
	  FileWriter fo =new FileWriter(outputFile);
	  Set <String> keys = wordCounter.keySet();
	  
	  for (Map.Entry mapElement : wordCounter.entrySet()) {
		  fo.write(mapElement.getKey()+":"+mapElement.getValue());
		  fo.write(" , ");
	  }
	  
	  System.out.println("Output writing successful");
      fo.close();
	}

}
