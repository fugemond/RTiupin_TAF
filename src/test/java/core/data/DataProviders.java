package core.data;
import org.testng.annotations.*;

public class DataProviders {
    @DataProvider (name = "launchesName")
    public Object[][] launchesName(){
        return new Object[][] {{"1","Demo Api Tests#5"}, {"2","Demo Api Tests#4"},{"3","Demo Api Tests#3"},{"4","Demo Api Tests#2"},{"5","Demo Api Tests#1"}};
    }

    @DataProvider (name = "launchesRunTotal")
    public Object[][] launchesRunTotal(){
        return new Object[][] {{"1","30"}, {"2","25"},{"3","20"},{"4","15"},{"5","10"}};
    }

    @DataProvider (name = "launchesRunPassed")
    public Object[][] launchesRunPassed(){
        return new Object[][] {{"1","30"}, {"2","20"},{"3","10"},{"4","5"},{"5","1"}};
    }
}
