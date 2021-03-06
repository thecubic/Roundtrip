package com.gxwtech.rtdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.gxwtech.rtdemo.services.RoundtripService;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private static final String TAG = "MainActivity";

    int nRecentMessages = 50;
    List<String> msgList = new ArrayList<>();
    ArrayAdapter<String> adapter = null;

    // For receiving and displaying log messages from the Service thread
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intents.ROUNDTRIP_STATUS_MESSAGE)) {
                Log.d(TAG, "Received Roundtrip_Status_message");
                if (intent.hasExtra("messages")) {
                    ArrayList<String> newMsgList = intent.getStringArrayListExtra("messages");
                    Log.w(TAG, String.format("Found extra: %d messages", msgList.size()));
                    adapter.clear();
                    adapter.addAll(newMsgList);
                    adapter.notifyDataSetChanged();
                }
                if (intent.hasExtra(Intents.ROUNDTRIP_STATUS_MESSAGE_STRING)) {
                    String s = intent.getStringExtra(Intents.ROUNDTRIP_STATUS_MESSAGE_STRING);
                    Log.w(TAG, "Found extra: one string:" + s);
                }

            } else if (intent.getAction().equals(Intents.ROUNDTRIP_TASK_RESPONSE)) {
                // pump settings viewer used to be here.
                // I'm leaving it as an example of how to receive task_response
                    /*
                    if (intent.hasExtra("name")) {
                        String name = intent.getStringExtra("name");
                        if (intent.hasExtra(name)) {
                            if (intent.getAction() == Constants.ParcelName.PumpSettingsParcelName) {
                                Bundle data = intent.getExtras();
                                PumpSettingsParcel p = data.getParcelable(name);
                                // do something with it.
                                receivePumpSettingsParcel(p);
                            }
                        }
                    }
                    */
            } else if (intent.getAction().equals(Intents.BLUETOOTH_CONNECTED)) {
                TextView t = (TextView) findViewById(R.id.textView_StatusNote);
                t.setText("Connected to the Rileylink");
                t.setTextColor(Color.GREEN);

                Log.w(TAG, "Connected to the Rileylink");
            } else if (intent.getAction().equals(Intents.BLUETOOTH_CONNECTING)) {
                TextView t = (TextView) findViewById(R.id.textView_StatusNote);
                t.setText("Connecting to the Rileylink");
                t.setTextColor(Color.YELLOW);

                Log.w(TAG, "Connecting to the Rileylink");
            } else if (intent.getAction().equals(Intents.BLUETOOTH_DISCONNECTED)) {
                TextView t = (TextView) findViewById(R.id.textView_StatusNote);
                t.setText("Disconnected to the Rileylink");
                t.setTextColor(Color.RED);

                Log.w(TAG, "Disconnected from the Rileylink");
            } else if (intent.getAction().equals(Intents.RILEYLINK_BATTERY)) {
                TextView t = (TextView) findViewById(R.id.textView_StatusBattery);
                t.setText("Battery: " + intent.getByteExtra("battery", (byte) 0) + "%");
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // changes to git functionality have caused this versioning to fail. FIXME
        //int versionCode = BuildConfig.VERSION_CODE;
        //String versionName = BuildConfig.VERSION_NAME;
        //setTitle("Roundtrip " + versionName + "-" + versionCode);
        setTitle("RoundtripRL");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, msgList);
        ListView lv = (ListView) findViewById(R.id.listView_Log);
        lv.setAdapter(adapter);

        // FIXME the source of our null intents?
        this.startService(new Intent(this, RoundtripService.class).putExtra("srq", Constants.SRQ.START_SERVICE));
    }

    public void launchRTDemoSettingsActivity(View view) {
        Intent intent = new Intent(this, RTDemoSettingsActivity.class);
        this.startActivity(intent);
    }

    public void launchMonitorActivity(View view) {
        Intent intent = new Intent(this, MonitorActivity.class);
        this.startActivity(intent);
    }

    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intents.ROUNDTRIP_STATUS_MESSAGE);
        intentFilter.addAction(Intents.ROUNDTRIP_TASK_RESPONSE);
        intentFilter.addAction(Intents.BLUETOOTH_CONNECTED);
        intentFilter.addAction(Intents.BLUETOOTH_CONNECTING);
        intentFilter.addAction(Intents.BLUETOOTH_DISCONNECTED);
        intentFilter.addAction(Intents.RILEYLINK_BATTERY);

        // register our desire to receive broadcasts from RoundtripService
        LocalBroadcastManager.getInstance(getApplicationContext())
                .registerReceiver(broadcastReceiver, intentFilter);
    }

    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(getApplicationContext())
                .unregisterReceiver(broadcastReceiver);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
