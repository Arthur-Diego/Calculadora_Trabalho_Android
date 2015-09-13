package calculadora.com.br.calculadoraandroid;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class tela_calculadora extends AppCompatActivity implements View.OnClickListener {


    final Context context = this;
    Button btnA;
    Button btnS;
    Button btnM;
    Button btnD;
    Button btnR;
    Button btnP;
    private EditText txtV1;
    private EditText txtV2;
    private TextView txtRes;
    private tela_result tela_re;

    /**
     * Metodo que cria um intenção
     * Cria um pacote de dados
     * Converte o seu resultado em String
     * Adiciona ao map(bundle)
     * Adiciona a intenção os valores passados para o MAP
     * E chama a activity selecionada a (Segunda Tela)
     *
     * @param result resultado da operacao
     */
    public void transferData(double result) {

        Intent telaSec = new Intent(this, tela_result.class);
        Bundle dados = new Bundle();
        String resultado = String.valueOf(result);
        dados.putString("resul", resultado);
        telaSec.putExtras(dados);
        startActivity(telaSec);

    }

    /**
     * Metodo que adiciona os botoes a lista de eventos (OnClickListener)
     */
    public void addListener() {

        btnA = (Button) findViewById(R.id.btnAdicao);
        btnS = (Button) findViewById(R.id.btnSubtracao);
        btnM = (Button) findViewById(R.id.btnMultiplica);
        btnD = (Button) findViewById(R.id.btnDivisao);
        btnR = (Button) findViewById(R.id.btnRaiz);
        btnP = (Button) findViewById(R.id.btnPotencia);
        this.btnA.setOnClickListener(this);
        this.btnS.setOnClickListener(this);
        this.btnM.setOnClickListener(this);
        this.btnD.setOnClickListener(this);
        this.btnR.setOnClickListener(this);
        this.btnP.setOnClickListener(this);

    }

    /**
     * Metodo que calcula as operações escolhidas de acordo com os
     * botões apertados
     *
     * @param id parametro do Id do botao
     * @return retorna um resultado mediante a operação escolhida
     */
    public void calcOperations(int id) {

        this.txtV1 = (EditText) findViewById(R.id.txtValor1);
        this.txtV2 = (EditText) findViewById(R.id.txtValor2);


        String txt1 = txtV1.getText().toString();
        String txt2 = txtV2.getText().toString();
        if (txt1.trim().isEmpty() || txt2.trim().isEmpty()) {

            AlertDialog.Builder diag = new AlertDialog.Builder(this);
            diag.setMessage("Há dados em branco");
            diag.setNeutralButton("OK", null);
            diag.show();

        } else {

            double v1 = Double.parseDouble(txtV1.getText().toString());
            double v2 = Double.parseDouble(txtV2.getText().toString());
            double result = 0;

            if (this.btnD.getId() == id) {

                result = v1 / v2;
                this.transferData(result);

            }
            if (this.btnS.getId() == id) {

                result = v1 - v2;
                this.transferData(result);

            }
            if (this.btnM.getId() == id) {

                result = v1 * v2;
                this.transferData(result);

            }
            if (this.btnA.getId() == id) {

                result = v1 + v2;
                this.transferData(result);

            }

        }
    }

    public void calcResultEspecialRaiz(int id) {

        this.txtV1 = (EditText) findViewById(R.id.txtValor1);
        this.txtV2 = (EditText) findViewById(R.id.txtValor2);

        String txt1 = txtV1.getText().toString();

        if (txt1.trim().isEmpty()) {

            AlertDialog.Builder diag = new AlertDialog.Builder(this);
            diag.setMessage("Há dados em branco");
            diag.setNeutralButton("OK", null);
            diag.show();

        } else {

            double v1 = Double.parseDouble(txtV1.getText().toString());
            double result = 0;

            if (this.btnR.getId() == id) {

                result = Math.sqrt(v1);
                this.transferData(result);

            }
        }
    }

    public void calcResultEspecialPotencia(int id) {

        this.txtV1 = (EditText) findViewById(R.id.txtValor1);
        this.txtV2 = (EditText) findViewById(R.id.txtValor2);

        String txt1 = txtV1.getText().toString();
        String txt2 = txtV2.getText().toString();

        if (txt1.trim().isEmpty() || txt2.trim().isEmpty()) {

            AlertDialog.Builder diag = new AlertDialog.Builder(this);
            diag.setMessage("Há dados em branco");
            diag.setNeutralButton("OK", null);
            diag.show();

        } else {

            double v1 = Double.parseDouble(txtV1.getText().toString());
            double v2 = Double.parseDouble(txtV2.getText().toString());
            double result = 0;
            if (this.btnP.getId() == id) {
                result = Math.pow(v1, v2);
                this.transferData(result);

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_calculadora);

        this.addListener();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tela_calculadora, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == btnA.getId()) {
            this.calcOperations(btnA.getId());
        }
        if (view.getId() == btnS.getId()) {
            this.calcOperations(btnS.getId());
        }
        if (view.getId() == btnM.getId()) {
            this.calcOperations(btnM.getId());
        }
        if (view.getId() == btnD.getId()) {
            this.calcOperations(btnD.getId());
        }
        if (view.getId() == btnR.getId()) {
            this.calcResultEspecialRaiz(btnR.getId());
        }
        if (view.getId() == btnP.getId()) {
            this.calcResultEspecialPotencia(btnP.getId());
        }
    }
}
