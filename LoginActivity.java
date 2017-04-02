package com.example.vasu_pc.trails;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A login screen that offers login via email/password.
 */


public class LoginActivity extends Activity {


    Button b1;
    EditText ed1, ed2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        final Intent intent = new Intent(this, MainActivity.class);
        b1 = (Button) findViewById(R.id.button5);
        //final String ed1s,ed2s;
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        // ed1s=ed1.getText().toString();
        //ed2s=ed2.getText().toString();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((ed1.getText().toString().equals("admin") &&ed2.getText().toString().equals("admin"))||(ed1.getText().toString().equals("sujata")&&ed2.getText().toString().equals("sujata"))||((ed1.getText().toString().equals("maitri")&&ed2.getText().toString().equals("maitri"))))
                {

                    Toast.makeText(getApplicationContext(), "Logging In...", Toast.LENGTH_SHORT).show();
                    // String message = ed1.getText().toString();
                    // intent.putExtra("Welcome", message);
                    startActivity(intent);
                }
                else {

                    Toast.makeText(getApplicationContext(), "Invalid User", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }

            }
        });
    }
}



/**
 * A dummy authentication store containing known user names and passwords.
 * TODO: remove after connecting to a real authentication system.
 */


/**
 * Keep track of the login task to ensure we can cancel it if requested.
 */


