package com.ltdd.btthgk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    EditText username, Ppass,namedk,pass1,pass2;
    CheckBox cb_R;
    Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TG.userList.add(new User("lena","123"));
        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        username = (EditText) findViewById(R.id.eMail);
        Ppass = (EditText) findViewById(R.id.passwords);
        namedk = (EditText) findViewById(R.id.eMails);
        pass1 =(EditText)findViewById(R.id.passwordss);
        pass2 = (EditText) findViewById(R.id.passwords01);


        TextView signup = (TextView)findViewById(R.id.singUp);
        TextView signin = (TextView)findViewById(R.id.login);
        Button btli = (Button) findViewById(R.id.singIn);
        LinearLayout sulo = (LinearLayout) findViewById(R.id.singUpLayout);
        LinearLayout silo = (LinearLayout) findViewById(R.id.loginLayout);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup.setBackground(getResources().getDrawable(R.drawable.switch_trcks,null));
                signin.setBackground(null);
                sulo.setVisibility(View.VISIBLE);
                silo.setVisibility(View.GONE);
                signup.setTextColor(getResources().getColor(R.color.textColor,null));
                signin.setTextColor(getResources().getColor(R.color.pinkColor,null));
                btli.setText("Signup");
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signin.setBackground(getResources().getDrawable(R.drawable.switch_trcks,null));
                signup.setBackground(null);
                silo.setVisibility(View.VISIBLE);
                sulo.setVisibility(View.GONE);
                signin.setTextColor(getResources().getColor(R.color.textColor,null));
                signup.setTextColor(getResources().getColor(R.color.pinkColor,null));
                btli.setText("Log In");
            }
        });
        btli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean kt=true;
                if (btli.getText().equals("Log In")){
                    for (User us : TG.userList){
                        if (username.getText().toString().trim().equals(us.getUsername())&& Ppass.getText().toString().trim().equals(us.getPass())){
                            Toast.makeText(MainActivity.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                            kt=false;
                            startActivity(new Intent(MainActivity.this,HomeActivity.class));
                        };
                    };
                    if (kt) {
                        Toast.makeText(MainActivity.this,"Đăng nhập sai",Toast.LENGTH_SHORT).show();
                    };
                } else {
                    if (pass1.getText().toString().trim().equals(pass2.getText().toString().trim())){
                        signin.setBackground(getResources().getDrawable(R.drawable.switch_trcks,null));
                        signup.setBackground(null);
                        silo.setVisibility(View.VISIBLE);
                        sulo.setVisibility(View.GONE);
                        signin.setTextColor(getResources().getColor(R.color.textColor,null));
                        signup.setTextColor(getResources().getColor(R.color.pinkColor,null));
                        btli.setText("Log In");
                        Toast.makeText(MainActivity.this,"Đăng ký thành công",Toast.LENGTH_SHORT).show();
                        TG.userList.add(new User(namedk.getText().toString().trim(),pass1.getText().toString().trim()));
                    }

                    else
                        Toast.makeText(MainActivity.this,"Mật khẩu xác nhận sai",Toast.LENGTH_SHORT).show();

                }


            }
        });
    }
}