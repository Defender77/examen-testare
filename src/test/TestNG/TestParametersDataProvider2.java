
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

//SOLID
public class TestParametersDataProvider2 {
    @Test(dataProvider = "dataProvider")
    public void test1(int number, int expected){
        Assert.assertEquals(number, expected);
    }

    @Test(description = "test1", dataProvider = "dataProvider")
    public void test2(String number, String expected){
        Assert.assertNotEquals(number, expected);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] provideData(Method method){
        Object[][] result = null;
        if(method.getName().equals("test1")){
            result = new Object[][]{
                    {1,1}, {200, 200}
            };
        } else if(method.getName().equals("test2")){
            result = new Object[][]{
                    {"test5@mail.com","test@mail.com"}, {"test@mail.com", "test2@mail.com"}
            };
        }
        return result;
    }

}
