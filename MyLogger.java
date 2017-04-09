package Utils;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyLogger/*! \brief Wrapper Logger
    *
    *to make log file
    */{
	/**file handler*/
	FileHandler handler;
	/**a logger*/
	public Logger log = Logger.getLogger("PPL_Assignment");
	public MyLogger() throws Exception{/**constructor*/
		handler = new FileHandler("./Log/log.txt", false);
		handler.setFormatter(new MyFormatter());
		log.addHandler(handler);
	} 
     
	
}
class MyFormatter extends Formatter{/**to format the logs*/
	public String format(LogRecord record){
		return "\n\nOn "+new Date(record.getMillis())+" from method "+record.getSourceMethodName()+"\n"+record.getMessage();
	}
}
