package com.gumtree.tasks.boriero.android.ad;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.View;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.widget.ShareActionProvider;
import com.gumtree.tasks.boriero.android.R;
import com.gumtree.tasks.boriero.android.ad.loader.AdLoader;
import com.gumtree.tasks.boriero.api.ad.Ad;
import com.manuelpeinado.fadingactionbar.FadingActionBarHelper;

/**
 * @author Andrea Boriero <dreborier@gmail.com>
 */
public class AdDetailsActivity extends SherlockFragmentActivity
        implements LoaderManager.LoaderCallbacks<Ad>, AdStarringListener {

    public static final String UID = "ad";

    private ShareActionProvider shareActionProvider;
    private Ad ad;

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
        getSupportLoaderManager().initLoader( 0, savedInstanceState, this );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate( R.menu.activity_ad_details, menu );

        createShareActionProvideer( menu );

        return true;
    }

    @Override
    public Loader<Ad> onCreateLoader(int i, Bundle bundle) {
        return new AdLoader( this, getUid() );
    }

    @Override
    public void onLoadFinished(Loader<Ad> adLoader, Ad ad) {
        final AdDetailsFragment adDetailsFragment =
                (AdDetailsFragment) getSupportFragmentManager().findFragmentById( R.id.fragment_ad_details );
        this.ad = ad;
        adDetailsFragment.setAd( ad );
    }

    @Override
    public void onLoaderReset(Loader<Ad> adLoader) {
    }

    @Override
    public void onAdStarClick(View overflow) {
        overflow.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star( ad );
            }
        } );
    }

    private void createShareActionProvideer(Menu menu) {
        shareActionProvider = (ShareActionProvider) menu.findItem( R.id.menu_share ).getActionProvider();
        shareActionProvider.setShareHistoryFileName( ShareActionProvider.DEFAULT_SHARE_HISTORY_FILE_NAME );
        shareActionProvider.setShareIntent( createShareIntent() );
    }

    private Intent createShareIntent() {
        Intent sendIntent = new Intent();
        sendIntent.setAction( Intent.ACTION_SEND );
        sendIntent.putExtra( Intent.EXTRA_TEXT, "text to share" );
        sendIntent.setType( "text/plain" );

        return sendIntent;
    }

    private String getUid() {
//        return getIntent().getExtras().getString( UID );
        return "1";
    }

    private void star(Ad toStar) {
    }
}
