package com.gumtree.tasks.boriero.android.ad.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.gumtree.tasks.boriero.android.Gumtree;
import com.gumtree.tasks.boriero.api.ad.Ad;

/**
 * @author Andrea Boriero <dreborier@gmail.com>
 */
public class AdLoader extends AsyncTaskLoader<Ad> {

    private final String uid;

    public AdLoader(Context context, String uid) {
        super( context );
        this.uid = uid;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public Ad loadInBackground() {
        return Gumtree.getAdDao().getAd( uid );
    }
}
