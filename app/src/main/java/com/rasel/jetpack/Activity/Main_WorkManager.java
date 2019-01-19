package com.rasel.jetpack.Activity;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rasel.jetpack.MyWorker;
import com.rasel.jetpack.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

public class Main_WorkManager extends AppCompatActivity {

    public static final String KEY_TASK_DESC = "key_task_desc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_work_manager);

        Data data = new Data.Builder()
                .putString(KEY_TASK_DESC, "Hey I am sending the work data")
                .build();

        final OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(MyWorker.class)
                .setInputData(data)
                .build();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorkManager.getInstance().enqueue(request);
            }
        });

        final TextView textView = findViewById(R.id.textView);

        WorkManager.getInstance().getWorkInfoByIdLiveData(request.getId())
                .observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(@Nullable WorkInfo workInfo) {

                        if (workInfo != null) {

                            if (workInfo.getState().isFinished()) {

                                Data data = workInfo.getOutputData();

                                String output = data.getString(MyWorker.KEY_TASK_OUTPUT);

                                textView.append(output + "\n");
                            }

                            String status = workInfo.getState().name();
                            textView.append(status + "\n");
                        }
                    }
                });

    }
}
