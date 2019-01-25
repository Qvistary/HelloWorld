package top.qvisa.android.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mbfragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbfragment=findViewById(R.id.Bt_Fragment);

        setOnclickListener();
    }

    @Override
    public void onClick(View v) {
       Intent intent = null;
        switch (v.getId()) {
            case R.id.Bt_Fragment:
                intent = new Intent(MainActivity.this,FragmentTest.class);
                break;

        }
        startActivity(intent);
    }

    public void setOnclickListener(){
        mbfragment.setOnClickListener(this);
    }
}
