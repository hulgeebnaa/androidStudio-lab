package com.example.lab3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class lab13 extends AppCompatActivity {
    ListView budgetListView;
    DatabaseHelper databaseHelper;
    Button btnAdd, btnUpdate;
    SimpleAdapter simpleAdapter;
    NumberFormat formatter;
    Spinner spnBudget, spnBudgetList;
    Cursor data, onclickedData;
    EditText edtDesc, edtAmount;
    String clickedid, clickedincomeexpense,clickedbudgettype,clickedbudgetdesc,clickedbudgetvalue;
    ArrayAdapter adapter1, adapter2;
    String budgettypeItems[] = {"Шилжүүлэг","Зээл","Түрээс","Хоол, хүнс","Эрүүл мэнд","Боловсрол","Амралт, чөлөөт цаг","Бусад"};
    String incomeexpense[] = {"Орлого","Зарлага"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab13);
        this.getSupportActionBar().hide();

        //text view,buttons
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        budgetListView = (ListView) findViewById(R.id.listBudget);
        spnBudget = (Spinner)findViewById(R.id.spnBudget);
        spnBudgetList = (Spinner)findViewById(R.id.spnBudgetList);
        edtDesc = (EditText)findViewById(R.id.edtDesc);
        edtAmount = (EditText) findViewById(R.id.edtAmount);
        btnUpdate.setVisibility(View.GONE);
        formatter = new DecimalFormat("#,###₮");
        adapter1 = new ArrayAdapter(this, R.layout.customspinner, budgettypeItems);
        adapter2 = new ArrayAdapter(this, R.layout.customspinner, incomeexpense);
        spnBudget.setAdapter(adapter1);
        spnBudgetList.setAdapter(adapter2);
        //db
        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        //Actions
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAddclick();
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnUpdateclick();
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
            }
        });
        //List view
        populateListView();

        registerForContextMenu(budgetListView);

        budgetListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                clickedid = setTextofTextView(view, R.id.budgetid);
                clickedincomeexpense = setTextofTextView(view, R.id.incomeExpense); //incomeexpenseDB
                clickedbudgetdesc = setTextofTextView(view,R.id.budgetdesc);
                clickedbudgettype = setTextofTextView(view,R.id.budgetName);  //budgetypeDB
                clickedbudgetvalue = setTextofTextView(view,R.id.budgetValue);
                return false;
            }
        });
    }

    public String setTextofTextView(View view, int id){
        TextView textViewid = view.findViewById(id);
        return textViewid.getText().toString();
    }

    private void btnUpdateclick() {
        if(edtDesc.getText().toString().length() == 0||edtAmount.getText().toString().length() == 0){
            toastMessage("Утга хоосон байна");
        }else{
            try {
                String formattedNumber = formatter.format(Double.parseDouble(edtAmount.getText().toString()));
                databaseHelper.update(clickedid, spnBudget.getSelectedItem().toString(), spnBudgetList.getSelectedItem().toString(), edtDesc.getText().toString(), formattedNumber);
            }catch (SQLException e){
                toastMessage(e.toString());
            }
            toastMessage("Амжилттай шинэчлэгдлээ");
            btnAdd.setVisibility(View.VISIBLE);
            btnUpdate.setVisibility(View.GONE);
            spnBudget.setSelection(adapter1.getPosition("Шилжүүлэг")); spnBudgetList.setSelection(adapter2.getPosition("Орлого")); edtDesc.setText(""); edtAmount.setText("");
            populateListView();
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.updatedelete,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.update){
            btnUpdate.setVisibility(View.VISIBLE);
            btnAdd.setVisibility(View.GONE);
            edtDesc.setText(clickedbudgetdesc);
            spnBudget.setSelection(adapter1.getPosition(clickedincomeexpense)); //incomeexpenseDB
            spnBudgetList.setSelection(adapter2.getPosition(clickedbudgettype)); //budgetypeDB
        }else if(item.getItemId() == R.id.delete){
            databaseHelper.delete(clickedid);
            populateListView();
        }
        return true;
    }

    private void populateListView() {
        data = databaseHelper.getData();
        ArrayList<HashMap<String,String>> list_items = new ArrayList<>();
        while(data.moveToNext()){
            HashMap<String,String> list_item = new HashMap<>();
            list_item.put("id",data.getString(data.getColumnIndex("id")));
            list_item.put("budgetdesc",data.getString(data.getColumnIndex("budgetdesc")));
            list_item.put("incomeexpense",data.getString(data.getColumnIndex("incomeexpense")));
            list_item.put("budgettype",data.getString(data.getColumnIndex("budgettype")));
            list_item.put("budgetvalue",data.getString(data.getColumnIndex("budgetvalue")));
            list_items.add(list_item);
        }
        String[] column = {"id","budgetdesc","incomeexpense","budgettype","budgetvalue"};
        int[] id = {R.id.budgetid,R.id.budgetdesc,R.id.incomeExpense,R.id.budgetName, R.id.budgetValue};
        simpleAdapter = new SimpleAdapter(this, list_items,R.layout.budget_list,column,id);
        budgetListView.setAdapter(simpleAdapter);
    }

    private void btnAddclick() {
        if(edtDesc.getText().toString().length() == 0||edtAmount.getText().toString().length() == 0){
            toastMessage("Утга хоосон байна");
        }else{
            AddData(spnBudget.getSelectedItem().toString(),spnBudgetList.getSelectedItem().toString(),edtDesc.getText().toString(),edtAmount.getText().toString());
            spnBudget.setSelection(adapter1.getPosition("Шилжүүлэг")); spnBudgetList.setSelection(adapter2.getPosition("Орлого")); edtDesc.setText(""); edtAmount.setText("");
            populateListView();
        }
    }
    public void AddData(String incomeexpense, String budgettype, String budgetdesc, String budgetvalue){
        String formattedNumber = formatter.format(Double.parseDouble(budgetvalue));
        boolean insertData = databaseHelper.addData(incomeexpense,budgettype,budgetdesc,formattedNumber);
        if(insertData){
            toastMessage("Амжилттай хадгаллаа");
        }
        else{
            toastMessage("Алдаа гарлаа");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}