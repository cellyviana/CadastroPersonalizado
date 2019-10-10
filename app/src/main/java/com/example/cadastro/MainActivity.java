package com.example.cadastro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.TypedArrayUtils;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editNome;
    private TextView texttitle;
    private Spinner sexo;
    private TextView textMessage;
    private String nome;
    private boolean homem=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNome = (EditText) findViewById(R.id.editNome);
        texttitle = (TextView) findViewById(R.id.texttitle);
        sexo = (Spinner) findViewById(R.id.sexo);
        textMessage = (TextView) findViewById(R.id.textMessage);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.sexo, R.layout.support_simple_spinner_dropdown_item);
        sexo.setAdapter(adapter);

        sexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sexo.getSelectedItem().toString();
                String selecionado = sexo.getSelectedItem().toString();
                if (selecionado.equals("Masculino")) {
                    homem = true;
                }
                else{
                    homem = false;
                }
                textMessage.setText(definirMensagem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        editNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable novoValor) {
                nome = novoValor.toString();
                textMessage.setText(definirMensagem());
            }
        });
    }
    protected String definirMensagem(){
        return "Bem Vind"+(this.homem == true ? "o" : "a")+", "+nome+"! Estavamos esperando por você!";
    }
}
