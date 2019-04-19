package model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.minhle.calculations.R;


public class History extends AppCompatActivity implements View.OnClickListener{

    Button btnAnswer,btnFinish;
    static int i = 1, j = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triviagame);

        btnAnswer = findViewById(R.id.btnAnswer);
        btnFinish = findViewById(R.id.btnFinish);
        btnAnswer.setOnClickListener(this);
        btnFinish.setOnClickListener(this);
        btnFinish.setEnabled(false);

    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btnAnswer:
                HistoryFragment a = (HistoryFragment)getSupportFragmentManager().findFragmentById(R.id.fragment);
                boolean check;
                check = a.next(i,j);
                if(check == true){
                i++;
                j+=4;
                }
                else
                {
                btnFinish.setEnabled(true);
                btnAnswer.setEnabled(false);
                Toast.makeText(this,"You have finished the test! Please select the FINISH button",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btnFinish:
//                Intent intent = new Intent(this, Result.class);
//                intent.putExtra("tag", Arrayresult);
//                startActivity(intent);
//                break;

                break;
        }
    }

}
