package com.gumtree.tasks.boriero.android.ad;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.widget.ShareActionProvider;
import com.gumtree.tasks.boriero.android.R;
import com.gumtree.tasks.boriero.api.ad.Ad;
import com.manuelpeinado.fadingactionbar.FadingActionBarHelper;

/**
 * @author Andrea Boriero <dreborier@gmail.com>
 */
public class AdDetailsActivity extends SherlockFragmentActivity implements LoaderManager.LoaderCallbacks<Ad> {

    public static final String UID = "ad";

    private ShareActionProvider shareActionProvider;

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

    @Override
    public Loader<Ad> onCreateLoader(int i, Bundle bundle) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onLoadFinished(Loader<Ad> adLoader, Ad ad) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onLoaderReset(Loader<Ad> adLoader) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
