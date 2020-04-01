package com.example.tour_guide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MuseumsActivity extends AppCompatActivity
{
    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener()
    {
        @Override
        public void onCompletion(MediaPlayer mp)
        {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener()
            {
                @Override
                public void onAudioFocusChange(int focusChange)
                {
                    if (focusChange == AudioManager.AUDIOFOCUS_GAIN)
                    {
                        // The AUDIOFOCUS_GAIN case means we have regained focus and can
                        // resume playback.
                        mMediaPlayer.start();
                    }
                    else if (focusChange == AudioManager.AUDIOFOCUS_LOSS)
                    {
                        // THE AUDIOFOCUS_LOSS case means we've lost audio and
                        // stop playback and cleanup resources.
                        releaseMediaPlayer();
                    }
                    else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                                focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
                    {
                        // The AUDIOFOCUS_LOSS_TRANSIENT case that we've lost audio focus
                        // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case
                        // means that our app is allowed continue playing sound but at a lowe volume.
                        // We'll treat both cases the same way because our app is playing short files.

                        // Pause playback and reset player to the start of the file. That way, We
                        // play the word from the beginning when we resume playback.
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    }
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_list);

        // Create and set up the {@link AudioManager} to request audio focus.
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // Create a list of Information objects
        final ArrayList<Information> informations = new ArrayList<>();

        informations.add(new Information("Arte Italiano","Av. Garcilaso 153", R.drawable.museo_arte_italiano, R.raw.museo_arte_italiano));
        informations.add(new Information("Arte de Lima","Av. Rivaguero 443",R.drawable.museo_arte_lima, R.raw.museo_arte_lima));
        informations.add(new Information("Casa de la Gastronomia Peruana","Av. Los Cordales 512",R.drawable.museo_casa_gastronomia_peruana, R.raw.museo_casa_gastronomia_peruana));
        informations.add(new Information("LUM","Av. Miguel Grau 124",R.drawable.museo_lum, R.raw.museo_lum));
        informations.add(new Information("Arqueologia, Antropologia e Historia Peruana","Av. Manuel Olguin 233",R.drawable.museo_nacional_arqueologa_antropologa_historia_peru, R.raw.museo_nacional_arqueologa_antropologa_historia_per));
        informations.add(new Information("Cultura Peruana","Av. Perales 587",R.drawable.museo_nacional_cultura_peruana, R.raw.museo_nacional_cultura_peruana));
        informations.add(new Information("Sitio Arturo Jimenez Borja","Av. Los Girasoles 229",R.drawable.museo_sitio_arturo_jimnez_borja, R.raw.museo_sitio_arturo_jimnez_borja));
        informations.add(new Information("Sitio de Huaca Pucllana","Av. El Muro 574",R.drawable.museo_sitio_huaca_pucllana, R.raw.museo_sitio_huaca_pucllana));
        informations.add(new Information("Sitio de Huallamarca","Av. Panama 149",R.drawable.museo_sitio_huallamarca, R.raw.museo_sitio_huallamarca));
        informations.add(new Information("Sitio de Pachacamac","Av. Los Peregrinos 554",R.drawable.museo_sitio_pachacamac, R.raw.museo_sitio_pachacamac));

        // Create an {@link InformationAdapter}, whose data source is a list of {@link Information}s.
        // The adapter know hows to create list items for each item in the list.
        InformationAdapter adapter =
                new InformationAdapter(this, informations, R.color.category_museums);

        // Find the {@ListView} object in the view hierarchy of the {@link Activity}.
        // The should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Information} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                // Release the media player if it currently exists because we are about to
                // play different sound file.
                releaseMediaPlayer();

                // Get the {@link Information} object at the given position the user clicked on
                Information information = informations.get(position);

                // Request audio focus so in order to play the audio file. The app need to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_REQUEST_GRANTED
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request temporarily focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                {
                    // We have a audio focus now

                    // Create and set up the {@link MediaPlayer} for the audio resource associated
                    // with the current Information object.
                    mMediaPlayer = MediaPlayer.create(MuseumsActivity.this, information.getmAudioResourceId());

                    // Start the audio file.
                    mMediaPlayer.start();

                    // Set up listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.
                    mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
                }
            }
        });
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    public void releaseMediaPlayer()
    {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null)
        {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // isn't configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't gey anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
