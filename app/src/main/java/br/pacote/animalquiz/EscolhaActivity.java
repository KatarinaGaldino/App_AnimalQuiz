package br.pacote.animalquiz;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.String;

public class EscolhaActivity extends AppCompatActivity implements OnClickListener{

    public ImageButton imgButtonGato;
    public ImageButton imgButtonCao;
    public ImageButton imgButtonCoruja;
    public static String apelido;
    public TextView txtApelido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha);

        imgButtonGato = (ImageButton) findViewById(R.id.imgButtonGato);
        imgButtonCao = (ImageButton) findViewById(R.id.imgButtonCao);
        imgButtonCoruja = (ImageButton) findViewById(R.id.imgButtonCoruja);
        txtApelido = (TextView) findViewById(R.id.txtApelido);


        Bundle bundle = getIntent().getExtras();
        apelido = bundle.getString("apelido");
        txtApelido.setText("Olá " + apelido );

        imgButtonGato.setOnClickListener(this);
        imgButtonCao.setOnClickListener(this);
        imgButtonCoruja.setOnClickListener(this);


    }

    @Override
    public void onClick(View v){
        Intent it = null;
        switch (v.getId()){
            case R.id.imgButtonGato:
                it = new Intent(this, GenericaActivity.class);
                //METODO PUTEXTRA PARA PASSAR O TIPO COM VALOR 1
                it.putExtra("tipo", 1);
                it.putExtra("apelido", apelido);
                break;
            case R.id.imgButtonCao:
                it = new Intent(this, GenericaActivity.class);
                //METODO PUTEXTRA PARA PASSAR O TIPO COM VALOR 2
                it.putExtra("tipo", 2);
                it.putExtra("apelido", apelido);
                break;
            case R.id.imgButtonCoruja:
                it = new Intent(this, GenericaActivity.class);
                //METODO PUTEXTRA PARA PASSAR O TIPO COM VALOR 3
                it.putExtra("tipo", 3);
                break;
        }

        if(it != null){
            startActivity(it);
        }

    }

}
