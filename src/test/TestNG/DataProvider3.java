import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider3 {
    @Test(dataProvider = "newDataProvider", groups = {"groupA"})
    public void test1(int number) {
        Assert.assertEquals(number, 1);
    }

    @Test(dataProvider = "newDataProvider", groups = {"groupB"})
    public void test2(int number) {
        Assert.assertEquals(number, 2);
    }

    @DataProvider(name = "newDataProvider")
    public Object[][] provideData(ITestContext context) {
        Object[][] result = null;
        for (String group : context.getIncludedGroups()) {
            System.out.println("group :" + group);

            if ("groupB".equals(group)) {
                result = new Object[][]{{1}};
                break;
            }

        }
        if (result == null) {
            result = new Object[][]{{1}};
        }
        return result;
    }


}
