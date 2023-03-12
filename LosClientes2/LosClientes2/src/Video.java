public class Video extends Obra {
    private int duracion;

    public Video(String titulo, String autor, int duracion) {
        super(titulo, autor);
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        int horas = duracion / 60;
        int minutos = duracion % 60;
        return "Vídeo " + titulo + " de " + autor + " (" + horas + "h" + minutos + ")";
    }
}
