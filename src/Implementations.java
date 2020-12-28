
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Implementations {
	// Creating the key value data Store using Properties class 
	// Creating object of Properties class
	private final Properties properties;
	
	// The absolute path of the properties file (settings) 
	private String fileAbsolutePath;
	
	// required for single thread operation
    private static final ExecutorService updateExecutorService = Executors.newSingleThreadExecutor();
    

	//constructor
	public Implementations(String fileAbsolutePath2) {
		this.fileAbsolutePath = fileAbsolutePath2;
		this.properties = new Properties();
		File file = new File(fileAbsolutePath);
		if (!file.exists()) {
			try {
				// if file does not exists, a new file is created inside the project folder
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				updateExecutorService.submit(() -> {
					try (InputStream inStream = new FileInputStream(fileAbsolutePath); 
					OutputStream outStream = new FileOutputStream(fileAbsolutePath)) {
						
						properties.load(inStream);
						properties.store(outStream, null);
						
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				});
	}


	//----------------------------------------------
	// Create Operation
	public void create(String key , String value) throws IOException {
		
		if(!properties.containsKey(key))
		properties.setProperty(key, value);
		else {
			throw new IOException("Key Already Exists");
		}

	}
	
	//----------------------------------------------
	// Read Operation
       public Properties read() {
		return properties;
	   }
       
       
    //------------------------------------------------
    // Delete Operation
	   public void delete(String key) {
		   properties.remove(key);
	   }
	
	
	
}