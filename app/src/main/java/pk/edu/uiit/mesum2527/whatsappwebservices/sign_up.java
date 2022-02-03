package pk.edu.uiit.mesum2527.whatsappwebservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class sign_up extends AppCompatActivity {
    TextInputEditText fullname;
    TextInputEditText username;
    TextInputEditText password;
    TextInputEditText email;
        Button signup;
        TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fullname=findViewById(R.id.fullname);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        email=findViewById(R.id.email);
        signup=findViewById(R.id.buttonSignUp);
        login=findViewById(R.id.loginText);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
                finish();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        String name, uname, pass, mail;
                        name = fullname.getText().toString();
                        uname = username.getText().toString();
                        pass = password.getText().toString();
                        mail = email.getText().toString();

                        if (!name.equals("") && !uname.equals("") && !pass.equals("") && !mail.equals("")) {
                            String[] field = new String[4];
                            field[0] = "fullname";
                            field[1] = "username";
                            field[2] = "password";
                            field[3] = "email";
                            //Creating array for data
                            String[] data = new String[4];
                            data[0] = name;
                            data[1] = uname;
                            data[2] = pass;
                            data[3] = mail;
                            PutData putData = new PutData("http://192.168.111.139/logins/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if(result == "Sign Up Success");
                                    {
                                        Intent intent = new Intent(getApplicationContext(), login.class);
                                        startActivity(intent);
                                        finish();
                                    }

                                }
                            }
//                        End Write and Read data with URL
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Please input all fields",Toast.LENGTH_LONG);
                        }
                    }
                });

            }
        });



    }
}