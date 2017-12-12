package tostatronic.com.rgbcontroller.RGB;

/**
 * Created by Jorge on 11/12/2017.
 */

public class RGB
{
    int r,g,b,tiempo;
    boolean valido;
    public RGB(int r, int g, int b, int tiempo)
    {
        this.r=r;
        this.g=g;
        this.b=b;
        this.tiempo=tiempo;
        valido=true;
    }
    public RGB (boolean valido)
    {
        this.valido=valido;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getB() {
        return b;
    }

    public int getG() {
        return g;
    }

    public int getR() {
        return r;
    }

    public int getTiempo() {
        return tiempo;
    }
}
