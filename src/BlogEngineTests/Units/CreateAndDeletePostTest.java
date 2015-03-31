package BlogEngineTests.Units;

import BlogEngineTests.Framework.Driver;
import BlogEngineTests.Framework.HomePage;
import BlogEngineTests.Framework.PostPage;
import org.junit.Assert;
import org.junit.Test;
import java.util.UUID;

public class CreateAndDeletePostTest extends BlogEngine {

    @Test
    public void CreateAndDeletePost() {

        String title = UUID.randomUUID().toString();
        String body = UUID.randomUUID().toString();

        PostPage.goTo();
        PostPage.writeNewPost();

        PostPage.initPost().withTitle(title).withBody(body).publish();

        PostPage.goTo();
        PostPage.searchPost(title);
        PostPage.goToHomePage();

        Driver.switchToNewWindow();

        Assert.assertTrue(HomePage.hasPost(title));

        Driver.switchToOriginalWindow();

        PostPage.searchPost(title);
        PostPage.deletePost();

        Assert.assertFalse(PostPage.isthePostInTheList(title));
    }
}
