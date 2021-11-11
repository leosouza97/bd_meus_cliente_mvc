package app.modelo.meusclientes.datamodel;

public class ClienteDataModel {

    //Modelo Objeto Relacional

    //Toda Classe Data Model tem esta estrutura
    //5 - Queries de consulta gerais

    //1 - Atributo nome da tabela
    public static final String TABELA = "cliente";

    //2 - Atributos um para um com os nomes dos campos
    public static final String ID = "id"; //Integer
    public static final String NOME = "nome"; //Text
    public static final String TELEFONE = "telefone"; //Text
    public static final String EMAIL = "email"; //Text
    public static final String CEP = "cep"; //Integer
    public static final String LOGRADOURO = "logradouro"; //Text
    public static final String NUMERO = "numero"; //Integer
    public static final String BAIRRO = "bairro"; //Text
    public static final String CIDADE = "cidade"; //Text
    public static final String ESTADO = "estado"; //Text
    public static final String TERMOS_DE_USO = "termos_de_uso"; //Integer

    //3 - Query para criar a tabela no BD
    public static String queryCriarTabela = "";

    //4 - Método para gerar o Script para criar a tabela
    public static String criarTabela(){

        //Concatenação de String
        queryCriarTabela += "CREATE TABLE "+TABELA+" (";
        queryCriarTabela += ID+" integer primary key autoincrement, ";
        queryCriarTabela += NOME+" text, ";
        queryCriarTabela += TELEFONE+" text, ";
        queryCriarTabela += EMAIL+" text, ";
        queryCriarTabela += CEP+" integer, ";
        queryCriarTabela += LOGRADOURO+" text, ";
        queryCriarTabela += NUMERO+" integer, ";
        queryCriarTabela += BAIRRO+" text, ";
        queryCriarTabela += CIDADE+" text, ";
        queryCriarTabela += ESTADO+" text, ";
        queryCriarTabela += TERMOS_DE_USO+" integer ";
        queryCriarTabela += ")";

        return queryCriarTabela;
    }
}
