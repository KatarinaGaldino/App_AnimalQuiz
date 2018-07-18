package br.pacote.animalquiz;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;
        import java.lang.String;
//ACTIVITY DA TELA INICIAL
public class MainActivity extends AppCompatActivity {

    private EditText edtApelido;
    public static String apelido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtApelido = (EditText) findViewById(R.id.edtApelido);

    }

    //METODO PARA CHAMAR A  PROXIMA TELA
    public void btnJogarOnClick(View v){
        apelido = edtApelido.getText().toString();
        Intent intent = new Intent(this, EscolhaActivity.class);
        intent.putExtra("apelido", apelido);
        startActivity(intent);

    }

}
