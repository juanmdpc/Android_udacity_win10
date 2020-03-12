package com.example.android.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation, a Miwok transtralion, and an image for that word.
 */
public class Word
{

    private static final int NO_IMAGE_PROVIDED = -1;

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     *
     * @param defaultTranslation is the word in a language that the user
     * @param miwokTranslation is the word in the Miwok language.
     */
    public Word(String defaultTranslation, String miwokTranslation)
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    /**
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language.
     * @param imageResourceId is the drawable resource ID for the image associated with the word.
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId)
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokTranslation()
    {
        return mMiwokTranslation;
    }


    /**
     * Get the image resource ID of the word.
     */
    public Integer getmImageResourceId()
    {
        return mImageResourceId;
    }

    public boolean hasImage()
    {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
