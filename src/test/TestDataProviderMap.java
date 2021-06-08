
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestDataProviderMap {
    @Test(description = "test1", dataProvider = "dbConfig")
    public void test1(Map<String, String> map){
        for(Map.Entry<String,String> entry :map.entrySet()){
            System.out.println("[Key] : " + entry.getKey() +
                    "[Value] : "  + entry.getValue());
        }
    }

    @DataProvider(name = "dbConfig")
    public Object[][] provideDbConfig(){
        Map<String, String> map = readDbConfig();
        return new Object[][] {{map}};
    }

    public Map<String, String> readDbConfig(){
        Properties dbProperties = new Properties();
        InputStream input = null;
        Map<String, String> map = new HashMap<String,String>();

        try{
            File dbPropertiesFile = new File("src\\test\\resources\\db.properties");
            input = new FileInputStream(dbPropertiesFile);

            dbProperties.load(input);

            map.put("jdbc.driver", dbProperties.getProperty("jdbc.driver"));
            map.put("jdbc.url", dbProperties.getProperty("jdbc.url"));
            map.put("jdbc.username", dbProperties.getProperty("jdbc.username"));
            map.put("jdbc.password", dbProperties.getProperty("jdbc.password"));
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (input != null) {
                try{
                    input.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

}
