package com.aniruddhc.xPlod.ui.adapters.list;

import static com.aniruddhc.xPlod.Constants.TYPE_ARTIST;
import android.content.Context;
import android.database.Cursor;
import android.provider.BaseColumns;
import android.provider.MediaStore.MediaColumns;
import android.provider.MediaStore.Audio.AudioColumns;

import com.aniruddhc.xPlod.helpers.utils.MusicUtils;
import com.aniruddhc.xPlod.ui.adapters.base.ListViewAdapter;

public class ArtistListAdapter extends ListViewAdapter {

	public ArtistListAdapter(Context context, int layout, Cursor c,	String[] from, int[] to, int flags) {
		super(context, layout, c, from, to, flags);
	}

	@Override
	public void setupViewData(Cursor mCursor) {
    	mLineOneText = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaColumns.TITLE));    	
    	mLineTwoText = mCursor.getString(mCursor.getColumnIndexOrThrow(AudioColumns.ALBUM));    	
        mImageData = new String[]{ mLineTwoText };        
        mPlayingId = MusicUtils.getCurrentAudioId();
        mCurrentId = mCursor.getLong(mCursor.getColumnIndexOrThrow(BaseColumns._ID));
        mListType = TYPE_ARTIST;
	}
}
