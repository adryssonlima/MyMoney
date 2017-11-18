package com.example.adrysson.mymoney;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adrysson.mymoney.view.CategoriaView;
import com.example.adrysson.mymoney.view.DespesaView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;

import static android.R.id.input;

public class DespesaActivity extends AppCompatActivity {

    private String itensSpinner[] = {
        "Alimentação",
        "Educação",
        "Moradia",
        "Pagamentos",
        "Roupa",
        "Saúde",
        "Transporte"
    };

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despesa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Adapatador do spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner_categoria);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itensSpinner);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador);

        dateView = (TextView) findViewById(R.id.button1);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView valorView = (TextView) findViewById(R.id.textViewValor);
                float valor = Float.parseFloat(valorView.getText().toString());
                TextView categoriaView = (TextView) findViewById(R.id.textViewCategoria);
                String categoria = categoriaView.getText().toString();
                TextView dataView = (TextView) findViewById(R.id.textViewData);
                String data = dataView.getText().toString();
                TextView descricaoView = (TextView) findViewById(R.id.textViewDescricao);
                String descricao = descricaoView.getText().toString();
                TextView recorrenteView = (CheckBox) findViewById(R.id.checkBox);
                int recorrente;
                if (recorrenteView.isEnabled())
                    recorrente = 1;
                else
                    recorrente = 0;

                DespesaView despesa = new DespesaView(getBaseContext());
                if ( despesa.insert(valor, categoria, data, descricao, recorrente) ) {
                    finish(); // restarta a activity
                    startActivity(getIntent());
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Erro ao cadastrar despesa", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "Selecione um dia",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

}
