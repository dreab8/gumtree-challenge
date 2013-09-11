package com.gumtree.tasks.boriero.api.data;

import com.gumtree.tasks.boriero.api.ad.Ad;

/**
 * @author Andrea Boriero <dreborier@gmail.com>
 */
public class FakeAdDao implements AdDao {

    @Override
    public Ad getAd(String uid) {
        Ad fakeAd = new Ad();
        fakeAd.setImage( "bike.JPG" );
        fakeAd.setEmailAddress( "dreborier@gmail.com" );
        fakeAd.setLocation( "Angel" );
        fakeAd.setTitle( "An amazing bike" );
        fakeAd.setPhoneNumber( "07333838383" );
        fakeAd.setPostedDate( "2012-11-21 10:12:10" );
        fakeAd.setDescription(
                "Raymond&Burg is dedicated to provide excellent quality bikes to commuters all"
                + " over the country. We keep all kind of bikes in our stock from student bikes to top of"
                + " the range. All bikes are fully serviced before we put them on sale so you are sure"
                + " that you are buying a serviced bike. \n"
                + "\n"
                + "For this period of fabulous summers we are selling selection of top quality steel road bike.brands"
                + " such as Koga, Alan, Concorde, Eddy Merckx, F. Moser and many more named frames. "
                + "Price start from 150£, each bike is unique and price will be charged according to the spec condition"
                + " and the brand. \n"
                + "\n"
                + "*WE ALSO HAVE LARGE SELECTION OF CITY/HYBRID/ AND CLASSIC BIKES \n"
                + "\n"
                + "\n"
                + "Test ride can be arranged through from Monday to Sunday. \n"
                + "\n"
                + "*Please note that we do not buy privately or trade in. " );
        return fakeAd;
    }
}
