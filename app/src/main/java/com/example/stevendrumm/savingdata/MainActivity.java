package com.example.stevendrumm.savingdata;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText password;
    TextView nameText;
    TextView passwordText;
    Button botonguardar;
    Button botonmostrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveValuePreference(MainActivity.this);

            }
        });
        name = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        nameText = (TextView) findViewById(R.id.textViewName);
        passwordText = (TextView) findViewById(R.id.textViewPassword);
        botonmostrar = (Button) findViewById(R.id.button2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void saveValuePreference(Context context) {
        SharedPreferences namePreferences = context.getSharedPreferences(String.valueOf(R.string.PREFS_KEY_NAME), MODE_PRIVATE);
        SharedPreferences passwordPreferences = context.getSharedPreferences(String.valueOf(R.string.PREFS_KEY_PASSWORD), MODE_PRIVATE);
        SharedPreferences.Editor editorName;
        SharedPreferences.Editor editorPassword;
        editorName = namePreferences.edit();
        editorPassword = passwordPreferences.edit();
        editorName.putString("name", name.getText().toString());
        editorPassword.putString("password", password.getText().toString());
        editorName.commit();
        editorPassword.commit();
    }



    public void  getValuePreference(View v) {
        SharedPreferences preferencesName = getSharedPreferences(String.valueOf(R.string.PREFS_KEY_NAME), MODE_PRIVATE);
        SharedPreferences preferencesPassword = getSharedPreferences(String.valueOf(R.string.PREFS_KEY_PASSWORD), MODE_PRIVATE);
        nameText.setText(preferencesName.getString("name", ""));
        passwordText.setText(preferencesPassword.getString("password", ""));
    }



}
