package Utils;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
public class MyLogger/*! \brief Wrapper Logger
    *
    *to make log file
    */{
	/**file handler*/
	FileHandler handler;
	/**a logger*/
	public Logger log = Logger.getLogger("PPL_Assignment");
	public MyLogger() throws Exception{/**constructor*/
		handler = new FileHandler("./Log/log.txt", true);
		log.addHandler(handler);
	} 
     
	
}