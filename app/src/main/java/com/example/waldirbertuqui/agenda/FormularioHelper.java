package com.example.waldirbertuqui.agenda;

import android.widget.EditText;
import android.widget.RatingBar;

import com.example.waldirbertuqui.agenda.modelo.Aluno;

/**
 * Created by waldir.bertuqui on 29/01/2018.
 */

public class FormularioHelper {

    private final EditText nome;
    private final EditText telefone;
    private final EditText endereco;
    private final EditText site;
    private final RatingBar ratingBar;

    public FormularioHelper(FormularioActivity activity){
        nome = activity.findViewById(R.id.formulario_nome);
        telefone = activity.findViewById(R.id.formulario_telefone);
        endereco = activity.findViewById(R.id.formulario_endereco);
        site = activity.findViewById(R.id.formulario_site);
        ratingBar = activity.findViewById(R.id.formulario_ratingbar);
    }

    public Aluno pegaAluno(){
        Aluno aluno = new Aluno();
        aluno.setNome(nome.getText().toString());
        aluno.setEndereco(endereco.getText().toString());
        aluno.setTelefone(telefone.getText().toString());
        aluno.setSite(site.getText().toString());
        aluno.setRatingBar(Double.valueOf(ratingBar.getProgress()));
        return aluno;
    }
}
