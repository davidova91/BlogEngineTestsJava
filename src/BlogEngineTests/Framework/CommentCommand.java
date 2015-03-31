package BlogEngineTests.Framework;

import org.openqa.selenium.By;

public class CommentCommand {

    private String _name;
    private String _mail;
    private String _comment;

    public CommentCommand withName(String name) {
        _name = name;
        return this;
    }

    public CommentCommand withMail(String mail) {
        _mail = mail;
        return this;
    }

    public CommentCommand withBody(String comment) {
        _comment = comment;
        return this;
    }

    public void saveComment() {
        Driver.instance.findElement(By.id("txtName")).sendKeys(_name);
        Driver.instance.findElement(By.id("txtEmail")).sendKeys(_mail);
        Driver.instance.findElement(By.id("txtContent")).sendKeys(_comment);
        Driver.instance.findElement(By.id("btnSaveAjax")).click();
        Driver.Wait();
    }
}
