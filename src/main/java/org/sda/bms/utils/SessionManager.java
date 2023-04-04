package org.sda.bms.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager extends AbstractSessionManager {

    private static final SessionManager INSTANCE = new SessionManager();

    private SessionManager() {
        // hide default constructor
    }

    public static SessionFactory getSessionFactory(){
        return INSTANCE.getSessionFactory("book_management_system");
    }

    public static void shutDown(){
        INSTANCE.shutdownSessionManager();
    }

    @Override
    protected void setAnnotatedClasses(Configuration configuration) {
        // do not forget to add a model here
    }
}
