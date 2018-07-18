package br.pacote.animalquiz;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GenericaActivity extends AppCompatActivity {

    TextView pergunta;
    RadioButton rbResposta1, rbResposta2, rbResposta3, rbResposta4;
    int respostaCerta = R.id.rbResposta1;
    RadioGroup rgRespostas;
    int pontos = 0;
    TextView txtPont;
    ImageView imgViewGenerica;
    int tipo = 0;
    RelativeLayout layoutGenerico;
    public static String apl;

   //LISTA COM AS PERGUNTAS
    List<Questao> questoesGatitos = new ArrayList<Questao>(){
        {
            add(new Questao("Quanto mede o maior gato do mundo?", R.id.rbResposta1, "122 centimetros", "1 metro", "1 metro e vinte", "130 centimetros"));
            add(new Questao("Quantos sensores tem o bigode de um gato", R.id.rbResposta2, "15", "12", "10", "13"));
            add(new Questao("Onde os gatos eram vistos como divindade?", R.id.rbResposta4, "Brasil", "Noruega", "Mesopotâmia", "Egito"));
            add(new Questao("Em quantos graus eles podem rodar as orelhas?", R.id.rbResposta4, "45º", "90º", "175º", "180º"));
        }
    };

    List<Questao> questoesCaozitos = new ArrayList<Questao>(){
        {
            add(new Questao("Quantos dentes tem um cachorro adulto?", R.id.rbResposta1, "42", "41", "35", "33"));
            add(new Questao("Quantos dias duram uma gestação canina?", R.id.rbResposta2, "45 dias", "60 dias", "6 meses", "3 meses"));
            add(new Questao("Como se chamam os cães selvagens da Australia?", R.id.rbResposta4, "Dings", "Ditos", "Dinhos", "Dingos"));
            add(new Questao("Quantas expressões facias os cães tem?", R.id.rbResposta4, "10", "5", "30", "100"));
        }
    };

    List<Questao> questoesCorujita = new ArrayList<Questao>(){
        {
            add(new Questao("Em que ordem elas são classificadas?", R.id.rbResposta4,"Accipitriformes", "Falconiformes" , "Cathartiformes", "Strigiformes" ));
            add(new Questao("As corujas são conhecidas como simbolo da:", R.id.rbResposta1, "Sabedoria", "Ignorância", "Descrição", "Feitiçaria"));
            add(new Questao("Podem girar opescoço em até:", R.id.rbResposta1, "270º", "360º", "180º", "90º" ));
            add(new Questao("Qual a maior coruja do mundo?", R.id.rbResposta2, "Jarucututu (Bubo virginianus)","Bufo-Real", "Glaucidium Nanum", "Coruja-Serra-Afiada" ));
          }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generica);

        imgViewGenerica = (ImageView) findViewById(R.id.imgViewGenerica);

        txtPont = (TextView) findViewById(R.id.txtPont);
        pergunta = (TextView) findViewById(R.id.pergunta);
        rbResposta1 = (RadioButton) findViewById(R.id.rbResposta1);
        rbResposta2 = (RadioButton) findViewById(R.id.rbResposta2);
        rbResposta3 = (RadioButton) findViewById(R.id.rbResposta3);
        rbResposta4 = (RadioButton) findViewById(R.id.rbResposta4);
        rgRespostas = (RadioGroup) findViewById(R.id.rgRespostas);
        layoutGenerico = (RelativeLayout) findViewById(R.id.layoutGenerico);
        //METODO PARA CARREGAR AS FUNÇÕES
        carregarQuestao();


    }
    private void carregarQuestao(){
        Intent intent3 = getIntent();
        //METODO GETEXTRA CAPTURA O VALOR DO TIPO DA INTENT ANTERIOR
        tipo = intent3.getIntExtra("tipo", 0);
        apl = intent3.getStringExtra("apelido");

        if(tipo == 1){
            if(questoesGatitos.size() > 0) {
                //SETANDO A IMAGEM DE GATINHO NO IMAGVIEW GENERICO
                imgViewGenerica.setImageResource(R.drawable.miau);
                txtPont.setText("Pontos: "+pontos);
                Questao q1 = questoesGatitos.remove(0);
                pergunta.setText(q1.getPergunta());
                List<String> resposta = q1.getRespostas();
                rbResposta1.setText(resposta.get(0));
                rbResposta2.setText(resposta.get(1));
                rbResposta3.setText(resposta.get(2));
                rbResposta4.setText(resposta.get(3));
                respostaCerta = q1.getRespostaCerta();
                rgRespostas.setSelected(false);
            }
                else{ //acabaram as questões
                    Intent intent = new Intent(this, RespostaActivity.class);
                //METODO PUTEXTRA PARA PASSAR OS PONTOS PARA A PROXIMA ACTIVITY
                    intent.putExtra("pontos", pontos);
                    intent.putExtra("apelido", apl);
                    startActivity(intent);
                    finish();
                }
        }


            else if(tipo == 2){
               if(questoesCaozitos.size() > 0) {
                    imgViewGenerica.setImageResource(R.drawable.auau);
                    txtPont.setText("Pontos: "+pontos);
                    Questao q2 = questoesCaozitos.remove(0);
                    pergunta.setText(q2.getPergunta());
                    List<String> resposta = q2.getRespostas();
                    rbResposta1.setText(resposta.get(0));
                    rbResposta2.setText(resposta.get(1));
                    rbResposta3.setText(resposta.get(2));
                    rbResposta4.setText(resposta.get(3));
                    respostaCerta = q2.getRespostaCerta();
                    rgRespostas.setSelected(false);
                }
                else{ //acabaram as questões
                    Intent intent2 = new Intent(this, RespostaActivity.class);
                    intent2.putExtra("pontos", pontos);
                    intent2.putExtra("apelido", apl);
                    startActivity(intent2);
                    finish();
                }

            }
        else if(tipo == 3){

            if(questoesCorujita.size() > 0) {
                imgViewGenerica.setImageResource(R.drawable.owl);
                txtPont.setText("Pontos: "+pontos);
                Questao q3 = questoesCorujita.remove(0);
                pergunta.setText(q3.getPergunta());
                List<String> resposta = q3.getRespostas();
                rbResposta1.setText(resposta.get(0));
                rbResposta2.setText(resposta.get(1));
                rbResposta3.setText(resposta.get(2));
                rbResposta4.setText(resposta.get(3));
                respostaCerta = q3.getRespostaCerta();
                rgRespostas.setSelected(false);
            }
            else{ //acabaram as questões
                Intent intent4 = new Intent(this, RespostaActivity.class);
                intent4.putExtra("pontos", pontos);
                intent4.putExtra("apelido", apl);
                startActivity(intent4);
                finish();
            }

        }


    }

    @Override
    protected void onRestart(){
        super.onRestart();
        carregarQuestao();
    }
//METODO PARA CHECAR AS RESPOSTAS E ENVIAR O VALOR PARA A ACTIVITY RESPOSTACTIVITY
    public void btnResponderOnClick(View v){
        //PEGANDO O VALOR DO RADIOBUTTON
        RadioButton rb = (RadioButton)findViewById(rgRespostas.getCheckedRadioButtonId());
        Intent intent5 = new Intent(this, RespostaActivity.class);

        //PASSA O VALOR DA RESPOSTA CERTA OU ERRADA
        if(rgRespostas.getCheckedRadioButtonId() == respostaCerta) {
            intent5.putExtra("acertou", true);
            intent5.putExtra("apelido", apl);
            pontos++;
        }
        else
            intent5.putExtra("acertou", false);
            intent5.putExtra("pontos", pontos);
            intent5.putExtra("apelido", apl);
            startActivity(intent5);
            rb.setChecked(false);
    }
}
