package miller_problem1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DuplicateRemover {
	static List<String> uniqueWords=new ArrayList<String>();
	
	public void remove(String datafile) throws IOException {
		String data = new String(Files.readAllBytes(Paths.get(datafile))).toLowerCase();
		data+=" ";
		String[] arr=data.split(" ");  
		
		for(int i=0;i<arr.length;i++)
			if(!uniqueWords.contains(arr[i]))
				uniqueWords.add(arr[i]);
	}
	
	public void write(String outputFile) throws IOException {
	  FileWriter fo=new FileWriter(outputFile);
      
	  for(int i=0;i<uniqueWords.size();i++) {
    	  fo.write(uniqueWords.get(i));
    	  fo.write(" ");
       }
      
       System.out.println("Output Writing successful"); 
       fo.close();
	}

}
