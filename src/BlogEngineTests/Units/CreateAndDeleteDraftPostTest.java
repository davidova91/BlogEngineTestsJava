package BlogEngineTests.Units;

import BlogEngineTests.Framework.PostPage;
import org.junit.Assert;
import org.junit.Test;
import java.util.UUID;

public class CreateAndDeleteDraftPostTest extends BlogEngine {

    @Test
    public void CreateAndDeleteDraftPost() {

        String title = UUID.randomUUID().toString();
        String body = UUID.randomUUID().toString();

        PostPage.goTo();
        PostPage.writeNewPost();

        PostPage.initPost().withTitle(title).withBody(body).save();

        PostPage.goTo();
        PostPage.draft();
        PostPage.searchPost(title);
        PostPage.deletePost();

        Assert.assertFalse(PostPage.isPostInTheList(title));
    }
}
