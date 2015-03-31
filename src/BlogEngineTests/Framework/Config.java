package BlogEngineTests.Framework;

public class Config {

    private static String login;
    private static String pass;
    private static String baseAddress;

    public static String getLogin() {
        return "admin";
    }

    public static String getPass() {
        return "admin";
    }

    public static String getBaseAddress() {
        return "http://localhost:63129/";
    }
}
