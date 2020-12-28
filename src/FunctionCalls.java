
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class FunctionCalls {
	
	public static void main(String[] args) {
		
		//Create Key-Value Data store by using Properties Class 
		
		Implementations propertiesDb = new Implementations("data.properties");
		Properties properties = propertiesDb.read();
		
		//------------Create key-value pairs and store it in the file/datastore-----------------------		
		try {
			propertiesDb.create("Name", "abc");
			propertiesDb.create("Email", "abc123@gmail.com");
			propertiesDb.create("Address", "Gunupur,Odisha");
			
			// if key already exists, throws exception
			// propertiesDb.create("Name", "xyz");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//--------------Read the file--------------------
		properties.list(System.out);
		System.out.println(propertiesDb.read());
		
				
		//-----------------------Delete a key from the file/datastore---------------------
		//propertiesDb.delete("Address");
		System.out.println();
		System.out.println("After deleting a key");
		System.out.println(propertiesDb.read());
		
		

		
		
	}
	
}