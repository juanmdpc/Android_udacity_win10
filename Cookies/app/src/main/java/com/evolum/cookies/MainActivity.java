package com.evolum.cookies;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.evolum.cookies.R;


public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the cookie should be eaten.
     */
    public void eatCookie(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView cookie_image_view = findViewById(R.id.android_cookie_image_view);
        cookie_image_view.setImageResource(R.drawable.after_cookie);

        // TODO: Find a reference to the TextView in the layout. Change the text.
        TextView status_text_view = findViewById(R.id.status_text_view);
        status_text_view.setText("I'm so full");
    }
}
