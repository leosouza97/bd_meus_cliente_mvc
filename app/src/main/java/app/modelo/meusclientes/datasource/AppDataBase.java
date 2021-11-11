package app.modelo.meusclientes.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import app.modelo.meusclientes.api.AppUtil;
import app.modelo.meusclientes.datamodel.ClienteDataModel;
import app.modelo.meusclientes.model.Cliente;

public class AppDataBase extends SQLiteOpenHelper {

    private static final String DB_NAME = "MeusClientes.sqlite";
    private static final int DB_VERSION = 1;

    SQLiteDatabase db;


    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ClienteDataModel.criarTabela());

        Log.i(AppUtil.TAG, "onCreate: Table Cliente criada..." + ClienteDataModel.criarTabela());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * Metodo pra incluir dados no banco de dados
     * @return
     */
    public boolean insert(String tabela, ContentValues dados){

        db = getWritableDatabase();

        boolean retorno = false;

        //Regra de negócio
        try {
            //O que deve ser realizado?
            //Salvar os dados
            retorno = db.insert(tabela,null,dados) > 0;

        }catch (Exception e){
            Log.d(AppUtil.TAG, "Insert: " + e.getMessage());
        }


        return retorno;
    }

    /**
     * Metodo pra excluir dados no banco de dados
     * @return
     */
    public boolean deleteByID(String tabela, int id){

        db = getWritableDatabase();

        boolean retorno = false;

        //Regra de negócio
        try {
            //O que deve ser realizado?
            //Salvar os dados
            retorno = db.delete(tabela,"id = ?",new String[]{String.valueOf(id)}) > 0;

        }catch (Exception e){
            Log.d(AppUtil.TAG, "delete: " + e.getMessage());
        }


        return retorno;
    }

    /**
     * Metodo pra alterar dados no banco de dados
     * @return
     */
    public boolean update(String tabela, ContentValues dados){

        db = getWritableDatabase();

        boolean retorno = false;

        //Regra de negócio
        try {
            //O que deve ser realizado?
            //Salvar os dados
            retorno = db.update(tabela,dados,"id = ?",new String[]{String.valueOf(dados.get("id"))}) > 0;

        }catch (Exception e){
            Log.d(AppUtil.TAG, "update: " + e.getMessage());
        }


        return retorno;
    }

    public List<Cliente> getAllCLientes(String tabela){

        db = getWritableDatabase();

        List<Cliente> clientes = new ArrayList<>();
        Cliente obj;

        String sql = "SELECT * FROM "+tabela;

        Cursor cursor;

        cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()){

            do {
                obj = new Cliente();
                obj.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.ID)));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.NOME)));
                obj.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.EMAIL)));
                obj.setTelefone(cursor.getString(cursor.getColumnIndex(ClienteDataModel.TELEFONE)));

                clientes.add(obj);

            }while (cursor.moveToNext());

        }

        return clientes;
    }
}
