package com.example.adrysson.mymoney;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CategoriaDetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_detalhes);

        Intent intentOrigin = getIntent();
        String categoria = intentOrigin.getStringExtra("CATEGORIA");
        TextView title = (TextView) findViewById(R.id.textViewTitle);
        title.append(categoria);

    }
}
