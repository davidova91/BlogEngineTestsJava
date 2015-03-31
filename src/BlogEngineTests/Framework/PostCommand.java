package BlogEngineTests.Framework;

import org.openqa.selenium.By;

public class PostCommand {

    private String _title;
    private String _body;

    public PostCommand withTitle(String title) {
        _title = title;
        return this;
    }

    public PostCommand withBody(String body) {
        _body = body;
        return this;
    }

    public void publish() {
        Driver.Wait();
        Driver.instance.findElement(By.id("txtTitle")).sendKeys(_title);
        Driver.instance.findElement(By.id("editor")).sendKeys(_body);
        Driver.instance.findElement(By.xpath("//a[@data-ng-click='publish(true)']")).click();
    }

    public void save() {
        Driver.Wait();
        Driver.instance.findElement(By.xpath("//a[@ng-click='save()']")).click();
    }
}
