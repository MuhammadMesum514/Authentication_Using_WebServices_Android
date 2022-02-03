package pk.edu.uiit.mesum2527.whatsappwebservices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class ListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        android.widget.ListView lv=findViewById(R.id.listview1);
    }
}