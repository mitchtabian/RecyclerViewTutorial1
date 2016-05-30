package applications.recyclerview1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etMeal,etDesert;
    Button btnAdd,btnView;
    DatabaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);
        etMeal = (EditText) findViewById(R.id.etMeal);
        etDesert = (EditText) findViewById(R.id.etDesert);
        myDB = new DatabaseHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String meal = etMeal.getText().toString();
                String desert = etDesert.getText().toString();

                if(meal.length() != 0 && desert.length() != 0){
                    AddData(meal,desert);
                    etMeal.setText("");
                    etDesert.setText("");
                }else{
                    Toast.makeText(MainActivity.this, "You must fill in the text fields!",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MainActivity.this, View_Foods.class);
                startActivity(intent);
            }
        });

    }

    public void AddData(String meal, String desert) {

        boolean insertData = myDB.addData(meal,desert);

        if (insertData == true) {
            Toast.makeText(MainActivity.this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
        }
    }
}
