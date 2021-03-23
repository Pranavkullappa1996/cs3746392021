package com.example.employeefirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    DatabaseReference ref;
    private Button btnAdd;
    private EditText etFirstName;
    private EditText etLastName;
    private TextView tvEmployees;
    int counter = 0;
    int ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ref = FirebaseDatabase.getInstance().getReference("employees");

        etFirstName = (EditText)findViewById(R.id.etFirstName);
        etLastName =  (EditText)findViewById(R.id.etLastName);
        tvEmployees = (TextView) findViewById(R.id.txtEmployeeList);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ID = (int) snapshot.getChildrenCount();
                Employee employ;

                counter = 0;
                StringBuilder value = new StringBuilder();
                for (DataSnapshot ds: snapshot.getChildren()){
                    employ = (Employee)ds.getValue(Employee.class);
                    Log.i("MAINACTIVITY", counter + " - First Name: " + employ.getFirstName() + " Last Name: " + employ.getLastName());
                    value.append(employ.toString(Integer.toString(counter)));
                    counter+=1;
                }
                tvEmployees.setText((value));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("MAINACTIVITY", "Failed to read value", error.toException());
            }
        });

    }

    public void insert(View view) {
        String ID = Integer.toString(counter);
        String f_n = etFirstName.getText().toString();
        String l_n = etLastName.getText().toString();

        if(!f_n.isEmpty() && !l_n.isEmpty()) {

            Log.i("ADDING TO DATABASE", "ID= " + ID);
            Log.i("ADDING TO DATABASE", "First name= " + f_n);
            Log.i("ADDING TO DATABASE", "Last name= " + l_n);

            Employee employ = new Employee(f_n, l_n);
            ref.child(String.valueOf(counter)).setValue(employ);
            etFirstName.setText("");
            etLastName.setText("");
        }
    }
}
