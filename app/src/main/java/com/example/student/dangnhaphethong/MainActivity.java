package com.example.student.dangnhaphethong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    CheckBox cb;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    CompoundButton.OnCheckedChangeListener m_listener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (compoundButton == all){
                detachListener();
                cb.setEnabled(!b);
                cb.setChecked(b);
                attachListener();
            }
            else{
                Toast.makeText(compoundButton.getContext(),compoundButton.getText()+""+compoundButton.isChecked(),Toast.LENGTH_SHORT).show();


            }
        }
    };

    void attachListener()
    {
        cb.setOnCheckedChangeListener(m_listener);

    }

    void detachListener()
    {
        cb.setOnCheckedChangeListener(null);

    }

    void init() {
        cb= findViewById(R.id.checkBox);

        attachListener();


        btn = findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mgs = "";
                if (!cb.isChecked())
                    mgs = "Chào mừng bạn đăng nhập hệ thống, thông tin của bạn đã được lưu";
                else
                    mgs = "Chào mừng bạn đăng nhập hệ thống, thông tin của bạn không được lưu";

                Toast.makeText(view.getContext(),
                        mgs,
                        Toast.LENGTH_SHORT).show();
            }
        });


    }

}
