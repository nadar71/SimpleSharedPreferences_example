package eu.indiewalkabout.simplepreferencestoring;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private final static String TAG = MainActivity.class.getSimpleName();

    // SharedPreference for storing user location
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onResume() {
        super.onResume();

        // init shared preferences
        sharedPreferences = this.getSharedPreferences(getString(R.string.shared_pref_file),Context.MODE_PRIVATE);

        String first  = sharedPreferences.getString(getString(R.string.first),"none");
        String second = sharedPreferences.getString(getString(R.string.second),"none");

        Log.i(TAG, "MainActivity onResume: first : "+first+" second : "+second);

    }


    // ---------------------------------------------------------------------------------------------
    //                                          MENU STUFF
    // ---------------------------------------------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.second_activity:
                Intent settingsIntent = new Intent(this, SecondActivity.class);
                startActivity(settingsIntent);
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }




}
