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

public class ReceitaListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String itensList[] = {
        "29/10/2017 - Salário - R$ 2500,00",
        "29/10/2017 - Receita2 - R$ 250,00",
        "30/10/2017 - Receita3 - R$ 25,00",
        "31/10/2017 - Receita4 - R$ 67,00",
        "31/10/2017 - Receita5 - R$ 156,00"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receita_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Adapatador da lista
        ListView list = (ListView) findViewById(R.id.list_receita);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itensList);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReceita = new Intent(ReceitaListActivity.this, ReceitaActivity.class);
                startActivity(intentReceita);
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
