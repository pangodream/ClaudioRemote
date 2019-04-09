package com.pangodream.www.claudioremote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfigurationActivity extends AppCompatActivity {
    ConfigStore confStore = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final TextView txtIP = (TextView) findViewById(R.id.txtIP);
        final TextView txtPort = (TextView) findViewById(R.id.txtPort);

        //Load stored configuration
        confStore = new ConfigStore(this);
        //Get host IP
        String hostIP = confStore.getHostIP();
        txtIP.setText(hostIP);
        //Get host port
        String hostPort = confStore.getHostPort();
        txtPort.setText(hostPort);


        Button btnOK = findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //Save host value
            String sIP = txtIP.getText().toString();
            confStore.setHostIP(sIP);
            //Save port value
            String sPort = txtPort.getText().toString();
            confStore.setHostPort(sPort);
            //Return to main activity
            Intent returnIntent = new Intent();
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
            }
        });
        Button btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //Return to main activity saving nothing
            Intent returnIntent = new Intent();
            setResult(Activity.RESULT_CANCELED, returnIntent);
            finish();
            }
        });
    }

}
