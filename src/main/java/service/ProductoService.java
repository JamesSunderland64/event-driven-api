package service;

import model.Producto;
import event.ProductoCreatedEvent;
import repository.ProductoRepository;     // ←←← AGREGAR ESTA LÍNEA
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository repository;           // se detecta automáticamente
    private final ApplicationEventPublisher eventPublisher;

    public List<Producto> findAll() {
        return repository.findAll();
    }

    public Producto save(Producto producto) {
        Producto saved = repository.save(producto);
        eventPublisher.publishEvent(new ProductoCreatedEvent(this, saved));
        return saved;
    }

    public Producto findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}