package eu.indiewalkabout.simplepreferencestoring;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    private final static String TAG = SecondActivity.class.getSimpleName();

    private static int first = 0, second = 0;


    // SharedPreference for storing user location
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        first++;
        second++;


        // init shared preferences
        sharedPreferences = this.getSharedPreferences(getString(R.string.shared_pref_file),Context.MODE_PRIVATE);

        // save coordinates in shared preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.first),  Integer.toString(first));
        editor.putString(getString(R.string.second), Integer.toString(second));
        editor.apply();


        String first =  sharedPreferences.getString(getString(R.string.first),"none");
        String second = sharedPreferences.getString(getString(R.string.second),"none");

        Log.i(TAG, "SecondActivity test: first : "+first+" second : "+second);

    }
}
