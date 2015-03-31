package BlogEngineTests.Units;

import BlogEngineTests.Framework.UserPage;
import org.junit.Assert;
import org.junit.Test;
import java.util.UUID;

public class CreateAndDeleteUserTest extends BlogEngine {

    @Test
    public void CreateAndDeleteUser() {

        String name = UUID.randomUUID().toString();
        String mail = UUID.randomUUID().toString() + "@mail.com";
        String pass = UUID.randomUUID().toString();
        String role = "Editors";

        UserPage.goTo();
        UserPage.addNewUser();
        UserPage.initUser().withName(name).withEmail(mail).withPass(pass).choiseRole(role).save();
        UserPage.searchUser(name);

        Assert.assertTrue(UserPage.isUserInTheList(name));

        UserPage.deleteUser(name);

        Assert.assertFalse(UserPage.isUserInTheList(name));
    }
}
