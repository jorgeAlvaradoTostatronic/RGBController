package tostatronic.com.rgbcontroller.RGB;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;
import java.util.zip.Inflater;

import tostatronic.com.rgbcontroller.R;

/**
 * Created by Jorge on 12/12/2017.
 */

public class AdaptadorFuncion extends RecyclerView.Adapter<AdaptadorFuncion.ViewHolder>
{
    private View.OnClickListener onClickListener;
    LayoutInflater inflador;
    protected Vector<RGBController> vectorFunciones;
    private Context context;
    public AdaptadorFuncion(Context context, Vector<RGBController> vectorFunciones)
    {
        inflador=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.vectorFunciones=vectorFunciones;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflador.inflate(R.layout.elemento_selector,null);
        v.setOnClickListener(onClickListener);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RGBController funcion = vectorFunciones.get(position);
        holder.titulo.setText(funcion.nombre);
        holder.elementos.setText(funcion.ObtenInformacionPrimaria());
        int c = getIntFromColor(funcion.ObtenElemento(0).getR(),funcion.ObtenElemento(0).getG(),funcion.ObtenElemento(0).getB());
        holder.colorR.setBackgroundColor(c);
    }

    @Override
    public int getItemCount() {
        return vectorFunciones.size();
    }
    int getIntFromColor(int Red, int Green, int Blue){
        Red = (Red << 16) & 0x00FF0000; //Shift red 16-bits and mask out other stuff
        Green = (Green << 8) & 0x0000FF00; //Shift Green 8-bits and mask out other stuff
        Blue = Blue & 0x000000FF; //Mask out anything not blue.

        return 0xFF000000 | Red | Green | Blue; //0xFF000000 for 100% Alpha. Bitwise OR everything together.
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView titulo;
        public TextView elementos;
        public ImageView colorR;
        public ViewHolder(View itemView)
        {
            super(itemView);
            titulo=(TextView)itemView.findViewById(R.id.txtNombreFuncion);
            elementos=(TextView)itemView.findViewById(R.id.txtElementos);
            colorR=(ImageView)itemView.findViewById(R.id.imgVColor);
        }
    }
}
