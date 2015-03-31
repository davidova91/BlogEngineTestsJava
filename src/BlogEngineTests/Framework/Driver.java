package BlogEngineTests.Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;


public class Driver {

    public static String windowHandle;

    public static String window;

    public static WebDriver instance;

    public WebDriver getInstance() {
        return this.instance;
    }

    public void setInstance(WebDriver instance) {
        this.instance = instance;
    }

    public static void Init() {
        instance = new FirefoxDriver();
        instance.manage().window().maximize();
        window = instance.getWindowHandle();
        windowHandle = instance.getWindowHandle();
    }

    public static void Close() {
        Driver.Wait();
        Driver.Wait();
        instance.close();
    }

    public static void Wait() {
        Driver.instance.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    public static void switchToNewWindow() {
        for (String winHandle : instance.getWindowHandles()) {
            instance.switchTo().window(winHandle);
        }
    }

    public static void switchToOriginalWindow() {
        String handle = instance.getWindowHandle();
        if (windowHandle == handle) return;
        instance.close();
        instance.switchTo().window(windowHandle);
    }
}


