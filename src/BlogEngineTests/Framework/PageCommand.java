package BlogEngineTests.Framework;

import org.openqa.selenium.By;

public class PageCommand {

    private String _title;
    private String _body;

    public PageCommand withTitle(String title) {
        _title = title;
        return this;
    }

    public PageCommand withBody(String body) {
        _body = body;
        return this;
    }

    public void save() {
        Driver.Wait();
        Driver.instance.findElement(By.id("txtTitle")).sendKeys(_title);
        Driver.instance.findElement(By.id("editor")).sendKeys(_body);
        Driver.instance.findElement(By.xpath("//a[@data-ng-click='save()']")).click();
    }
}
