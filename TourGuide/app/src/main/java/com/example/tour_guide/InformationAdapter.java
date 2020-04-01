package com.example.tour_guide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class InformationAdapter extends ArrayAdapter<Information>
{
    /** Resource ID for the background color this list of information*/
    private int mColorResourceId;

    /**
     * @param context The current context. Used to inflate the layout file.
     * @param information A list of Information objects to display in a list.
     */
    public InformationAdapter(Context context, ArrayList<Information> information, int colorResourceId)
    {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // The second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter isn't going to use
        // this second argument, so it can be any value. Here, we used 0.
        super(context, 0, information);
        mColorResourceId = colorResourceId;
    }

    /**
     * @param position The AdapterView position that is requesting a view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Checks is the existing view is being reused, otherwise inflate the view.
        View listItemView = convertView;
        if (listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Information} object and located at this position in the list.
        Information currentInformation = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name_text_view.
        TextView nameTextView = listItemView.findViewById(R.id.name_text_view);
        // Get the name from the current Information object and set this text on the nameTextView.
        nameTextView.setText(currentInformation.getmName());

        // Find the TextView in the list_item.xml layout with the ID location_text_view.
        TextView locationTextView = listItemView.findViewById(R.id.location_text_view);
        // Get the location from the current Information object and set this text on the locationTextView.
        locationTextView.setText(currentInformation.getmLocation());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = listItemView.findViewById(R.id.image);


        if (currentInformation.hasImage())
        {
            // Set the ImageView to the image resource specified in the current Information.
            imageView.setImageResource(currentInformation.getmImageResourceId());

            // Make sure the views is visible.
            imageView.setVisibility(View.VISIBLE);
        }
        else
        {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the the comer for the list item
        View textContainer = listItemView.findViewById(R.id.container);
        // Find the color that the resource ID maps
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container view
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that i can be shown in the ListView.
        return listItemView;
    }
}
