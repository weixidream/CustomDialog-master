package com.liuhc.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.liuhc.library.dialog.DialogBuilder;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_show:
                DialogBuilder.getInstance(MainActivity.this)
                        .withTitle("Dialog /Title")
                        .withContent("Dialog /Content")
                        .withConfirmText("Button OK")
                        .setConfirmClickListener(new DialogBuilder.OnClickListener() {
                            @Override
                            public void onClick(DialogBuilder dialogBuilder) {
                                Toast.makeText(MainActivity.this, "Dialog Ok Button", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
                break;
        }
    }
}
