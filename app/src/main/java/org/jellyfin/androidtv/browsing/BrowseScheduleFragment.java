package org.jellyfin.androidtv.browsing;

import org.jellyfin.androidtv.livetv.TvManager;
import org.jellyfin.androidtv.presentation.CardPresenter;

import org.jellyfin.apiclient.interaction.Response;
import org.jellyfin.apiclient.model.livetv.TimerQuery;

/**
 * Created by Eric on 9/3/2015.
 */
public class BrowseScheduleFragment extends EnhancedBrowseFragment {

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    protected void setupQueries(final IRowLoader rowLoader) {
        TvManager.getScheduleRowsAsync(new TimerQuery(), new CardPresenter(true), mRowsAdapter, new Response<Integer>() {
            @Override
            public void onResponse(Integer response) {
                if (response == 0) mActivity.setTitle("No Scheduled Recordings");
            }
        });

    }


}
