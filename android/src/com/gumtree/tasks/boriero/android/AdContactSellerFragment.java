package com.gumtree.tasks.boriero.android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

/**
 * @author Andrea Boriero <dreborier@gmail.com>
 */
public class AdContactSellerFragment extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate( R.layout.fragment_ad_contact_seller, container, false );
    }
}
