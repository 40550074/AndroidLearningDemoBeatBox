package com.example.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUND_FOLDER = "sample_sounds";
    private AssetManager mAssert;

    private List<Sound> mSounds = new ArrayList<>();

    public BeatBox(Context context) {
        mAssert = context.getAssets();
        loadSounds();
    }

    public List<Sound> getSounds() {
        return mSounds;
    }

    private void loadSounds() {
        String[] soundNames;

        try {
            soundNames = mAssert.list(SOUND_FOLDER);
            Log.i(TAG, "Found" + soundNames.length + " sound");
        } catch (IOException ioe) {
            Log.e(TAG, "Could not list assets", ioe);
            return;
        }

        for (String fileName : soundNames) {
            String assetPath = SOUND_FOLDER + "/" + fileName;
            Sound sound = new Sound(assetPath);
            mSounds.add(sound);
        }
    }
}
