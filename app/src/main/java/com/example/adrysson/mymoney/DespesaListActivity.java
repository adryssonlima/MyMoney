package com.example.adrysson.mymoney;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DespesaListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String itensList[] = {
        "29/10/2017 - Pagamento da Academia",
        "29/10/2017 - Pagamento do Cartão de crédito",
        "30/10/2017 - Uber",
        "31/10/2017 - Créditos no Smatrphone",
        "31/10/2017 - Roupa para o Natal",
        "31/10/2017 - Ingresso para o show do Metallica"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despesa_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Adapatador da lista
        ListView list = (ListView) findViewById(R.id.list_despesa);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itensList);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNovaDespesa = new Intent(DespesaListActivity.this, DespesaActivity.class);
                startActivity(intentNovaDespesa);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
        Object obj = adapterView.getAdapter().getItem(posicao);
        if (obj != null) {
//            String item = obj.toString();
//            Intent intentSonhoDetalhes = new Intent(this, SonhoDetalhesActivity.class);
//            intentSonhoDetalhes.putExtra("SONHO", item);
//            startActivity(intentSonhoDetalhes);
        } else {
            Toast.makeText(this,
                    "Nenhum item selecionado",
                    Toast.LENGTH_LONG).show();
        }
    }

}
