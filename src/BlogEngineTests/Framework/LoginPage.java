package BlogEngineTests.Framework;

import org.openqa.selenium.By;

public class LoginPage {

    public static void GoTo() {
        Driver.instance.get(Config.getBaseAddress() + "Account/login.aspx");
        Driver.Wait();
    }

    public static LoginCommand LoginAs(String name) {
        return new LoginCommand(name);
    }

    public static class LoginCommand {

        private String _name;
        private String _pass;

        LoginCommand(String name) {
            _name = name;
        }

        public LoginCommand WithPass(String pass) {
            _pass = pass;
            return this;
        }

        public void Login() {
            Driver.instance.findElement(By.id("UserName")).sendKeys(_name);
            Driver.instance.findElement(By.id("Password")).sendKeys(_pass);
            Driver.instance.findElement(By.id("LoginButton")).click();
        }
    }
}
