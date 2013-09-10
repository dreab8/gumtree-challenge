package com.gumtree.tasks.boriero.android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.manuelpeinado.fadingactionbar.FadingActionBarHelper;

/**
 * @author Andrea Boriero <dreborier@gmail.com>
 */
public class AdDetailsActivity extends SherlockFragmentActivity
       {

    public static final String UID = "ad";

    public static final void start(Context context, String uid) {
        Intent i = new Intent( context, AdDetailsActivity.class );
        i.putExtra( UID, uid );
        context.startActivity( i );
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        getSupportActionBar().setDisplayOptions( ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_HOME );
        FadingActionBarHelper helper = new FadingActionBarHelper()
                .actionBarBackground( R.drawable.ab_solid_gumtree )
                .headerLayout( R.layout.layout_ad_image_header )
                .parallax( true )
                .contentLayout( R.layout.activity_ad_details );
        setContentView( helper.createView( this ) );
        helper.initActionBar( this );
    }
 
}
