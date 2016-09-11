package com.example.nitin.accelerometer;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    SensorManager s1;
    TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        t1=(TextView)findViewById(R.id.textView);
        t2=(TextView)findViewById(R.id.textView2);
        t3=(TextView)findViewById(R.id.textView3);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER)
            fall(event);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {


    }
    public void fall(SensorEvent event)
    {
        float []values=event.values;
        float x=values[0];
        float y=values[1];
        float z=values[2];
        String s2=Float.toString(x);
        String s3=Float.toString(y);
        String s4=Float.toString(z);
        t1.setText(s2);
        t2.setText(s3);
        t3.setText(s4);
    }

    @Override
    protected void onResume() {
        super.onResume();
        s1.registerListener(this, s1.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        s1.unregisterListener(this);
    }
}
