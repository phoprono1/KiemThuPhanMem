package testing.logout;

import base.BaseDriver;
import org.testng.annotations.Test;

public class Logout extends BaseDriver {
    String usernameStr = "admin";
    String passwordStr = "Admin123";

    @Test
    public void logout() {
        //Login Process
        ome.mySendKeys(ome.usernamePlc, usernameStr);
        ome.mySendKeys(ome.passwordPlc, passwordStr);
        ome.myClick(ome.inpatientWard);
        ome.myClick(ome.loginButton);
        //Logout Process
        ome.myClick(ome.logoutButton);

    }
}
