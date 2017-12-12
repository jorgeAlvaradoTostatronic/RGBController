package tostatronic.com.rgbcontroller.RGB;

import java.util.Vector;

/**
 * Created by Jorge on 11/12/2017.
 */

public class RGBController
{
    Vector<RGB> rgbElements = new Vector<>();
    int idFuncion;
    String nombre;
    public RGBController(int idFuncion){this.idFuncion=idFuncion;}
    public RGBController(int idFuncion, String nombre)
    {
        this.idFuncion=idFuncion;
        this.nombre=nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public Vector<RGB> getRgbElements() {
        return rgbElements;
    }
    public void InsertarElemento(RGB element)
    {
        rgbElements.add(element);
    }
    public RGB ObtenElemento(int pos)
    {
        RGB newElement= new RGB(false);
        if(pos<rgbElements.size())
            newElement = rgbElements.get(pos);
        return newElement;
    }
    public Vector<RGB> ObtenTodosLosElementos()
    {
        return rgbElements;
    }
    public String ObtenInformacionPrimaria()
    {
        String info;
        info="# Colores: "+String.valueOf(rgbElements.size());
        info+=" Tiempo: "+String.valueOf(ObtenTiempoTotal());
        return info;
    }
    private int ObtenTiempoTotal()
    {
        int tiempo=0;
        for (RGB aux:rgbElements)
        {
            tiempo+=aux.tiempo;
        }
        return tiempo;
    }
}
