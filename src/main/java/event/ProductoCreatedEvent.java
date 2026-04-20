package event;

import model.Producto;
import org.springframework.context.ApplicationEvent;

public class ProductoCreatedEvent extends ApplicationEvent {

    private final Producto producto;

    public ProductoCreatedEvent(Object source, Producto producto) {
        super(source);
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }
}