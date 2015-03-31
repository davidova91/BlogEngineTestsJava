package BlogEngineTests.Framework;

import org.openqa.selenium.By;

public class BlogPage {

    public static void goTo() {
        Driver.instance.get(Config.getBaseAddress() + "/admin/#/blogs");
        Driver.Wait();
    }

    public static void addNewBlog() {
        Driver.instance.findElement(By.xpath("//button[@class='btn btn-success btn-header pull-right ng-binding']")).click();
    }

    public static BlogCommand initBlog() {
        return new BlogCommand();
    }

    public static void searchNewBlog(String name) {
        Driver.instance.findElement(By.xpath("//div/input[@class='form-control input-sm pull-right ng-pristine ng-valid']")).sendKeys(name);
    }

    public static void goToHomePage() {
        Driver.instance.findElement(By.xpath("//a[@class='external-link pull-right']")).click();
    }

    public static void deleteBlog() {
        Driver.instance.findElement(By.xpath("//td/input[@class='ng-pristine ng-valid']")).click();
        Driver.instance.findElement(By.xpath("//button[@class='btn btn-sm btn-danger ng-binding']")).click();
        Driver.Wait();
    }

    public static boolean isBlogInTheList(String name) {
        return Driver.instance.findElements(By.linkText(name)).toArray().length > 0;
    }
}

