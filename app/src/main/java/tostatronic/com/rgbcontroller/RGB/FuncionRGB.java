package tostatronic.com.rgbcontroller.RGB;

import java.util.Random;
import java.util.Vector;

/**
 * Created by Jorge on 11/12/2017.
 */

public class FuncionRGB
{
    Vector<RGBController> funciones = new Vector<>();
    public FuncionRGB(){Inicializa();}
    private void Inicializa()
    {
        RGBController nuevaFuncion;
        Random r = new Random();
        int numeroDeColores=r.nextInt(10-2)+2;
        int ra,ga, ba,time;
        for(int i=0;i<10;i++)
        {
            nuevaFuncion=new RGBController(i,String.valueOf(i+1));
            for(int y=0;y<numeroDeColores;y++)
            {
                ra=r.nextInt(255-30)+30;
                ga=r.nextInt(255-30)+30;
                ba=r.nextInt(255-30)+30;
                time=r.nextInt(10-3)+3;
                nuevaFuncion.InsertarElemento(new RGB(ra,ga,ba,time));
            }
            funciones.add(nuevaFuncion);
        }

    }
    public void InsertaNuevaFuncion(RGBController funcion)
    {
        funciones.add(funcion);
        //Aqui se agregara la parte de SQLite patra agregar los elementos a la base de datos
    }
    public Vector<RGBController> ObtenFunciones()
    {
        return funciones;
    }
    public RGBController ObtenFuncion(int pos)
    {
        RGBController newElement = new RGBController(-1);
        if(pos<funciones.size())
            newElement=funciones.get(pos);
        return newElement;
    }
    public RGBController ObtenFuncion(String nombre)
    {
        RGBController newElement = new RGBController(-1);
        for (RGBController aux: funciones)
        {
            if(aux.nombre.equals(nombre))
            {
                newElement = aux;
                break;
            }
        }
        return newElement;
    }
}
