package com.example.waldirbertuqui.agenda;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        String[] alunos = {
            "Waldir",
            "Thalita",
            "Bernado"
        };
        ListView listaAlunos =  (ListView) findViewById(R.id.lista_alunos);
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alunos);
        listaAlunos.setAdapter(adapter);

        FloatingActionButton novoAluno  =  findViewById(R.id.floatingActionButtonAdicionarNovo);

        novoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentvaiFormulario = new Intent(ListaAlunosActivity.this,FormularioActivity.class);
                startActivity(intentvaiFormulario);
            }
        });


    }


}