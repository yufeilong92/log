package com.liang.myapplication.crashmonitor.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.liang.myapplication.R;
import com.liang.myapplication.crashmonitor.MCrashMonitor;


/**
 * 展示Crash页面的
 */
public class CrashShowActivity extends CrashBaseActivity {

    private Button btn_restart_app;
    private Button btn_crash_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mncrash_show);

        try {
            initViews();
        } catch (Exception e) {

        }
    }

    private void initViews() {
        btn_restart_app = (Button) findViewById(R.id.btn_restart_app);
        btn_crash_list = (Button) findViewById(R.id.btn_crash_list);

        btn_restart_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //重启app代码
                Intent intent = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage(getBaseContext().getPackageName());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                CrashShowActivity.this.finish();
            }
        });

        btn_crash_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MCrashMonitor.startCrashListPage(context);
            }
        });

    }

    @Override
    public void onBackPressed() {
    }
}
