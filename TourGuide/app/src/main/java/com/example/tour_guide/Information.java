package com.example.tour_guide;

/**
 * {@link Information} represents the information about each list item of a category.
 * It contains a name, a location, an audio file and an image for that information.
 */
public class Information
{
    private final int NO_IMAGE_PROVIDED = -1;

    private String mName;
    private String mLocation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int mAudioResourceId;

    /**
     *
     * @param mName is the information about the name of item.
     * @param mLocation is the information about the location of item.
     * @param mAudioResourceId is the media resource ID for the audio associated with the information.
     */
    public Information(String mName, String mLocation, int mAudioResourceId)
    {
        this.mName = mName;
        this.mLocation = mLocation;
        this.mAudioResourceId = mAudioResourceId;
    }

    /**
     *
     * @param mName is the information about the name of item.
     * @param mLocation is the information about the location of item.
     * @param mImageResourceId is the drawable resource ID for the image associated with the information.
     * @param mAudioResourceId is the media resource ID for the audio associated with the information.
     */
    public Information(String mName, String mLocation, int mImageResourceId, int mAudioResourceId)
    {
        this.mName = mName;
        this.mLocation = mLocation;
        this.mImageResourceId = mImageResourceId;
        this.mAudioResourceId = mAudioResourceId;
    }

    /**
     * @return the name about item of the category.
     */
    public String getmName()
    {
        return mName;
    }

    /**
     * @return the location about item of the category.
     */
    public String getmLocation()
    {
        return mLocation;
    }

    /**
     * @return the image resource ID about item of the category.
     */
    public int getmImageResourceId()
    {
        return mImageResourceId;
    }

    public boolean hasImage()
    {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * @return the audio resource ID about item of the category.     */
    public int getmAudioResourceId()
    {
        return mAudioResourceId;
    }
}

