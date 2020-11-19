package com.jdbc;

import java.sql.Statement;
import java.util.Locale;

public class VWZDao {
    private DbController dbctrl;
    private Statement statement;

    //DefaultDAO
    public void init() throws Exception {
        if (dbctrl == null) {
            dbctrl = DbController.getInstance();
        }
        Locale.setDefault(Locale.US);
        statement = dbctrl.getConnection().createStatement();
    }

    public void closeConnection() {
        dbctrl.closeConnection();
    }
}
