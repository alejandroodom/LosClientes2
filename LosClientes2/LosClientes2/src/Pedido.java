import java.util.ArrayList;
public class Pedido {
    private Cliente cliente;
    private ArrayList<Obra> obras;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        obras = new ArrayList<Obra>();
    }

    public void agregarObra(Obra obra) {
        obras.add(obra);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Obra> getObras() {
        return obras;
    }
}
