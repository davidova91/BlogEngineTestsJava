package BlogEngineTests.Units;

import BlogEngineTests.Framework.BlogPage;
import BlogEngineTests.Framework.Driver;
import BlogEngineTests.Framework.HomePage;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class CreateAndDeleteBlogTest extends BlogEngine {

    @Test
    public void CreateAndDeleteBlog() {

        String name = UUID.randomUUID().toString();
        String admin = UUID.randomUUID().toString();
        String mail = UUID.randomUUID().toString() + "@mail.com";
        String pass = UUID.randomUUID().toString();

        BlogPage.goTo();
        BlogPage.addNewBlog();

        BlogPage.initBlog().withName(name).withAdmin(admin).withEmail(mail).withPass(pass).save();

        BlogPage.searchNewBlog(name);

        BlogPage.goToHomePage();

        Driver.switchToNewWindow();

        Assert.assertTrue(HomePage.hasTitle(name));

        Driver.switchToOriginalWindow();

        BlogPage.goTo();
        BlogPage.deleteBlog();

        Assert.assertFalse(BlogPage.isBlogInTheList(name));


    }
}
