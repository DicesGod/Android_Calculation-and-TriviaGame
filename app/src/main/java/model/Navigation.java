package model;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import com.minhle.calculations.History;
import com.minhle.calculations.MainActivity;
import com.minhle.calculations.R;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import static android.support.v4.content.ContextCompat.startActivity;

public class Navigation extends AppCompatActivity {

    public void navigation(BottomNavigationView menu) {

        menu.findViewById(R.id.navigation);
        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nag_math:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        break;

                    case R.id.nag_history:
                        Intent intent3 = new Intent(getApplicationContext(), History.class);
                        startActivity(intent3);
                        break;


                }
                return false;
            }
        });


    }

}