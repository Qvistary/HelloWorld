package top.qvisa.android.helloworld.BroadcastReceiver_package;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import top.qvisa.android.helloworld.R;

public class BatteryLevelReceiverTest extends AppCompatActivity {
    private static final String TAG = "BatteryLevelReceiver";
    private BatteryLevelReceiver batteryLevelReceiver;
    private TextView mBatteryLevelText;
    private TextView mBatteryPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_level_receiver_test);
        initView();
        registerBatteryReceiver();

    }

    private void initView() {
        mBatteryLevelText = this.findViewById(R.id.Tv_BatteryLevel);
        mBatteryPercent = this.findViewById(R.id.Tv_BatteryPercent);
    }

    private void registerBatteryReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        batteryLevelReceiver = new BatteryLevelReceiver();
        registerReceiver(batteryLevelReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(batteryLevelReceiver!=null){
            unregisterReceiver(batteryLevelReceiver);
            Log.d(TAG,"销毁监听");
        }

    }

    private class BatteryLevelReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            int batterylevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            int batterymax = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 0);
            float baterrypercent = batterylevel * 1.0f / batterymax * 100;
            if (Intent.ACTION_BATTERY_CHANGED.equals(action)) {
                Log.d(TAG, "收到电量变化的广播 -- action is" + action);
                if (mBatteryLevelText != null) {
                    mBatteryLevelText.setText("当前电量为" + batterylevel);
                }
                if (mBatteryPercent != null) {
                    mBatteryPercent.setText("当前电量百分比为" + baterrypercent + "%");
                }
            } else if (Intent.ACTION_POWER_CONNECTED.equals(action)) {
                Toast.makeText(context, "USB已经连上", Toast.LENGTH_SHORT).show();
            } else if (Intent.ACTION_POWER_DISCONNECTED.equals(action)) {
                Toast.makeText(context, "USB已经断开", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
