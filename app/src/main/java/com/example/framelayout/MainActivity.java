package com.example.framelayout;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int imageID_index = 0;
    public void seeTheAvengersCharacter(View view){
        TextView displayMessage = findViewById(R.id.displayMessage);
        displayMessage.setVisibility(View.INVISIBLE);

        //display images for 2 seconds in an animation

        //store all the IDs
        final int[] imageIDs = {R.drawable.antman, R.drawable.hulk3, R.drawable.iron1, R.drawable.ultron, R.drawable.blackpanther, R.drawable.thanos, R.drawable.hawkeye,
                R.drawable.cap};

        final ImageView imageHolder = findViewById(R.id.imageHolder);
        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageHolder.setImageResource(imageIDs[imageID_index]);

                //animate the image every 2 seconds ~ 2000 milliseconds
                imageHolder.animate().alpha(1);

                //jump to the next image ID index
                ++imageID_index;
                handler.postDelayed(this, 2000);

                //stop the handler once all the images are displayed
                //set the imageID index back to zero in case the method gets called again
                if(imageID_index == imageIDs.length){
                    handler.removeCallbacksAndMessages(null);
                    imageID_index = 0;

                }
            }
        }, 2000);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
