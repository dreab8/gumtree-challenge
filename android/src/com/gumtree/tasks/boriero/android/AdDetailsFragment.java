package com.gumtree.tasks.boriero.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

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
}
