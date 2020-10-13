package co.edu.unimagdalena.apmoviles.universidad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListadoActivity extends AppCompatActivity {

    ListView listado;
    EstudianteController estudianteController;
    private Context mCtx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        mCtx = this;
        listado = findViewById(R.id.lstlistado);
        estudianteController = new EstudianteController(this);
        Cursor c = estudianteController.allEstudiantes2();
        EstudianteCursorAdapter ecursor = new EstudianteCursorAdapter(this,c,false);
        listado.setAdapter(ecursor);
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView cod = view.findViewById(R.id.txtcodigo);
                TextView nom = view.findViewById(R.id.txtnombre);
                TextView prog = view.findViewById(R.id.txtprograma);
                //Toast.makeText(getApplicationContext(),cod.getText().toString()+" "+nom.getText().toString()+" "+prog.getText().toString(),Toast.LENGTH_LONG).show();
                Intent i = new Intent(mCtx, MainActivity.class);
                i.putExtra("codigoItem", cod.getText().toString());
                i.putExtra("nombreItem", nom.getText().toString());
                i.putExtra("programaItem", prog.getText().toString());
                startActivity(i);
            }
        });
    }
}
