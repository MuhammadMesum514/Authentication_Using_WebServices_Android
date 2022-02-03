package pk.edu.uiit.mesum2527.whatsappwebservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.FetchData;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class login extends AppCompatActivity {
    TextInputEditText username;
    TextInputEditText password;
    Button buttonLogin;
    TextView signUpText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        buttonLogin= findViewById(R.id.buttonLogin);
        signUpText=findViewById(R.id.signUpText);

        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), sign_up.class);
                startActivity(intent);
                finish();
            }
        });
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        String  uname, pass;

                        uname = username.getText().toString();
                        pass = password.getText().toString();


                        if ( !uname.equals("") && !pass.equals("")) {
                            String[] field = new String[2];

                            field[0] = "username";
                            field[1] = "password";

                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = uname;
                            data[1] = pass;
                            FetchData fetchData = new FetchData("http://192.168.111.139/logins/login.php");
                            if (fetchData.startFetch()) {
                                if (fetchData.onComplete()) {
                                    String result = fetchData.getResult();
                                    if(result == "Login Success");
                                    {
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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