package cl.inacap.testproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private String nombres;
    private String apellidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.nombres = getIntent().getStringExtra("varNombres");
        this.apellidos = getIntent().getStringExtra("varApellidos");

        TextView txtDatos = (TextView) findViewById(R.id.txtDatos);
        txtDatos.setText(this.nombres + " " + this.apellidos);
    }
}
