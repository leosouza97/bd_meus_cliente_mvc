package app.modelo.meusclientes.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import app.modelo.meusclientes.R;
import app.modelo.meusclientes.controller.ClienteController;
import app.modelo.meusclientes.model.Cliente;

public class AdicionarClienteCardsFragment extends Fragment {

    //Fragment - Classe responsável pela camada de Visão (Layout)
    View view;
    TextView  txtTitulo;

    EditText editNomeCompleto;
    EditText editTelefone;
    EditText editEmail;
    EditText editCep;
    EditText editLogradouro;
    EditText editNumero;
    EditText editBairro;
    EditText editCidade;
    EditText editEstado;

    CheckBox chkTermosDeUso;

    Button btnCancelar;
    Button btnSalvar;

    Cliente novoCliente;
    ClienteController clienteController;


    public AdicionarClienteCardsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_adicionar_cliente_cards, container, false);


        iniciarComponentesDeLayout();
        escutarEventosDosBotoes();

        return view;
    }

    /**
     * Inicializar os componentes da tela para adicionar os clientes
     */
    private void iniciarComponentesDeLayout() {

        txtTitulo = view.findViewById(R.id.txtTitulo);
        txtTitulo.setText(R.string.fragmento_adicionar_cliente_cards);

        editNomeCompleto = view.findViewById(R.id.editNomeCompleto);
        editTelefone = view.findViewById(R.id.editTelefone);
        editEmail = view.findViewById(R.id.editEmail);
        editCep = view.findViewById(R.id.editCep);
        editLogradouro = view.findViewById(R.id.editLogradouro);
        editNumero = view.findViewById(R.id.editNumero);
        editBairro = view.findViewById(R.id.editBairro);
        editCidade = view.findViewById(R.id.editCidade);
        editEstado = view.findViewById(R.id.editEstado);

        chkTermosDeUso = view.findViewById(R.id.chkTermosDeUso);

        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnSalvar = view.findViewById(R.id.btnSalvar);

        novoCliente = new Cliente();
        clienteController = new ClienteController(getContext());
    }

    private void escutarEventosDosBotoes() {
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isDadosOK = true;

                if (TextUtils.isEmpty(editNomeCompleto.getText().toString())){
                    isDadosOK = false;
                    editNomeCompleto.setError("Digite o nome completo...");
                    editNomeCompleto.requestFocus();
                }

                if (TextUtils.isEmpty(editTelefone.getText().toString())){
                    isDadosOK = false;
                    editTelefone.setError("Digite o telefone...");
                    editTelefone.requestFocus();
                }

                if (TextUtils.isEmpty(editEmail.getText().toString())){
                    isDadosOK = false;
                    editEmail.setError("Digite o email...");
                    editEmail.requestFocus();
                }

                if (TextUtils.isEmpty(editCep.getText().toString())){
                    isDadosOK = false;
                    editCep.setError("Digite o CEP...");
                    editCep.requestFocus();
                }

                if (TextUtils.isEmpty(editLogradouro.getText().toString())){
                    isDadosOK = false;
                    editLogradouro.setError("Digite o Logradouro...");
                    editLogradouro.requestFocus();
                }

                if (TextUtils.isEmpty(editNumero.getText().toString())){
                    isDadosOK = false;
                    editNumero.setError("Digite o número...");
                    editNumero.requestFocus();
                }

                if (TextUtils.isEmpty(editBairro.getText().toString())){
                    isDadosOK = false;
                    editBairro.setError("Digite o bairro...");
                    editBairro.requestFocus();
                }

                if (TextUtils.isEmpty(editCidade.getText().toString())){
                    isDadosOK = false;
                    editCidade.setError("Digite a cidade...");
                    editCidade.requestFocus();
                }

                if (TextUtils.isEmpty(editEstado.getText().toString())){
                    isDadosOK = false;
                    editEstado.setError("Digite o estado...");
                    editEstado.requestFocus();
                }

                if (isDadosOK) {

                    //popular os dados no objeto cliente.
                    novoCliente.setNome(editNomeCompleto.getText().toString());
                    novoCliente.setTelefone(editTelefone.getText().toString());
                    novoCliente.setEmail(editEmail.getText().toString());
                    novoCliente.setCep(Integer.parseInt(editCep.getText().toString()));
                    novoCliente.setLogradouro(editLogradouro.getText().toString());
                    novoCliente.setNumero(Integer.parseInt(editNumero.getText().toString()));
                    novoCliente.setBairro(editBairro.getText().toString());
                    novoCliente.setCidade(editCidade.getText().toString());
                    novoCliente.setEstado(editEstado.getText().toString());

                    novoCliente.setTermosDeUso(chkTermosDeUso.isChecked());

                    clienteController.incluir(novoCliente);

                }else {
                    //Toast
                    //Push Notification
                    //AlertDialog
                }

            }
        });

    }
}