package com.gumtree.tasks.boriero.android.ad;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.gumtree.tasks.boriero.android.R;
import com.gumtree.tasks.boriero.api.ad.Ad;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Andrea Boriero <dreborier@gmail.com>
 */
public class AdImageFragment extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate( R.layout.fragment_ad_image, container, false );
    }

    public void setAd(Ad ad) {
        setImage( ad.getImage() );
        setPrice( ad.getPrice() );
    }

    private void setPrice(String price) {
        TextView priceView = (TextView) getView().findViewById( R.id.ad_price );
        priceView.setText( price );
    }

    private void setImage(String image) {
        ImageView imageView = (ImageView) getView().findViewById( R.id.ad_image );
        imageView.setImageDrawable( getDrawable( image ) );
    }

    private Drawable getDrawable(String image) {
        InputStream ims = null;
        try {
            ims = getActivity().getAssets().open( image );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Drawable.createFromStream( ims, null );
    }
}
