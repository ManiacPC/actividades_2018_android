package cl.inacap.testproject;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String nombres;
    private String apellidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void obtenerNombresApellidos() {
        EditText editNombres = (EditText) findViewById(R.id.editNombre);
        EditText editApellidos = (EditText) findViewById(R.id.editApellidos);
        this.nombres = editNombres.getText().toString();
        this.apellidos = editApellidos.getText().toString();
    }

    public void btnMensaje_onClick(View view) {
        obtenerNombresApellidos();

        // P.ej.: Bienvenido Enrique Palacios
        mostrarMensaje("Bienvenido " + this.nombres + " " + this.apellidos);
    }

    public void btnTostada_onClick(View view) { // DRY
        obtenerNombresApellidos();

        mostrarTostada("Bienvenido " + this.nombres + " " + this.apellidos);
    }

    public void btnDetalles_onClick(View view) {
        obtenerNombresApellidos();

        Intent i = new Intent(this, DetailsActivity.class);
        i.putExtra("varNombres", this.nombres);
        i.putExtra("varApellidos", this.apellidos);
        startActivity(i);
        // finish(); // SI DESEO QUE LA ACTIVIDAD ACTUAL SE CIERRE AL ABRIR LA OTRA
    }

    private void mostrarTostada(String mensaje) {
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
    }

    private void mostrarMensaje(String mensaje) {
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setMessage(mensaje).setTitle("Saludo");
        AlertDialog dialogo = alerta.create();
        dialogo.show();
    }
}
