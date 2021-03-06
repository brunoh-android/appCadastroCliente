package app.modelo.meusclientes.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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


public class AdicionarClientes extends Fragment {

    View view;

    TextView txtTitulo;

    EditText editNomeCompleto,
            editTelefone,
            editEmail,
            editCep,
            editLogradouro,
            editNumero,
            editBairro,
            editCidade,
            editEstado;
    CheckBox chkTermoDeUso;
    Button btnCancelar, btnSalvar;

    Cliente novoCliente;
    ClienteController clienteController;

    public AdicionarClientes() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_adicionar_cliente, container, false);

        iniciarComponentesDeLayout();

        escutarEventosDosBotoes();

        return view;
    }


    private void iniciarComponentesDeLayout() {


        txtTitulo = view.findViewById(R.id.txtTitulo);
        txtTitulo.setText(R.string.novoCliente);

        editNomeCompleto = view.findViewById(R.id.editNomeCompleto);
        editTelefone = view.findViewById(R.id.editTelefone);
        editEmail = view.findViewById(R.id.editEmail);
        editCep = view.findViewById(R.id.editCep);
        editLogradouro = view.findViewById(R.id.editLogradouro);
        editNumero = view.findViewById(R.id.editNumero);
        editBairro = view.findViewById(R.id.editBairro);
        editCidade = view.findViewById(R.id.editCidade);
        editEstado = view.findViewById(R.id.editEstado);

        chkTermoDeUso = view.findViewById(R.id.chkTermoDeUso);

        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnSalvar = view.findViewById(R.id.btnSalvar);

        novoCliente = new Cliente();
        clienteController = new ClienteController(getContext());


    }

    private void escutarEventosDosBotoes() {

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isDadosOK = true;

                if (TextUtils.isEmpty(editNomeCompleto.getText())) {
                    isDadosOK = false;
                    editNomeCompleto.setError("Digite o nome completo...");
                    editNomeCompleto.requestFocus();
                }

                if (TextUtils.isEmpty(editTelefone.getText())) {
                    isDadosOK = false;
                    editTelefone.setError("Digite o telefone...");
                    editTelefone.requestFocus();
                }

                if (TextUtils.isEmpty(editEmail.getText())) {
                    isDadosOK = false;
                    editEmail.setError("Digite o email...");
                    editEmail.requestFocus();
                }

                if (TextUtils.isEmpty(editCep.getText())) {
                    isDadosOK = false;
                    editCep.setError("Digite o CEP...");
                    editCep.requestFocus();
                }

                if (TextUtils.isEmpty(editLogradouro.getText())) {
                    isDadosOK = false;
                    editLogradouro.setError("Digite o Logradouro...");
                    editLogradouro.requestFocus();
                }

                if (TextUtils.isEmpty(editNumero.getText())) {
                    isDadosOK = false;
                    editNumero.setError("Digite o Numero...");
                    editNumero.requestFocus();
                }

                if (TextUtils.isEmpty(editBairro.getText())) {
                    isDadosOK = false;
                    editBairro.setError("Digite o Bairro...");
                    editBairro.requestFocus();
                }

                if (TextUtils.isEmpty(editCidade.getText())) {
                    isDadosOK = false;
                    editCidade.setError("Digite o Cidade...");
                    editCidade.requestFocus();
                }

                if (TextUtils.isEmpty(editEstado.getText())) {
                    isDadosOK = false;
                    editEstado.setError("Digite o Estado...");
                    editEstado.requestFocus();
                }


                if (isDadosOK) {

                    novoCliente.setNome(editNomeCompleto.getText().toString());
                    novoCliente.setTelefone(editTelefone.getText().toString());
                    novoCliente.setEmail(editEmail.getText().toString());
                    novoCliente.setCep(Integer.parseInt(editCep.getText().toString()));
                    novoCliente.setLogradouro(editLogradouro.getText().toString());
                    novoCliente.setNumero(editNumero.getText().toString());
                    novoCliente.setBairro(editBairro.getText().toString());
                    novoCliente.setCidade(editCidade.getText().toString());
                    novoCliente.setEstado(editEstado.getText().toString());
                    novoCliente.setTermoDeUso(chkTermoDeUso.isChecked());

                    clienteController.incluir(novoCliente);
                    Log.i("log_add_cliente", "onClick: Dados corretos... ");


                } else {

                    Log.i("log_add_cliente", "onClick: Dados incorretos... ");
                }

            }
        });
    }


}
