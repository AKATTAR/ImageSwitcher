package com.example.imageswitcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import static com.example.imageswitcher.R.drawable.hydrangeas;

public class MainActivity extends AppCompatActivity {
    ImageSwitcher imageSwitcher;
    Button button,bt;
    int imageIds[] = {R.drawable.chrysanthemum, R.drawable.desert, hydrangeas, R.drawable.koala,R.drawable.jellyfish};
    int count = imageIds.length;
    int currentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSwitcher = findViewById(R.id.simpleImageSwitcher);
        button = findViewById(R.id.buttonNext);
        bt=findViewById(R.id.button2);
        //set the view factor of the imageswitcher that will creat imageview object when asked.
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                //set Scale type of ImageView to the file Center
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                //set the height and width of Imageveiw to fill paret
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });
        //Declare in  and out animation and load them using Animationutils class
        Animation in = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        Animation out=AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);
        //Set the animation type to Image Switcher
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                currentIndex++;
                if (currentIndex == count)
                    currentIndex = 0;
                imageSwitcher.setImageResource(imageIds[currentIndex]);

            }

        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentIndex--;


                imageSwitcher.setImageResource(imageIds[currentIndex]);
            }
        });
    }
}
