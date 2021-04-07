package dataprovider;

import org.testng.annotations.DataProvider;

public class SignUpData {

    @DataProvider(name = "correct data")
    public Object[][] correctFields(){
        return new Object[][]{
                {"Jose","Taboada","jose.t12399@test19923.com","983526453","JOTA","JOTA"}
        };
    }

    @DataProvider(name = "missing data")
    public Object[][] missingFields(){
        return new Object[][]{
                {null,"Taboada","jose.t123@test1234.com","983526453","JOTA","JOTA"},
                {"Jose",null,"jose.t123@test1234.com","983526453","JOTA","JOTA"},
                {"Jose","Taboada",null,"983526453","JOTA","JOTA"},
                {"Jose","Taboada","jose.t123@test1234.com",null,"JOTA","JOTA"},
                {"Jose","Taboada","jose.t123@test1234.com","983526453",null,"JOTA"},
                {"Jose","Taboada","jose.t123@test1234.com","983526453","JOTA",null}
        };
    }

    @DataProvider(name = "invalid email")
    public Object[][] invalidEmail(){
            return new Object[][]{
                    {"Jose","Taboada","jose.t123@test123","983526453","JOTA","JOTA"}
            };
    }
    @DataProvider(name = "duplicated email")
    public Object[][] duplicatedEmail(){
        return new Object[][]{
                {"Jose","Taboada","jose.t123@test123.com","983526453","JOTA","JOTA"}
        };
    }
}

