package tostatronic.com.rgbcontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import tostatronic.com.rgbcontroller.RGB.AdaptadorFuncion;
import tostatronic.com.rgbcontroller.RGB.FuncionRGB;

public class Splash extends AppCompatActivity {
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FuncionRGB funcionRGB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        funcionRGB=new FuncionRGB();
        AdaptadorFuncion adapter = new AdaptadorFuncion(this,funcionRGB.ObtenFunciones());
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Splash.this,"Selecciono el elemento" + recyclerView.getChildAdapterPosition(view),Toast.LENGTH_SHORT).show();
            }
        });

        //Falta codigo para mostrar los datos
    }
}
