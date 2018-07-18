package br.pacote.animalquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.media.MediaPlayer;

public class RespostaActivity extends AppCompatActivity {
    public static String apl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);

        ImageView imgResposta = (ImageView)findViewById(R.id.imgResposta);
        TextView resposta1 = (TextView)findViewById(R.id.resposta1);
        TextView resposta2 = (TextView)findViewById(R.id.resposta2);
        Button btnJogarNovamente = (Button)findViewById(R.id.btnJogarNovamente);
        Button btnSair = (Button) findViewById(R.id.btnSair);

        Intent intent5 = getIntent();
        //PEGANDO O VALOR DO PONTOS QUE ESTAVAM NA GENERICAACTIVITY
        int pontos = intent5.getIntExtra("pontos", 0);
        apl = intent5.getStringExtra("apelido");
        //ESTRUTURA DE DECISÃO PARA TRATAR OS VALORES DA RESPOSTA, QUE ESTAVAM NA GENERICAACTIVITY
        if(intent5.hasExtra("acertou")) {
            //ESCONDE OS BOTÕES
            btnJogarNovamente.setVisibility(View.INVISIBLE);
            btnSair.setVisibility(View.INVISIBLE);

            boolean acertou = intent5.getBooleanExtra("acertou", false);

            if (acertou) {
                //SETANDO A IMAGEM QUE APARECERÁ NA TELA
                imgResposta.setImageResource(R.drawable.happy);
                MediaPlayer somAcertou = MediaPlayer.create(this, R.raw.somcerta);
                somAcertou.start();
                resposta1.setText("Acertou!");
                resposta2.setText("+1");
            } else {
                imgResposta.setImageResource(R.drawable.sad);
                MediaPlayer somErrou = MediaPlayer.create(this, R.raw.somerrada);
                somErrou.start();
                resposta1.setText("Errou!");
                resposta2.setText("+0");
            }

            //CRIANDO THRADS PARA A TELA PASSAR SEM INTERAÇÃO DO USUÁRIO
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finish();
                }
            });
            thread.start();
        }
        else{
            //MOSTRA OS BOTOES
            btnJogarNovamente.setVisibility(View.VISIBLE);
            btnSair.setVisibility(View.VISIBLE);

            if(pontos >= 3){
                imgResposta.setImageResource(R.drawable.finalizado);
                //COLOCANDO MUSICA
                MediaPlayer somFinalizado = MediaPlayer.create(this, R.raw.finalizado);
                somFinalizado.start();
                resposta1.setText("Parabéns " + apl +"\nNivel Finalizado!");
                resposta2.setText("Totalizou: " + pontos + " pontos!");
            }
            else{
                imgResposta.setImageResource(R.drawable.sad);
                MediaPlayer somNaoFinalizado = MediaPlayer.create(this, R.raw.naofinalizado);
                somNaoFinalizado.start();
                resposta1.setText("Não foi dessa vez "+ apl +".");
                resposta2.setText("Totalizou: " + pontos + " pontos!");
            }
        }
    }
    //BOTAO PARA RETORNAR PARA A ESCOLHAACTIVITY
    public void btnJogarNovamenteOnClick(View v){
        Intent intenta = new Intent(this, EscolhaActivity.class);
        intenta.putExtra("apelido", apl);
        startActivity(intenta);
    }
    //BOTAO PARA SAIR DA APLICAÇÃO
    public void btnSair(View vi){
//CAIXA DE DIALOGO
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle(R.string.app_name);
        dlg.setMessage("Tem certeza que quer sair?");
        dlg.setNegativeButton("Sim", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int whiche){
                finishAffinity();
            }
        });
        dlg.setPositiveButton("Não", null);
        dlg.show();
    }
}
