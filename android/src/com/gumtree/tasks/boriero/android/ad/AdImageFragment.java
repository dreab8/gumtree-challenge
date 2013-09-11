package com.gumtree.tasks.boriero.android.ad;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.actionbarsherlock.app.SherlockFragment;
import com.gumtree.tasks.boriero.android.R;

/**
 * @author Andrea Boriero <dreborier@gmail.com>
 */
public class AdImageFragment extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate( R.layout.fragment_ad_image, container, false );
    }

    public void setImage(Drawable image) {
        ImageView imageView = (ImageView) getView().findViewById( R.id.ad_image );
        imageView.setImageDrawable( image );
    }
}
