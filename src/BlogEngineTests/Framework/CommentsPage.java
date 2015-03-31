package BlogEngineTests.Framework;

import org.openqa.selenium.By;

public class CommentsPage {

    public static void goTo() {
        Driver.instance.get(Config.getBaseAddress() + "/admin/#/content/comments");
    }

    public static void searchThisComment(String comment) {
        Driver.instance.findElement(By.xpath("//input[@ng-change='search()']")).sendKeys(comment);
    }

    public static void deleteComment() {
        Driver.instance.findElement(By.xpath("//input[@data-ng-model='item.IsChecked']")).click();
        Driver.instance.findElement(By.xpath("//button/i[@class='fa fa-times']")).click();
        Driver.Wait();
    }

    public static boolean isCommentInTheList(String comment) {
        return Driver.instance.findElements(By.linkText(comment)).toArray().length > 0;
    }
}
