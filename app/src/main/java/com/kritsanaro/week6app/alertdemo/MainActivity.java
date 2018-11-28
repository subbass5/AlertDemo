package com.kritsanaro.week6app.alertdemo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_alert,btn_ediit_data;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind widget
        btn_alert = findViewById(R.id.btn_alert);
        btn_ediit_data = findViewById(R.id.btn_ediit_data);


        context = MainActivity.this;

        btn_ediit_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder customDialog = new AlertDialog.Builder(context);

                LayoutInflater inflater = getLayoutInflater();
                View alertLayout = inflater.inflate(R.layout.custom_alert,null);
                final EditText et_name = alertLayout.findViewById(R.id.et_name);
                final EditText et_email = alertLayout.findViewById(R.id.et_email);
                Button btn_save = alertLayout.findViewById(R.id.btn_save);
                Button btn_close = alertLayout.findViewById(R.id.btn_close);

                customDialog.setIcon(getResources().getDrawable(R.drawable.ic_warning));
                customDialog.setTitle("บันทึกข้อมูลส่วนตัว");
                customDialog.setView(alertLayout);

                final Dialog dialog = customDialog.show();  //

                btn_save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = et_name.getText().toString();
                        String email = et_email.getText().toString();

                        Toast.makeText(context,
                                "NAME : "+name+" \n EMAIL : "+email,
                                Toast.LENGTH_SHORT).show();
                    }
                });

                btn_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });


            }
        });

        btn_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(context);

                alert.setIcon(getResources().getDrawable(R.drawable.ic_warning));
                alert.setTitle("คำเตือน");
                alert.setMessage("กรุณาป้อนเลขหวย");

                final EditText input = new EditText(context);   //////
                input.setHint("ป้อนเลขหวย"); //////
                alert.setView(input);  /////

                alert.setPositiveButton("ยกเลิก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                alert.setNegativeButton("ตกลง", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String in1 = ""+input.getText();  /////
                        Toast.makeText(context, "คุณได้ซื้อเลข "+in1+" เสร็จสิ้น", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();
            }
        });
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }
}
