package com.example.sqllite;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private EditText editTextName, editTextAge, editTextRut;
    private RecyclerView recyclerView;
    private DataAdapter adapter;
    private List<DataModel> dataList;
    private int selectedId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextRut = findViewById(R.id.editTextRut);
        recyclerView = findViewById(R.id.recyclerView);
        Button buttonAddUpdate = findViewById(R.id.buttonAddUpdate);

        dataList = new ArrayList<>();
        adapter = new DataAdapter(this, dataList, new DataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DataModel data) {
                editTextName.setText(data.getName());
                editTextAge.setText(String.valueOf(data.getAge()));
                editTextRut.setText(data.getRut());
                selectedId = data.getId();
            }

            @Override
            public void onDeleteClick(int id) {
                dbHelper.deleteData(id);
                loadData();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        buttonAddUpdate.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String ageText = editTextAge.getText().toString();
            String rut = editTextRut.getText().toString();

            if (name.isEmpty() || ageText.isEmpty() || rut.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            int age = Integer.parseInt(ageText);

            if (selectedId == -1) {
                dbHelper.addData(name, age, rut);
            } else {
                dbHelper.updateData(selectedId, name, age, rut);
                selectedId = -1;
            }
            editTextName.setText("");
            editTextAge.setText("");
            editTextRut.setText("");
            loadData();
        });

        loadData();
    }

    private void loadData() {
        dataList.clear();
        Cursor cursor = dbHelper.getAllData();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                int age = cursor.getInt(cursor.getColumnIndexOrThrow("age"));
                String rut = cursor.getString(cursor.getColumnIndexOrThrow("rut"));
                dataList.add(new DataModel(id, name, age, rut));
            }
            cursor.close();
        }
        adapter.notifyDataSetChanged();
    }
}
