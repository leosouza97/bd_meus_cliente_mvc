package app.modelo.meusclientes.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import app.modelo.meusclientes.datamodel.ClienteDataModel;
import app.modelo.meusclientes.datasource.AppDataBase;
import app.modelo.meusclientes.model.Cliente;

public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues dadoDoObjeto;

    public ClienteController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Cliente obj) {

        dadoDoObjeto = new ContentValues();
        //Key, valor
        //ID é chave primária da tabela cliente
        //É gerada automaticamente pelo SQLite a cada
        //novo registro adicionado
        //SQL ->> INSERT INTO TABLE (... .. .. ) VALUES (### ### ###)

        //dadoDoObjeto.put(ClienteDataModel.ID, obj.getId());
        dadoDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.TELEFONE, obj.getTelefone());
        dadoDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());
        dadoDoObjeto.put(ClienteDataModel.CEP, obj.getCep());
        dadoDoObjeto.put(ClienteDataModel.LOGRADOURO, obj.getLogradouro());
        dadoDoObjeto.put(ClienteDataModel.NUMERO, obj.getNumero());
        dadoDoObjeto.put(ClienteDataModel.BAIRRO, obj.getBairro());
        dadoDoObjeto.put(ClienteDataModel.CIDADE, obj.getCidade());
        dadoDoObjeto.put(ClienteDataModel.ESTADO, obj.getEstado());
        dadoDoObjeto.put(ClienteDataModel.TERMOS_DE_USO, obj.isTermosDeUso());

        //Enviar os dados (dadoDoObjeto) para a classe AppDatabase
        //utilizando um método capaz de adicionar o OBJ no banco de dados
        //tabela qualquer uma (Cliente)

        //Retorno sempre será False ou True
        return insert(ClienteDataModel.TABELA, dadoDoObjeto);

    }

    @Override
    public boolean alterar(Cliente obj) {

        dadoDoObjeto = new ContentValues();
        //Key, valor
        //ID é chave primária da tabela cliente
        //É gerada automaticamente pelo SQLite a cada
        //novo registro adicionado
        //Alterar
        //SQL ->> UPDATE

        dadoDoObjeto.put(ClienteDataModel.ID, obj.getId());
        dadoDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.TELEFONE, obj.getTelefone());
        dadoDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());
        dadoDoObjeto.put(ClienteDataModel.CEP, obj.getCep());
        dadoDoObjeto.put(ClienteDataModel.LOGRADOURO, obj.getLogradouro());
        dadoDoObjeto.put(ClienteDataModel.NUMERO, obj.getNumero());
        dadoDoObjeto.put(ClienteDataModel.BAIRRO, obj.getBairro());
        dadoDoObjeto.put(ClienteDataModel.CIDADE, obj.getCidade());
        dadoDoObjeto.put(ClienteDataModel.ESTADO, obj.getEstado());
        dadoDoObjeto.put(ClienteDataModel.TERMOS_DE_USO, obj.isTermosDeUso());

        //Enviar os dados (dadoDoObjeto) para a classe AppDatabase
        //utilizando um método capaz de alterar o OBJ no banco de dados
        //tabela qualquer uma (Cliente), respeitando o ID ou PK

        return update(ClienteDataModel.TABELA,dadoDoObjeto);

    }

    @Override
    public boolean deletar(int id) {
        return deleteByID(ClienteDataModel.TABELA,id);
    }

    @Override
    public List<Cliente> listar() {
        return getAllCLientes(ClienteDataModel.TABELA);
    }

    public List<String> gerarListaDeClientesListView(){

        List<String> clientes = new ArrayList<>();

        for (Cliente obj:listar()) {
            clientes.add(obj.getId()+"\n"+ obj.getNome());
        }

        return clientes;
    }

}
