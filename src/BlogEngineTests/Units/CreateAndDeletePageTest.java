package BlogEngineTests.Units;

import BlogEngineTests.Framework.Driver;
import BlogEngineTests.Framework.HomePage;
import BlogEngineTests.Framework.ListPage;
import org.junit.Assert;
import org.junit.Test;
import java.util.UUID;

public class CreateAndDeletePageTest extends BlogEngine {

    @Test
    public void CreateAndDeletePage() {

        String title = UUID.randomUUID().toString();
        String body = UUID.randomUUID().toString();

        ListPage.goTo();
        ListPage.addNewPage();

        ListPage.initPage().withTitle(title).withBody(body).save();

        ListPage.goTo();
        ListPage.searchNewPage(title);
        ListPage.goToHomePage();

        Driver.switchToNewWindow();

        Assert.assertTrue(HomePage.hasPage(title));

        Driver.switchToOriginalWindow();

        ListPage.searchNewPage(title);
        ListPage.deleteThisPage();

        Assert.assertFalse(ListPage.hasThisPage(title));
    }
}
