package com.example.cafepi;

import java.util.List;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
 
public class WifiItem extends Activity {
	private Button button;
    TextView mainText;
    WifiManager mainWifi;
    WifiReceiver receiverWifi;
    List<ScanResult> wifiList;
    StringBuilder sb = new StringBuilder();
     
    public void onCreate(Bundle savedInstanceState) {
         
       super.onCreate(savedInstanceState);
        
       setContentView(R.layout.wifiitem);
       mainText = (TextView) findViewById(R.id.mainText);
        
       // Initiate wifi service manager
       mainWifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        
       // Check for wifi is disabled
       if (mainWifi.isWifiEnabled() == false)
            {   
                // If wifi disabled then enable it
                Toast.makeText(getApplicationContext(), "wifi is disabled..making it enabled", 
                Toast.LENGTH_LONG).show();
                 
                mainWifi.setWifiEnabled(true);
            } 
        
       // wifi scaned value broadcast receiver 
       receiverWifi = new WifiReceiver();
        
       // Register broadcast receiver 
       // Broacast receiver will automatically call when number of wifi connections changed
       registerReceiver(receiverWifi, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
       mainWifi.startScan();
       mainText.setText("Starting Scan...");
       
       button=(Button)findViewById(R.id.button1);
       button.setOnClickListener(
       		 
       		new OnClickListener() {
       		public void onClick(View v) {
       			finish();
       		}});
       }
    
   
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 0, 0, "Refresh");
        return super.onCreateOptionsMenu(menu);
    }
 
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        mainWifi.startScan();
        mainText.setText("Starting Scan");
        return super.onMenuItemSelected(featureId, item);
    }
 
    protected void onPause() {
        unregisterReceiver(receiverWifi);
        super.onPause();
    }
 
    protected void onResume() {
        registerReceiver(receiverWifi, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        super.onResume();
    }
     
    // Broadcast receiver class called its receive method 
    // when number of wifi connections changed
     
    class WifiReceiver extends BroadcastReceiver {
         
        // This method call when number of wifi connections changed
        public void onReceive(Context c, Intent intent) {
             
            sb = new StringBuilder();
            wifiList = mainWifi.getScanResults(); 
            sb.append("\n        Number Of Wifi connections :"+wifiList.size()+"\n\n");
             
            for(int i = 0; i < wifiList.size(); i++){
                 
                sb.append(new Integer(i+1).toString() + ". ");
                sb.append((wifiList.get(i)).toString());
                sb.append("\n\n");
            }
             
            mainText.setText(sb);  
        }
      
      
    }
}

