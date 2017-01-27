package mx.edu.utng.ejemplo002;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText txtNombre, txtPeso, txtEstatura;
    CheckBox chEjercicio;
    RadioButton rdHombre, rdMujer;
    TextView txtResult;
    Button btnCalcular;
    Button btnLiampiar;
    Button prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se ralacionan los objetos del xml
        txtNombre=(EditText)findViewById(R.id.txtNombre);
        txtPeso=(EditText)findViewById(R.id.txtPeso);
        txtEstatura=(EditText)findViewById(R.id.txtEstatura);
        chEjercicio=(CheckBox)findViewById(R.id.chEjercicio);
        rdHombre=(RadioButton)findViewById(R.id.rdHombre);
        rdMujer=(RadioButton)findViewById(R.id.rdMujer);
        txtResult=(TextView)findViewById(R.id.txtResultado);
        btnCalcular=(Button)findViewById(R.id.bntCalcular);
        btnLiampiar=(Button)findViewById(R.id.btnLimpiar);
        prueba=(Button)findViewById(R.id.btnPrueba);

        //Asociar escucha al boton
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Persona p = new Persona();
                p.setNombre(txtNombre.getText().toString());
                p.setPeso(Double.parseDouble(txtPeso.getText().toString()));
                p.setEstatura(Double.parseDouble(txtEstatura.getText().toString()));
                if (chEjercicio.isChecked()){
                    p.setEjercicio((byte)1);
                }else{
                    p.setEjercicio((byte)0);
                }
                if(rdHombre.isChecked()){
                    p.setSexo('H');
                }else if(rdMujer.isChecked()){
                    p.setSexo('M');
                }else{
                    p.setSexo('X');
                }
                p.calcularImc();
                p.imcCalculado();
                txtResult.setText(p.toString());
                if (p.immc()<20){
                    Intent delgado=new Intent(MainActivity.this, Delgado1.class);
                    startActivity(delgado);
                }
                else if (p.immc() < 25){
                    Intent normal=new Intent(MainActivity.this, Normal1.class);
                    startActivity(normal);
                }else{
                    Intent gordo=new Intent(MainActivity.this, Gordo1.class);
                    startActivity(gordo);
                }
            }

        });

        prueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent acercaDe=new Intent(MainActivity.this, Main2Activity.class);
                startActivity(acercaDe);
            }
        });
        btnLiampiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNombre.setText("");
                txtPeso.setText("");
                txtEstatura.setText("");
                chEjercicio.setChecked(false);
                rdMujer.setChecked(false);
                rdHombre.setChecked(false);
                txtResult.setText("");
            }
        });


    }
}
