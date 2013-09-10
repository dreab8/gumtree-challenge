package com.gumtree.tasks.boriero.api.data;

import com.gumtree.tasks.boriero.api.ad.Ad;

/**
 * @author Andrea Boriero <dreborier@gmail.com>
 */
public interface AdDao {

    Ad getAd(String uid);
}
