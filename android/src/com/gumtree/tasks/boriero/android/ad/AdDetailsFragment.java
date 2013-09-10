package com.gumtree.tasks.boriero.android.ad;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.gumtree.tasks.boriero.android.R;
import com.gumtree.tasks.boriero.api.ad.Ad;

/**
 * @author Andrea Boriero <dreborier@gmail.com>
 */
public class AdDetailsFragment extends SherlockFragment {

    private static final String AD = "ad";

    @Override
    public void onAttach(Activity activity) {
        super.onAttach( activity );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate( R.layout.fragment_ad_details, container, false );
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );
    }

    public void setAd(Ad ad) {
        TextView description = (TextView) getView().findViewById( R.id.ad_description );
        description.setText( ad.getDescription() );
    }
}
