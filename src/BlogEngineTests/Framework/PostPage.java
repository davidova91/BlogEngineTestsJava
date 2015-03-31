package BlogEngineTests.Framework;

import org.openqa.selenium.By;

public class PostPage {

    public static void goTo() {
        Driver.instance.get(Config.getBaseAddress() + "/admin/#/content");
        Driver.Wait();
    }

    public static void writeNewPost() {
        Driver.instance.findElement(By.xpath("//a[@class='btn btn-success btn-header pull-right ng-binding']")).click();
    }

    public static PostCommand initPost() {
        return new PostCommand();
    }

    public static void searchPost(String title) {
        Driver.instance.findElement(By.xpath("//div/input[@placeholder='Search']")).sendKeys(title);
    }

    public static void goToHomePage() {
        Driver.instance.findElement(By.xpath("//a/i[@class='fa fa-external-link']")).click();
        Driver.Wait();
    }

    public static void deletePost() {
        Driver.instance.findElement(By.xpath("//input[@type='checkbox']")).click();
        Driver.instance.findElement(By.xpath("//button[@class='btn btn-danger btn-sm ng-binding']")).click();
        Driver.Wait();
    }

    public static boolean isthePostInTheList(String title) {
        return Driver.instance.findElements(By.linkText(title)).toArray().length > 0;
    }

    public static void draft() {
        Driver.instance.findElement(By.id("fltr-dft")).click();
    }

    public static boolean isPostInTheList(String title) {
        return Driver.instance.findElements(By.linkText(title)).toArray().length > 0;
    }
}
