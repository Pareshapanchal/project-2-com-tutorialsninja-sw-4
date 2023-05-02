package index.php.demo.com.tutorialsninja.propertyreader;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
    //Declare the PropertyReader variable
    private static volatile PropertyReader propInstance;
    //create private constructor because of prevent the instantiation of class
    private PropertyReader(){ }
    //This method will return intance of PropertyReader Class
    public static synchronized PropertyReader getInstance(){
        if(propInstance == null){
            propInstance = new PropertyReader();
        }
        return propInstance;
    }
    //This method will read property from property file
    public String getProperty(String propertyName){
        Properties prop = new Properties();
        FileInputStream inputStream = null;
        try{
            inputStream= new FileInputStream(System.getProperty("user.dir")+"/src/test/java/resources/propertiesfile/config.properties");
            prop.load(inputStream);
            if (prop.getProperty(propertyName) != null) {
                return prop.getProperty(propertyName);
            }

        }catch (Exception e){
            System.out.println("Property Not Found");
        }
        return null;
    }


}
