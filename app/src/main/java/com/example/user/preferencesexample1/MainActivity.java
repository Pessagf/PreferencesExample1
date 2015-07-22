package com.example.user.preferencesexample1;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

  private EditText etPrefText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPrefText = (EditText)findViewById(R.id.editText1);
    }

    public void savePreferences(View v){
        String prefText = etPrefText.getText().toString();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("prefText", prefText);
        editor.apply();
    }

    public void loadPreferences(View v){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String prefText = prefs.getString("prefText","No preference text saved yet!");

        Toast.makeText(this,prefText,Toast.LENGTH_SHORT).show();
    }


}
