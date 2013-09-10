package com.gumtree.tasks.boriero.android;

import android.app.Application;

import com.gumtree.tasks.boriero.api.data.AdDao;
import com.gumtree.tasks.boriero.api.data.DaoFactory;
import com.gumtree.tasks.boriero.api.data.FakeDaoFactory;

/**
 * @author Andrea Boriero <dreborier@gmail.com>
 */
public class Gumtree extends Application {

    private static DaoFactory daoFactory;

    @Override
    public void onCreate() {
        super.onCreate();
        daoFactory = new FakeDaoFactory();
    }

    public static final AdDao getAdDao() {
        return daoFactory.adDao();
    }
}
