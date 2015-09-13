package calculadora.com.br.calculadoraandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Andressa on 12/09/2015.
 */
public class tela_result extends AppCompatActivity implements View.OnClickListener{

    Button btnVol;
    TextView txtRe;

    public void addListener(){
        btnVol = (Button) findViewById(R.id.btnVoltar);
        this.btnVol.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_result);
        this.addListener();
        txtRe = (TextView) findViewById(R.id.txtResult);

        Intent intent = getIntent();
        Bundle params = intent.getExtras();


            String mostraTexto = params.getString("resul");
            txtRe.setText(mostraTexto);


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

        this.onBackPressed();

    }

}
