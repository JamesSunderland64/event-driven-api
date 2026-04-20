package listener;

import event.ProductoCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductoEventListener {

    @Async
    @EventListener
    public void handleProductoCreated(ProductoCreatedEvent event) {
        log.info("🚀 EVENTO EVENT-DRIVEN RECIBIDO (asíncrono) → Producto creado: {} - Precio ${}",
                event.getProducto().getNombre(),
                event.getProducto().getPrecio());

        // Simulación de tarea en segundo plano (para que veas que es asíncrono)
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        log.info("✅ Tarea en background completada para el producto ID: {}",
                event.getProducto().getId());
    }
}