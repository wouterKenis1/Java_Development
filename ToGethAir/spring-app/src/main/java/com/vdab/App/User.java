package com.vdab.App;

public class User {
    static private String url = "jdbc:mysql://localhost:3306/togethair?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static private String user = "root";
    static private String pass = "SnOtTe9BeL";

    static public String getUrl() {
        return url;
    }

    static public String getUser() {
        return user;
    }

    static public String getPass() {
        return pass;
    }
}
