package com.example.waldirbertuqui.agenda.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.example.waldirbertuqui.agenda.modelo.Aluno;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by waldir.bertuqui on 29/01/2018.
 */

public class AlunoDAO extends SQLiteOpenHelper{

    public AlunoDAO(Context context) {
        super(context, "Agenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //instrucoes para criar uma tabela, sempre que for preciso instalar o banco esse metodo vai criar a tabela abaixo
        String sql = "CREATE TABLE alunos (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, endereco TEXT, telefone TEXT, site TEXT, nota REAL);";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXIST alunos";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public void insere(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValuesAlunos(aluno);
        db.insert("alunos",null,dados);
    }

    @NonNull
    private ContentValues getContentValuesAlunos(Aluno aluno) {
        ContentValues dados =  new ContentValues();
        dados.put("nome",aluno.getNome());
        dados.put("endereco",aluno.getEndereco());
        dados.put("telefone",aluno.getTelefone());
        dados.put("site",aluno.getSite());
        dados.put("nota",aluno.getRatingBar());
        return dados;
    }

    public List<Aluno> buscaAlunos() {
        String sql  = "SELECT * FROM alunos;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);
        List<Aluno> alunos = new ArrayList<Aluno>();

        while (c.moveToNext()){
            Aluno aluno = new Aluno();

            aluno.setId(c.getLong(c.getColumnIndex("id")));
            aluno.setNome(c.getString(c.getColumnIndex("nome")));
            aluno.setEndereco(c.getString(c.getColumnIndex("endereco")));
            aluno.setTelefone(c.getString(c.getColumnIndex("telefone")));
            aluno.setSite(c.getString(c.getColumnIndex("site")));
            aluno.setRatingBar(c.getDouble(c.getColumnIndex("nota")));

            alunos.add(aluno);
        }
        c.close();
        return alunos;
    }

    public void deleta(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {aluno.getId().toString()};
        db.delete("alunos","id = ?",params);

    }

    public void alteraDados(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = getContentValuesAlunos(aluno);


        String[] params = {aluno.getId().toString()};
        db.update("alunos",content,"id = ?", params);
    }
}
