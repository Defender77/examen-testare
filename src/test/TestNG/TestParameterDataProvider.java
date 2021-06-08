
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterDataProvider {
    @Test(description = "test1", dataProvider = "provideNumbers")
    public void test1(int number, int expected){
        Assert.assertEquals(number + 10, expected);
    }

    @DataProvider(name="provideNumbers")
    public Object[][] providedData(){
        return new Object[][]{
                {10, 20},
                {100, 110},
                {2000, 2010},
                {450, 460},
                {20, 30},
                {30, 40},
                {500, 510}
        };
    }
}
