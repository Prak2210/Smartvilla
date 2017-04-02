
package com.example.vasu_pc.trails;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.ArrayList;


public class Speech extends ActionBarActivity {

    protected static final int RESULT_SPEECH = 1;

    private ImageButton btnSpeak;
    private TextView txtText;
    public TextView viewText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech);
        String clientID = MqttClient.generateClientId();

        final MqttAndroidClient client = new MqttAndroidClient(this.getApplicationContext(), "tcp://iot.eclipse.org:1883", clientID);
        final MqttConnectOptions options = new MqttConnectOptions();



        txtText = (TextView) findViewById(R.id.textView6);
        viewText=(TextView)findViewById(R.id.textView7);

        btnSpeak = (ImageButton) findViewById(R.id.imageButton);

        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");

                try {
                    startActivityForResult(intent, RESULT_SPEECH);
                    txtText.setText("");
                } catch (ActivityNotFoundException a) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Opps! Your device doesn't support Speech to Text",
                            Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });
        try {
            IMqttToken token = client.connect(options);

            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected
                    //  Log.d(TAG, "onSuccess");

                    viewText.setText("Connection Successful", TextView.BufferType.EDITABLE);

                    try {
                        IMqttToken subToken=client.subscribe("temp1",1);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }
                }


                @Override
                public void onFailure(IMqttToken iMqttToken, Throwable throwable) {
                    viewText.setText("Failed", TextView.BufferType.EDITABLE);
                }
            });

        } catch (MqttException e) {
            e.printStackTrace();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }             */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RESULT_SPEECH: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> text = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    txtText.setText(text.get(0));
                    String a=txtText.getText().toString();
                    TextView t7=(TextView)findViewById(R.id.textView7);
                    t7.setText(a+"buddy cool");

                }
                break;
            }

        }
    }

}
