package com.gs.fefec.web.security;




import java.security.Permission;

public final class MySecurityManager extends SecurityManager {
    @Override
    public void checkPermission(Permission perm) {
        return;
    }
}
