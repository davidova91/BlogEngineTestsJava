package BlogEngineTests.Framework;

import org.openqa.selenium.By;

public class UserPage {

    public static void goTo() {
        Driver.instance.get(Config.getBaseAddress() + "/admin/#/users");
        Driver.Wait();
    }

    public static void addNewUser() {
        Driver.instance.findElement(By.xpath("//button[@class='btn btn-success btn-header pull-right ng-binding']")).click();
        Driver.Wait();
    }

    public static UserCommand initUser() {
        return new UserCommand();
    }

    public static void searchUser(String name) {
        Driver.instance.findElement(By.xpath("//input[@class='input-sm form-control search-grid pull-right ng-pristine ng-valid']")).sendKeys(name);
    }

    public static boolean isUserInTheList(String name) {
        return Driver.instance.findElements(By.linkText(name)).toArray().length > 0;
    }

    public static void deleteUser(String name) {
        Driver.instance.findElement(By.id("cb-" + name)).click();
        Driver.instance.findElement(By.xpath("//span[@class='btn btn-danger btn-sm ng-binding']")).click();
        Driver.Wait();
    }
}
