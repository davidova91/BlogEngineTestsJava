package BlogEngineTests.Framework;

import org.openqa.selenium.By;

public class HomePage {

    public static boolean hasTitle(String name) {
        return Driver.instance.findElements(By.xpath("//h1/a[.='" + name + "']")).toArray().length > 0;
    }

    public static boolean hasPost(String title) {
        return Driver.instance.findElements(By.xpath("//h2/a[.='" + title + "']")).toArray().length > 0;
    }

    public static CommentCommand addComment() {
        return new CommentCommand();
    }

    public static boolean hasCommentOnPage(String comment) {
        return Driver.instance.findElements(By.xpath("//div/p[.='" + comment + "']")).toArray().length > 0;
    }

    public static boolean hasPage(String title) {
        return Driver.instance.findElements(By.xpath("//h2[.='" + title + "']")).toArray().length > 0;
    }
}
