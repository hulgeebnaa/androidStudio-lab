package com.example.lab3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class lab14 extends AppCompatActivity {
    private static final String TAG = "LAB14";
    EditText firstName, lastName, studentCode, studentEmail, studentPhone;
    Button save;
    DatabaseReference reff;
    FirebaseListAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab14);
        this.getSupportActionBar().hide();
        listView = (ListView) findViewById(R.id.lab14listview);
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        studentCode = (EditText) findViewById(R.id.studentCode);
        studentEmail = (EditText) findViewById(R.id.studentEmail);
        studentPhone = (EditText) findViewById(R.id.studentPhone);
        save = (Button) findViewById(R.id.save);

        reff = FirebaseDatabase.getInstance().getReference().child("Student");
        save.setOnClickListener(v -> addData());

        FirebaseListOptions<StudentModel> options = new FirebaseListOptions.Builder<StudentModel>().setLayout(R.layout.lab14list_item).setLifecycleOwner(lab14.this).setQuery(reff,StudentModel.class).build();
        adapter = new FirebaseListAdapter(options) {
            @Override
            protected void populateView(@NonNull View v, @NonNull Object model, int position) {
                TextView stdlistview = v.findViewById(R.id.studentlistview);
                StudentModel std = (StudentModel) model;
                stdlistview.setText(std.toString());
            }
        };
        listView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    private void addData() {
        String firstname = firstName.getText().toString().trim();
        String lastname = lastName.getText().toString().trim();
        String studentcode = studentCode.getText().toString().trim();
        String studentmail = studentEmail.getText().toString().trim();
        String studentphone = studentPhone.getText().toString().trim();
        if (TextUtils.isEmpty(firstName.getText())||TextUtils.isEmpty(lastName.getText())||TextUtils.isEmpty(studentCode.getText())||TextUtils.isEmpty(studentEmail.getText())||TextUtils.isEmpty(studentPhone.getText())) {
            firstName.setError("Овгоо оруулна уу.");
            lastName.setError("Нэрээ оруулна уу.");
            studentCode.setError("Оюутны кодоо оруулна уу.");
            studentEmail.setError("Мэйл хаягаа оруулна уу.");
            studentPhone.setError("Утасны дугаараа оруулна уу.");
            return;
        } else {
            StudentModel model = new StudentModel(firstname, lastname, studentcode, studentmail,studentphone);
            reff.child(reff.push().getKey()).setValue(model).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(lab14.this, "Өгөгдөл амжилттай орлоо.", Toast.LENGTH_SHORT).show();
                        firstName.setEnabled(true);
                        firstName.requestFocus();
                        firstName.setText("");
                        lastName.setText("");
                        studentCode.setText("");
                        studentEmail.setText("");
                        studentPhone.setText("");
                    } else {
                        String error = task.getException().toString();
                        Toast.makeText(lab14.this, "Өгөгдөл ороход алдаа гарлаа\n" + error, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}