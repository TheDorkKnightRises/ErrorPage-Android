package thedorkknightrises.errorpageapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import thedorkknightrises.errorpage.ErrorActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        try {
            throw new Exception("Whoops, there was an Exception ");
        } catch (Exception e) {
            new ErrorActivity(this).setException(e).show();
        }
    }
}
