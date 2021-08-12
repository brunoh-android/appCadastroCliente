package app.modelo.meusclientes.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.modelo.meusclientes.R;
import app.modelo.meusclientes.controller.ClienteController;
import app.modelo.meusclientes.model.Cliente;


public class ListarClientesFragment extends Fragment {

    View view;

    EditText editPesquisarNome;

    ListView listView;

    List<Cliente> clienteList;
    List<String> clientes;

    ArrayAdapter<String> clienteAdapter;

    ArrayList<HashMap<String, String>> filtroCliente;

    ClienteController clienteController;

    Cliente objCliente;

    public ListarClientesFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_listar_clientes, container, false);

        TextView txtTitulo = view.findViewById(R.id.txtTitulo);

        txtTitulo.setText(R.string.listar_clientes_fragment);

        txtTitulo.setTextColor(ColorStateList.valueOf(Color.CYAN));

        listView = (ListView) view.findViewById(R.id.listView);

        editPesquisarNome = view.findViewById(R.id.editPesquisarNome);

        clienteController = new ClienteController(getContext());


        clienteList = clienteController.listar();

        clientes = new ArrayList<>();

        for (Cliente obj : clienteList) {

            clientes.add(obj.getId()+", " +obj.getNome());
            
        }

        clienteAdapter = new ArrayAdapter<>(getContext(), R.layout.listar_cliente_item, R.id.txtItemLista, clientes);

        listView.setAdapter(clienteAdapter);

        editPesquisarNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence filtro, int i, int i1, int i2) {

                ListarClientesFragment.this.clienteAdapter.getFilter().filter(filtro);

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;
    }


}
