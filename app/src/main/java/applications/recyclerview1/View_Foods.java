package applications.recyclerview1;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitch on 2016-05-29.
 */
public class View_Foods extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_layout);
        myDB = new DatabaseHelper(this);
        recyclerView = (RecyclerView) findViewById(R.id.rv);

        Cursor data = myDB.getListContents();
        List<Food> foodList = new ArrayList<>();
        int i = 0;
        if(data.getCount() != 0){
            while(data.moveToNext()){
                Food foods = new Food(data.getString(1),data.getString(2));
                foodList.add(i,foods);
                i++;
            }
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(foodList);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager((new LinearLayoutManager(this)));
        }else{
            Toast.makeText(View_Foods.this, "There is no data to show!",Toast.LENGTH_LONG).show();
        }
    }
}
