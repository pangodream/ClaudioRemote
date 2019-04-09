package com.pangodream.www.claudioremote;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;


public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";
    String hostClaudio = "0.0.0.0";
    int portClaudio = 1234;
    boolean commError;
    remConfigClient myClient;
    String targetId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loadLocalConfiguration();
        if(hostClaudio.equals("0.0.0.0")){
            loadConfigurationActivity();
        }else{
            Log.d(TAG, "Configured IP " + hostClaudio);
            boolean loaded = loadRemoteConfiguration();
        }

        final TextView ALARHO = findViewById(R.id.ALARHO);
        final TextView ALARMI = findViewById(R.id.ALARMI);
        final TextView DOALAR = findViewById(R.id.DOALAR);
        final TextView ONALAR = findViewById(R.id.ONALAR);
        final TextView SNZMIN = findViewById(R.id.SNZMIN);
        final TextView ALBEEP = findViewById(R.id.ALBEEP);
        final TextView MINLUX = findViewById(R.id.MINLUX);
        final TextView MAXLUX = findViewById(R.id.MAXLUX);
        final TextView MINBRG = findViewById(R.id.MINBRG);
        final TextView BOOTWT = findViewById(R.id.BOOTWT);
        final TextView TOUCHR = findViewById(R.id.TOUCHR);
        final TextView THTCHR = findViewById(R.id.THTCHR);
        final TextView THTCHM = findViewById(R.id.THTCHM);
        final TextView THTCHL = findViewById(R.id.THTCHL);
        final TextView LTCHTH = findViewById(R.id.LTCHTH);

        ALARHO.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    myClient = new remConfigClient("SETALARHO" + ALARHO.getText(), "ALARHO"); myClient.execute();
                }
            }
        });
        ALARMI.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    myClient = new remConfigClient("SETALARMI" + ALARMI.getText(), "ALARMI"); myClient.execute();
                }
            }
        });
        DOALAR.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    myClient = new remConfigClient("SETDOALAR" + DOALAR.getText(), "DOALAR"); myClient.execute();
                }
            }
        });
        ONALAR.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    myClient = new remConfigClient("SETONALAR" + ONALAR.getText(), "ONALAR"); myClient.execute();
                }
            }
        });
        SNZMIN.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    myClient = new remConfigClient("SETSNZMIN" + SNZMIN.getText(), "SNZMIN"); myClient.execute();
                }
            }
        });
        ALBEEP.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    myClient = new remConfigClient("SETALBEEP" + ALBEEP.getText(), "ALBEEP"); myClient.execute();
                }
            }
        });
        MINLUX.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    myClient = new remConfigClient("SETMINLUX" + MINLUX.getText(), "MINLUX"); myClient.execute();
                }
            }
        });
        MAXLUX.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    myClient = new remConfigClient("SETMAXLUX" + MAXLUX.getText(), "MAXLUX"); myClient.execute();
                }
            }
        });
        MINBRG.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    myClient = new remConfigClient("SETMINBRG" + MINBRG.getText(), "MINBRG"); myClient.execute();
                }
            }
        });
        BOOTWT.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    myClient = new remConfigClient("SETBOOTWT" + BOOTWT.getText(), "BOOTWT"); myClient.execute();
                }
            }
        });
        TOUCHR.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    myClient = new remConfigClient("SETTOUCHR" + TOUCHR.getText(), "TOUCHR"); myClient.execute();
                }
            }
        });
        THTCHR.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    myClient = new remConfigClient("SETTHTCHR" + THTCHR.getText(), "THTCHR"); myClient.execute();
                }
            }
        });
        THTCHM.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    myClient = new remConfigClient("SETTHTCHM" + THTCHM.getText(), "THTCHM"); myClient.execute();
                }
            }
        });
        THTCHL.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    myClient = new remConfigClient("SETTHTCHL" + THTCHL.getText(), "THTCHL"); myClient.execute();
                }
            }
        });
        LTCHTH.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    myClient = new remConfigClient("SETLTCHTH" + LTCHTH.getText(), "LTCHTH"); myClient.execute();
                }
            }
        });
    }

    void loadConfigurationActivity(){
        Intent intent = new Intent(MainActivity.this, ConfigurationActivity.class);
        startActivityForResult(intent, 1);
    }
    private void loadLocalConfiguration(){
        //Loads stored configuration
        ConfigStore confStore = new ConfigStore(this);
        //Get host IP
        hostClaudio = confStore.getHostIP();
        //Get host port
        portClaudio = Integer.parseInt(confStore.getHostPort());
    }
    private boolean loadRemoteConfiguration(){
        boolean result = false;
        //Loads all items from remote Claudio system
        try{
            myClient = new remConfigClient("ALL", ""); myClient.execute();
            result = true;
        }catch(Exception e){
            Log.d(TAG, "Error connecting remote Claudio system");
        }
        return result;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Configuration
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                loadLocalConfiguration();
                loadRemoteConfiguration();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                loadRemoteConfiguration();
            }
        }
    }
    public class remConfigClient extends AsyncTask<Void, Void, String> {
        String TAG = "RemConfigClient";
        String command;
        String response = "";

        remConfigClient(String cmd, String tgtId) {
            command = cmd + "\n";
            targetId = tgtId;
        }

        @Override
        protected String doInBackground(Void... arg0) {
            Socket echoSocket = null;
            DataOutputStream out = null;
            DataInputStream in = null;
            StringBuilder sb = new StringBuilder(1024);

            try {
                commError = false;
                echoSocket = new Socket(hostClaudio, portClaudio);
                out = new DataOutputStream(echoSocket.getOutputStream());
                in = new DataInputStream(echoSocket.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                if (echoSocket != null && out != null && in != null) {
                    try {
                        byte[] bytes = command.getBytes(StandardCharsets.UTF_8);
                        out.write(bytes);
                        out.flush();
                        //We expect receiving just one line to return from Claudio
                        String line = br.readLine();
                        response = line;
                        out.close();
                        in.close();
                        echoSocket.close();
                    } catch (IOException e) {
                        Log.d(TAG, "I/O failed on the connection to: server");
                    }
                }
            } catch (UnknownHostException e) {
                commError = true;
                Log.d(TAG, "Couldn't open the socket");
            } catch (IOException e) {
                commError = true;
                Log.d(TAG, "Couldn't get to server");
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            if(commError){
                Log.d(TAG, "onPostExecute - Communication error");
                loadConfigurationActivity();
            }else{
                Log.d(TAG, response);
                String commandType = command.substring(0,3);
                Log.d(TAG, commandType);
                //GET
                if(commandType.equals("GET")){
                    int resID = getResources().getIdentifier(targetId, "id", getPackageName());
                    TextView target = findViewById(resID);
                    target.setText(response);
                    //SET
                }else if(commandType.equals("SET")){
                    int resID = getResources().getIdentifier(targetId, "id", getPackageName());
                    TextView target = findViewById(resID);
                    //ALL
                }else if(commandType.equals("ALL")){
                    String[] items = response.split(";");
                    TextView target;
                    target = findViewById(R.id.ALARHO); target.setText(getItemValue(items, "ALARHO"));
                    target = findViewById(R.id.ALARMI); target.setText(getItemValue(items, "ALARMI"));
                    target = findViewById(R.id.DOALAR); target.setText(getItemValue(items, "DOALAR"));
                    target = findViewById(R.id.ONALAR); target.setText(getItemValue(items, "ONALAR"));
                    target = findViewById(R.id.SNZMIN); target.setText(getItemValue(items, "SNZMIN"));
                    target = findViewById(R.id.ALBEEP); target.setText(getItemValue(items, "ALBEEP"));
                    target = findViewById(R.id.MINLUX); target.setText(getItemValue(items, "MINLUX"));
                    target = findViewById(R.id.MAXLUX); target.setText(getItemValue(items, "MAXLUX"));
                    target = findViewById(R.id.MINBRG); target.setText(getItemValue(items, "MINBRG"));
                    target = findViewById(R.id.BOOTWT); target.setText(getItemValue(items, "BOOTWT"));
                    target = findViewById(R.id.TOUCHR); target.setText(getItemValue(items, "TOUCHR"));
                    target = findViewById(R.id.THTCHR); target.setText(getItemValue(items, "THTCHR"));
                    target = findViewById(R.id.THTCHM); target.setText(getItemValue(items, "THTCHM"));
                    target = findViewById(R.id.THTCHL); target.setText(getItemValue(items, "THTCHL"));
                    target = findViewById(R.id.LTCHTH); target.setText(getItemValue(items, "LTCHTH"));
                }
            }
            super.onPostExecute(result);
        }
        private String getItemValue(String[] items, String itemName){
            String value = "";
            for(String s: items){
                if(s.substring(0,6).equals(itemName)){
                    value = s.substring(6);
                    break;
                }
            }
            return value;
        }
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
            loadConfigurationActivity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
