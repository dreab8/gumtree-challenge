package com.gumtree.tasks.boriero.android.ad;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.Window;
import com.gumtree.tasks.boriero.android.R;
import com.gumtree.tasks.boriero.android.ad.loader.AdLoader;
import com.gumtree.tasks.boriero.api.ad.Ad;
import com.manuelpeinado.fadingactionbar.FadingActionBarHelper;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Andrea Boriero <dreborier@gmail.com>
 */
public class AdDetailsActivity extends SherlockFragmentActivity
        implements LoaderManager.LoaderCallbacks<Ad> {

    public static final String UID = "ad";

    private Ad ad;

    public static final void start(Context context, String uid) {
        Intent i = new Intent( context, AdDetailsActivity.class );
        i.putExtra( UID, uid );
        context.startActivity( i );
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        requestWindowFeature( Window.FEATURE_ACTION_BAR_OVERLAY );
        getSupportActionBar().setDisplayOptions( ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_HOME );
        FadingActionBarHelper helper = new FadingActionBarHelper()
                .actionBarBackground( R.drawable.ab_solid_gumtree )
                .headerLayout( R.layout.layout_ad_image_header )
                .parallax( true )
                .contentLayout( R.layout.activity_ad_details );
        setContentView( helper.createView( this ) );
        helper.initActionBar( this );
        getSupportLoaderManager().initLoader( 0, savedInstanceState, this );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate( R.menu.activity_ad_details, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_call:
                call();
                break;
            case R.id.menu_email:
                mail();
                break;
            case R.id.menu_sms:
                sms();
                break;
        }
        return super.onOptionsItemSelected( item );
    }

    @Override
    public Loader<Ad> onCreateLoader(int i, Bundle bundle) {
        return new AdLoader( this, getUid() );
    }

    @Override
    public void onLoadFinished(Loader<Ad> adLoader, Ad ad) {
        this.ad = ad;
        getAdDetailsFragment().setAd( ad );
        InputStream ims = null;
        try {
            ims = getAssets().open( ad.getImage() );
        } catch (IOException e) {
            e.printStackTrace();
        }
        Drawable d = Drawable.createFromStream( ims, null );
        getAdImageFragment().setImage( d );
    }

    @Override
    public void onLoaderReset(Loader<Ad> adLoader) {
    }

    private AdImageFragment getAdImageFragment() {
        return (AdImageFragment) getFragment( R.id.fragment_ad_image );
    }

    private AdDetailsFragment getAdDetailsFragment() {
        return (AdDetailsFragment) getFragment( R.id.fragment_ad_details );
    }

    private Fragment getFragment(int fragmentId) {
        return getSupportFragmentManager().findFragmentById( fragmentId );
    }

    private String getUid() {
//        return getIntent().getExtras().getString( UID );
        return "1";
    }

    private void star(Ad toStar) {
    }

    private void sms() {
        showToast( "sending sms to" + ad.getEmailAddress() );
    }

    private void mail() {
        showToast( "sending mail to address" + ad.getEmailAddress() );
    }

    private void call() {
        showToast( "calling number " + ad.getPhoneNumber() );
    }

    private void showToast(String message) {
        Toast.makeText( getApplicationContext(), message, Toast.LENGTH_SHORT ).show();
    }
}
