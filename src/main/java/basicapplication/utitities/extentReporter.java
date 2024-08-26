package basicapplication.utitities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReporter {
	
	
	public static ExtentReports generateExtentReport() {
	
	ExtentReports extentreporter =new ExtentReports();
	File extentreportfile = new File (System.getProperty("user.dir")+"\\test-output\\extentreports\\extentreports.html");

	ExtentSparkReporter spark =new ExtentSparkReporter (extentreportfile);
	
	spark.config().setTheme(Theme.DARK);
	spark.config().setReportName("Results Report");
	spark.config().setDocumentTitle("Basic application");
	spark.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
	
	extentreporter.attachReporter(spark);
	
	
	Properties prop =new Properties();
	File file =new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\config\\config.properties");
	try {
	FileInputStream fileinput =new FileInputStream(file);
	prop.load(fileinput);
	}catch(Throwable e) {
		e.printStackTrace();
	}
	
	
	extentreporter.setSystemInfo("application URL", prop.getProperty("url"));
	extentreporter.setSystemInfo("Browser Name",prop.getProperty("browserName"));
	extentreporter.setSystemInfo("Email",prop.getProperty("validEmail"));
	extentreporter.setSystemInfo("Password",prop.getProperty("validPassword"));
	extentreporter.setSystemInfo("Operating System",System.getProperty("os.name"));
	extentreporter.setSystemInfo("Username",System.getProperty("user.name"));
	extentreporter.setSystemInfo("Java Version",System.getProperty("java.version"));
	
	
	return extentreporter;



		
	}
}