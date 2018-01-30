package com.example.waldirbertuqui.agenda;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.waldirbertuqui.agenda.DAO.AlunoDAO;
import com.example.waldirbertuqui.agenda.modelo.Aluno;

import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    private ListView listaAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        listaAlunos =  findViewById(R.id.lista_alunos);

        listaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Aluno aluno = (Aluno) listaAlunos.getItemAtPosition(i);
                Intent intentEnviaFormaluario = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
                intentEnviaFormaluario.putExtra("aluno", aluno);

                startActivity(intentEnviaFormaluario);


            }
        });


        FloatingActionButton novoAluno  =  findViewById(R.id.floatingActionButtonAdicionarNovo);

        novoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentvaiFormulario = new Intent(ListaAlunosActivity.this,FormularioActivity.class);
                startActivity(intentvaiFormulario);
            }
        });

        registerForContextMenu(listaAlunos);


    }

    private void carregaLista() {
        AlunoDAO dao =  new AlunoDAO(this);
        List<Aluno> alunos = dao.buscaAlunos();
        dao.close();


        ArrayAdapter<Aluno> adapter =  new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunos);
        listaAlunos.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem deletar =  menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

                Aluno aluno = (Aluno) listaAlunos.getItemAtPosition(info.position);

                AlunoDAO db = new AlunoDAO(ListaAlunosActivity.this);
                db.deleta(aluno);
                db.close();
                carregaLista();


                Toast.makeText(ListaAlunosActivity.this,"Removido(a) "+aluno.getNome() + " com sucesso", Toast.LENGTH_LONG ).show();

                return false;
            }
        });
    }
}
