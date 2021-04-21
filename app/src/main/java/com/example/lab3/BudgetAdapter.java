package com.example.lab3;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class BudgetAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    Cursor mycursor;


    public BudgetAdapter(Context context, Cursor mycursor){
        this.context = context;
        this.mycursor = mycursor;
        inflater = (LayoutInflater.from(context));
    }
    @Override
    public int getCount() {
        return mycursor.getCount();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.budget_list, null);
        TextView budgetValue = (TextView) convertView.findViewById(R.id.budgetValue);
        TextView budgettype = (TextView) convertView.findViewById(R.id.budgetName);
        TextView incomeExpense = (TextView) convertView.findViewById(R.id.incomeExpense);
        mycursor.moveToPosition(position);
        NumberFormat formatter = new DecimalFormat("#,###₮");
        String formattedNumber = formatter.format(Double.parseDouble(mycursor.getString(mycursor.getColumnIndex("budgetvalue"))));
        String incomeexpensetolist = mycursor.getString(mycursor.getColumnIndex("incomeexpense"));
        String budgettypetolist = mycursor.getString(mycursor.getColumnIndex("budgettype"));
        incomeExpense.setText(incomeexpensetolist);
        budgettype.setText(budgettypetolist);
        budgetValue.setText(formattedNumber);
        return convertView;
    }
}
