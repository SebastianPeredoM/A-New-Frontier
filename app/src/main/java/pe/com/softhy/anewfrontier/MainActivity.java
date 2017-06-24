package pe.com.softhy.anewfrontier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pe.com.softhy.anewfrontier.ui.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container, new MainFragment())
                .commit();
    }
}
