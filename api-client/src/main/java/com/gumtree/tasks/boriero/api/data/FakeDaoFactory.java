package com.gumtree.tasks.boriero.api.data;

/**
 * @author Andrea Boriero <dreborier@gmail.com>
 */
public class FakeDaoFactory implements DaoFactory {

    @Override
    public AdDao adDao() {
        return new FakeAdDao();
    }
}
