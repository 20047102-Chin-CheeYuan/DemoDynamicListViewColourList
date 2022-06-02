package sg.edu.rp.c346.id20047102.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    Button btnAdd;
    ListView lvColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);

        ArrayList<String> alColours;
        alColours = new ArrayList<String>();

        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter<String> aaColour = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etElement.getText().toString().trim().length() == 0) {
                    Toast toast = Toast.makeText(MainActivity.this, "The field is empty!", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    String colourName = etElement.getText().toString();
                    alColours.add(colourName);
                    aaColour.notifyDataSetChanged();
                }
            }
        });
    }
}