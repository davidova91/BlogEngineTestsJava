package BlogEngineTests.Framework;

import org.openqa.selenium.By;

public class UserCommand {

    private String _name;
    private String _mail;
    private String _pass;
    private String _role;

    public UserCommand withName(String name) {
        _name = name;
        return this;
    }

    public UserCommand withEmail(String mail) {
        _mail = mail;
        return this;
    }

    public UserCommand withPass(String pass) {
        _pass = pass;
        return this;
    }

    public UserCommand choiseRole(String role) {
        _role = role;
        return this;
    }

    public void save() {
        Driver.instance.findElement(By.id("txtUserName")).sendKeys(_name);
        Driver.instance.findElement(By.id("txtEmail")).sendKeys(_mail);
        Driver.instance.findElement(By.id("txtPassword")).sendKeys(_pass);
        Driver.instance.findElement(By.id("txtConfirmPassword")).sendKeys(_pass);
        Driver.instance.findElement(By.xpath("//label[contains(., '" + _role + "')]/input")).click();
        Driver.instance.findElement(By.xpath("//button[@data-ng-click='saveUser()']")).click();
    }
}
