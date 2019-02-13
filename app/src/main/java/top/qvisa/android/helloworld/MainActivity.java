package top.qvisa.android.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import top.qvisa.android.helloworld.BroadcastReceiver_package.BatteryLevelReceiverTest;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mbfragment;
    private Button mbfdemo;
    private Button mBatterydemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbfragment = findViewById(R.id.Bt_Fragment);
        mbfdemo = findViewById(R.id.Bt_Fragment_demo);
        mBatterydemo = findViewById(R.id.Bt_Battery_demo);
        setOnclickListener();
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.Bt_Fragment:
                intent = new Intent(MainActivity.this, FragmentTest.class);
                break;
            case R.id.Bt_Fragment_demo:
                intent = new Intent(MainActivity.this, FragmentBestPractice.class);
                break;
            case R.id.Bt_Battery_demo:
                intent = new Intent(MainActivity.this, BatteryLevelReceiverTest.class);
                break;

        }
        startActivity(intent);
    }

    public void setOnclickListener() {
        mbfragment.setOnClickListener(this);
        mbfdemo.setOnClickListener(this);
        mBatterydemo.setOnClickListener(this);
    }
}
