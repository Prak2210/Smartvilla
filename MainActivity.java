package com.example.vasu_pc.trails;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity implements MqttCallback {

    NotificationCompat.Builder notification=new NotificationCompat.Builder(this);


    private static int uID=2210;
    private GoogleApiClient client2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notification.setAutoCancel(true);
        String clientID = MqttClient.generateClientId();

        final MqttAndroidClient client = new MqttAndroidClient(this.getApplicationContext(), "tcp://iot.eclipse.org:1883", clientID);
        final MqttConnectOptions options = new MqttConnectOptions();
        client.setCallback(this);
        final TextView viewText = (TextView) findViewById(R.id.textView);





        final Button button = (Button) findViewById(R.id.button);
        final Button button3 = (Button) findViewById(R.id.button3);
        final Button button7 = (Button) findViewById(R.id.button7);
        final Button button8 = (Button) findViewById(R.id.button8);
        final Button button9 = (Button) findViewById(R.id.button9);
        final Button button4 = (Button) findViewById(R.id.button4);
        final Button button5 = (Button) findViewById(R.id.button5);
        final Button button6 = (Button) findViewById(R.id.button6);


        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String topic = "light";
                    String payload = "on";
                    byte[] encodedPayload = new byte[0];
                    try {
                        encodedPayload = payload.getBytes("UTF-8");
                        MqttMessage message = new MqttMessage(encodedPayload);
                        message.setRetained(true);
                        client.publish(topic, message);
                    } catch (UnsupportedEncodingException | MqttException e) {
                        e.printStackTrace();
                    }
                }
            });
            final Button button2 = (Button) findViewById(R.id.button2);
            if (button2 != null) {
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String topic = "light";
                        String payload = "off";
                        byte[] encodedPayload = new byte[0];
                        try {
                            encodedPayload = payload.getBytes("UTF-8");
                            MqttMessage message = new MqttMessage(encodedPayload);
                            message.setRetained(true);
                            client.publish(topic, message);
                        } catch (UnsupportedEncodingException | MqttException e) {
                            e.printStackTrace();
                        }
                    }
                });
                options.setKeepAliveInterval(6000);
            }
            if (button3 != null) {
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String topic = "fan";
                        String payload = "fon";
                        byte[] encodedPayload = new byte[0];
                        try {
                            encodedPayload = payload.getBytes("UTF-8");
                            MqttMessage message = new MqttMessage(encodedPayload);
                            message.setRetained(true);
                            client.publish(topic, message);
                        } catch (UnsupportedEncodingException | MqttException e) {
                            e.printStackTrace();
                        }
                    }
                });
                options.setKeepAliveInterval(6000);
            }
            if (button4 != null) {
                button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String topic = "fan";
                        String payload = "foff";
                        byte[] encodedPayload = new byte[0];
                        try {
                            encodedPayload = payload.getBytes("UTF-8");
                            MqttMessage message = new MqttMessage(encodedPayload);
                            message.setRetained(true);
                            client.publish(topic, message);
                        } catch (UnsupportedEncodingException | MqttException e) {
                            e.printStackTrace();
                        }
                    }
                });
                options.setKeepAliveInterval(6000);
            }
            if (button5 != null) {
                button5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String topic = "temp";
                        String payload = "beam";
                        byte[] encodedPayload = new byte[0];
                        try {
                            encodedPayload = payload.getBytes("UTF-8");
                            MqttMessage message = new MqttMessage(encodedPayload);
                            message.setRetained(true);
                            client.publish(topic, message);
                        } catch (UnsupportedEncodingException | MqttException e) {
                            e.printStackTrace();
                        }
                    }
                });
                options.setKeepAliveInterval(6000);
            }
            if (button6 != null) {
                button6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String topic = "temp";
                        String payload = "beam1";
                        byte[] encodedPayload = new byte[0];
                        try {
                            encodedPayload = payload.getBytes("UTF-8");
                            MqttMessage message = new MqttMessage(encodedPayload);
                            message.setRetained(true);
                            client.publish(topic, message);
                        } catch (UnsupportedEncodingException | MqttException e) {
                            e.printStackTrace();
                        }
                    }
                });
                options.setKeepAliveInterval(6000);
            }
            if (button7 != null) {
                button7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String topic = "fan";
                        String payload = "f10";
                        byte[] encodedPayload = new byte[0];
                        try {
                            encodedPayload = payload.getBytes("UTF-8");
                            MqttMessage message = new MqttMessage(encodedPayload);
                            message.setRetained(true);
                            client.publish(topic, message);
                        } catch (UnsupportedEncodingException | MqttException e) {
                            e.printStackTrace();
                        }
                    }
                });
                options.setKeepAliveInterval(6000);
            }
            if (button8 != null) {
                button8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String topic = "fan";
                        String payload = "f40";
                        byte[] encodedPayload = new byte[0];
                        try {
                            encodedPayload = payload.getBytes("UTF-8");
                            MqttMessage message = new MqttMessage(encodedPayload);
                            message.setRetained(true);
                            client.publish(topic, message);
                        } catch (UnsupportedEncodingException | MqttException e) {
                            e.printStackTrace();
                        }
                    }
                });
                options.setKeepAliveInterval(6000);
            }
            if (button9 != null) {
                button9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String topic = "fan";
                        String payload = "f70";
                        byte[] encodedPayload = new byte[0];
                        try {
                            encodedPayload = payload.getBytes("UTF-8");
                            MqttMessage message = new MqttMessage(encodedPayload);
                            message.setRetained(true);
                            client.publish(topic, message);
                        } catch (UnsupportedEncodingException | MqttException e) {
                            e.printStackTrace();
                        }
                    }
                });
                options.setKeepAliveInterval(6000);
            }



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

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
public void onClick10(View v)
{
    final Intent intent=new Intent(this,Streaming.class);
    startActivity(intent);
}
    public void onClick1(View v)
    {
        final Intent intent=new Intent(this,Speech.class);
        startActivity(intent);
    }
    public void onClick11(View v)
    {
        notification.setSmallIcon(R.drawable.sh3);
        notification.setTicker("smartvilla");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("hello! smart buoy");
        notification.setContentText("blash blash blah");
        Uri sou= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        notification.setSound(sou);

        final Intent intent=new Intent(this,Streaming.class);
        PendingIntent pi=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pi);

        NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uID,notification.build());
    }

    @Override
    public void onStart() {
        super.onStart();

        client2.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.vasu_pc.trails/http/host/path")
        );
        AppIndex.AppIndexApi.start(client2, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.vasu_pc.trails/http/host/path")
        );
        AppIndex.AppIndexApi.end(client2, viewAction);
        client2.disconnect();
    }

    @Override
    public void connectionLost(Throwable throwable) {

    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {

        final TextView t6 = (TextView) findViewById(R.id.t6);
        String msg=mqttMessage.toString();
        t6.setText(msg);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}

