package com.simple.icon;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ComponentName mDefault;
    private ComponentName mDouble11;
    private ComponentName mDouble12;
    private PackageManager mPm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDefault = getComponentName();
        mDouble11 = new ComponentName(getBaseContext(),"com.simple.icon.Test11");
        mDouble12 = new ComponentName(getBaseContext(), "com.simple.icon.Test12");
        mPm = getApplicationContext().getPackageManager();
    }


    public void test11(View view) {
        disableComponent(mDefault);
        disableComponent(mDouble12);
        enableComponent(mDouble11);
    }

    public void test12(View view) {
        disableComponent(mDefault);
        disableComponent(mDouble11);
        enableComponent(mDouble12);
    }

    private void enableComponent(ComponentName componentName){
        mPm.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }


    private void disableComponent(ComponentName componentName){
        mPm.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }
}
