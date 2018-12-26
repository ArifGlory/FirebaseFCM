package glory.firebasefcm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    TextView txtToken;
    Button btnGenerate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        FirebaseApp.initializeApp(MainActivity.this);

        txtToken = findViewById(R.id.txtToken);
        btnGenerate = findViewById(R.id.btnGenerate);

        String token  = FirebaseInstanceId.getInstance().getToken();
        if (token != null){
            txtToken.setText(token);
        }else {
            txtToken.setText("Token kosong !");
        }

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String token  = FirebaseInstanceId.getInstance().getToken();
                if (token != null){
                    txtToken.setText(token);
                }else {
                    txtToken.setText("Token kosong !");
                }
            }
        });


    }
}
