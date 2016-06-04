package com.tawil.brooks.ncaabracketgenerator;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

    //After the splashscreen is launched we launch the main activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    //Executed when something is clicked
    public void onClick(View v) {
        switch (v.getId()) {
            //If it is one of the main buttons
            //Generate a bracket
            case R.id.button1:
                Log.d("Brooks", "Button1 was clicked ");
                break;
            //View Saved Brackets
            case R.id.button2:
                Log.i("Brooks","Button2 was clicked");
                break;
            //Submit bracket?
            case R.id.button3:
                Log.d("Brooks", "Button3 was clicked ");
                break;
            //Settings
            case R.id.button4:
                Log.d("Brooks", "Button4 was clicked ");
                break;
            default:
                break;
        }
    }



}
