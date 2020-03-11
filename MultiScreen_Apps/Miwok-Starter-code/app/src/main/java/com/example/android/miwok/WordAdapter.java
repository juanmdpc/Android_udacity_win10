package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class WordAdapter extends ArrayAdapter<Word>
{
    /**
     *
     * @param context The current context. Used to inflate the layout file.
     * @param words A List of Word objects to display in a list.
     */
    public WordAdapter(Activity context, ArrayList<Word> words)
    {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
    }

    /**
     * Provides a view for an AdapterView (e.g. ListView, GridView, etc)
     *
     * @param position The AdapterView position that is requesting a view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Checks if the existing views is being reused, otherwise inflate the view.
        View listItemView = convertView;
        if (listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //Get the {@link Word} object requested and located at this position in the list.
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miworkWord.
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwork_text_view);
        // Get the Miwok Translation from the current Word object and set this text on the miwokTextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID englishWord.
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the Default Translation from the current Word object and set this text on the defaultTextView
        englishTextView.setText(currentWord.getDefaultTranslation());

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in the ListView.
        return listItemView;
    }
}
