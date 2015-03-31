package BlogEngineTests.Units;

import BlogEngineTests.Framework.Config;
import BlogEngineTests.Framework.Driver;
import BlogEngineTests.Framework.LoginPage;
import org.junit.After;
import org.junit.Before;

public class BlogEngine {

    @Before
    public void BlogEngineTest() {

        Driver.Init();

        LoginPage.GoTo();
        LoginPage.LoginAs(Config.getLogin()).WithPass(Config.getPass()).Login();
    }

    @After
    public void Clean() {

        Driver.Close();
    }
}
