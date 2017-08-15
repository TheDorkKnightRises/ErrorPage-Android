package thedorkknightrises.errorpageapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import thedorkknightrises.errorpage.ErrorDialog;

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
            new ErrorDialog(this)
                    .setException(e)
                    .setReportButtonVisibility(true)
                    .setOnReportButtonClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(MainActivity.this, "Reported", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();
        }
    }
}
