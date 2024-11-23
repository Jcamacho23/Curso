package tech.codestrux.sca.models;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;

import java.util.HashMap;
import java.util.Map;

@SpringComponent
@VaadinSessionScope
public class Prueba {
    private String nombre;
    private Map<Integer, String> respuestas;

    public Prueba() {
        respuestas = new HashMap<>();
    }

    public String getNombre() {
        if (nombre == null) {
            return "";
        }
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Map<Integer, String> getRespuestas() {
        return respuestas;
    }
}
