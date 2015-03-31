package BlogEngineTests.Framework;

import org.openqa.selenium.By;

public class BlogCommand {

    private String _name;
    private String _admin;
    private String _mail;
    private String _pass;

    public BlogCommand withName(String name) {
        _name = name;
        return this;
    }

    public BlogCommand withAdmin(String admin) {
        _admin = admin;
        return this;
    }

    public BlogCommand withEmail(String mail) {
        _mail = mail;
        return this;
    }

    public BlogCommand withPass(String pass) {
        _pass = pass;
        return this;
    }

    public void save() {

        Driver.instance.findElement(By.id("txtBlogName")).sendKeys(_name);
        Driver.instance.findElement(By.id("txtUserName")).sendKeys(_admin);
        Driver.instance.findElement(By.id("txtEmail")).sendKeys(_mail);
        Driver.instance.findElement(By.id("txtPassword")).sendKeys(_pass);
        Driver.instance.findElement(By.id("txtConfirmPassword")).sendKeys(_pass);
        Driver.instance.findElement(By.xpath("//button[@data-ng-click='saveNew()']")).click();
    }
}
