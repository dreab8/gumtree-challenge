package com.gumtree.tasks.boriero.android.ad;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.actionbarsherlock.app.SherlockFragment;
import com.gumtree.tasks.boriero.android.R;
import com.gumtree.tasks.boriero.api.ad.Ad;

/**
 * @author Andrea Boriero <dreborier@gmail.com>
 */
public class AdDetailsFragment extends SherlockFragment {

    private static final String AD = "ad";

    private Ad ad;

    private final View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_share:
                    startActivity( createShareIntent() );
                    break;
                case R.id.btn_star:
                    setStarState( ((ToggleButton) view).isChecked() );
                    break;
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate( R.layout.fragment_ad_details, container, false );
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );
        restoreAdState( savedInstanceState );
        initClickListeners( view );
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState( outState );
        outState.putSerializable( AD, ad );
    }

    public void setAd(Ad ad) {
        setAdDescription( ad.getDescription() );
        setAdTime( ad.getDisplayDate() );
        setAdLocaiton( ad.getLocation() );
        setAdTitle( ad.getTitle() );
    }

    private void setAdTitle(String title) {
        setTextViewValue( R.id.ad_title, title );
    }

    private void setAdLocaiton(String location) {
        setTextViewValue( R.id.ad_location, location );
    }

    private void setAdTime(String displayDate) {
        setTextViewValue( R.id.ad_time, displayDate );
    }

    private void setAdDescription(String description) {
        setTextViewValue( R.id.ad_description, description );
    }

    private void setTextViewValue(int id, String text) {
        ((TextView) getView().findViewById( id )).setText( text );
    }

    private void restoreAdState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            ad = (Ad) savedInstanceState.getSerializable( AD );
        }
    }

    private void initClickListeners(View view) {
        addShareButtonListener( view );
        addStarButtonListener( view );
    }

    private void addStarButtonListener(View view) {
        view.findViewById( R.id.btn_star ).setOnClickListener( clickListener );
    }

    private void addShareButtonListener(View view) {
        view.findViewById( R.id.btn_share ).setOnClickListener( clickListener );
    }

    private void setStarState(boolean checked) {
        //To change body of created methods use File | Settings | File Templates.
    }

    private Intent createShareIntent() {
        Intent sendIntent = new Intent();
        sendIntent.setAction( Intent.ACTION_SEND );
        sendIntent.putExtra( Intent.EXTRA_TEXT, ad.getUrl() );
        sendIntent.setType( "text/plain" );
        return sendIntent;
    }
}
