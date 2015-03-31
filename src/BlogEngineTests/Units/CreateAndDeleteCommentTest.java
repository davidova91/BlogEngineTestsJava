package BlogEngineTests.Units;

import BlogEngineTests.Framework.CommentsPage;
import BlogEngineTests.Framework.Driver;
import BlogEngineTests.Framework.HomePage;
import BlogEngineTests.Framework.PostPage;
import org.junit.Assert;
import org.junit.Test;
import java.util.UUID;

public class CreateAndDeleteCommentTest extends BlogEngine {

    @Test
    public void CreateAndDeleteComment() {

        String title = UUID.randomUUID().toString();
        String body = UUID.randomUUID().toString();
        String name = UUID.randomUUID().toString();
        String mail = UUID.randomUUID().toString() + "@mail.com";
        String comment = UUID.randomUUID().toString();

        PostPage.goTo();
        PostPage.writeNewPost();

        PostPage.initPost().withTitle(title).withBody(body).publish();

        PostPage.goTo();
        PostPage.searchPost(title);
        PostPage.goToHomePage();

        Driver.switchToNewWindow();

        HomePage.addComment().withName(name).withMail(mail).withBody(comment).saveComment();

        Assert.assertTrue(HomePage.hasCommentOnPage(comment));

        Driver.switchToOriginalWindow();

        CommentsPage.goTo();
        CommentsPage.searchThisComment(comment);
        CommentsPage.deleteComment();

        Assert.assertFalse(CommentsPage.isCommentInTheList(comment));
    }
}
