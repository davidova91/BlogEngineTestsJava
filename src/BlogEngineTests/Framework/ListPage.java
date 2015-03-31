package BlogEngineTests.Framework;

import org.openqa.selenium.By;

public class ListPage {

    public static void goTo() {
        Driver.instance.get(Config.getBaseAddress() + "/admin/#/content/pages");
        Driver.Wait();
    }

    public static void addNewPage() {
        Driver.instance.findElement(By.xpath("//a/i[@class='fa fa-plus']")).click();
    }

    public static PageCommand initPage() {
        return new PageCommand();
    }

    public static void searchNewPage(String title) {
        Driver.instance.findElement(By.xpath("//input[@ng-change='search()']")).sendKeys(title);
    }

    public static void goToHomePage() {
        Driver.instance.findElement(By.xpath("//i[@class='fa fa-external-link']")).click();
    }

    public static void deleteThisPage() {
        Driver.instance.findElement(By.xpath("//input[@type='checkbox']")).click();
        Driver.instance.findElement(By.xpath("//button/i[@class='fa fa-times']")).click();
    }

    public static boolean hasThisPage(String title) {
        return Driver.instance.findElements(By.linkText(title)).toArray().length > 0;
    }
}

