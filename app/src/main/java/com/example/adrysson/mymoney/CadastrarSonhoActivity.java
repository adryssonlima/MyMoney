package com.example.adrysson.mymoney;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adrysson.mymoney.view.SonhoView;

public class CadastrarSonhoActivity extends AppCompatActivity {

    private String itensSpinner[] = {
            "Smartphone", "Roupas", "Carro", "Brinquedos", "Games",
            "Viagem", "Imóvel", "TV", "Notebook", "Computador",
            "Informática", "Casamento", "Videogame", "Lazer",
            "Poupança", "Investimentos", "Outros", "Móveis", "Reforma",
            "Educação", "Livros", "Dpividas"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_sonho);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Adapatador do spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner_categoria);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itensSpinner);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //INSERT
                TextView descricaoView = (TextView) findViewById(R.id.editTextDescricao);
                String descricao = descricaoView.getText().toString();
                TextView fotoView = (TextView) findViewById(R.id.fotoSonho);
                String foto = fotoView.getText().toString();
                TextView categoriaView = (TextView) findViewById(R.id.textViewCategoria);
                String categoria = categoriaView.getText().toString();
                TextView motivacaoView = (TextView) findViewById(R.id.editTextMotivacao);
                String motivacao = motivacaoView.getText().toString();
                TextView valorTotalView = (TextView) findViewById(R.id.editTextValorTotal);
                float valorTotal = Float.parseFloat(valorTotalView.getText().toString());
                TextView saldoInicialView = (TextView) findViewById(R.id.editTextsaldoInicial);
                float saldoInicial = Float.parseFloat(saldoInicialView.getText().toString());
                TextView depositoMensalView = (TextView) findViewById(R.id.textViewDepositoMensal);
                float depositoMensal = Float.parseFloat(depositoMensalView.getText().toString());
                SonhoView sonho = new SonhoView(getBaseContext());
                if (sonho.insert(descricao, foto, categoria, motivacao, valorTotal, saldoInicial, depositoMensal)) {
                    finish(); // restarta a activity
                    startActivity(getIntent());
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Erro ao cadastrar sonho", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
