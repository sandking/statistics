package com.levislv.statistics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.levislv.statistics.code.CodeActivity;
import com.levislv.statistics.fully.FullyActivity;
import com.levislv.statisticssdk.Statistics;
import com.levislv.statisticssdk.plugin.annotation.StatisticsPage;

@StatisticsPage(
        type = StatisticsPage.Type.ACTIVITY,
        id = R.layout.activity_main,
        name = "首页",
        data = "{'pageKey0':'pageValue0', 'pageKey01':'pageValue1', 'pageKey02':'pageValue2'}"
)
public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_to_code).setOnClickListener(this);
        findViewById(R.id.btn_to_fully).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Statistics.sharedInstance().onStart(this);
    }

    @Override
    protected void onStop() {
        Statistics.sharedInstance().onStop();
        super.onStop();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_to_code:
                startActivity(new Intent(this, CodeActivity.class));
                break;
            case R.id.btn_to_fully:
                startActivity(new Intent(this, FullyActivity.class));
                break;
            default:

                break;
        }
    }
}
