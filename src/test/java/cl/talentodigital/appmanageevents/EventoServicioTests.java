package cl.talentodigital.appmanageevents;

import cl.talentodigital.appmanageevents.entities.Evento;
import cl.talentodigital.appmanageevents.repositories.EventoRepositorio;
import cl.talentodigital.appmanageevents.services.EventoServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ComponentScan(basePackages = "cl.talentodigital.appmanageevents")
class EventoServicioTests {

    @Autowired
    private EventoRepositorio eventoRepositorio;

    @Autowired
    private EventoServicio eventoServicio;

    @BeforeEach
    void setUp() {
        eventoRepositorio.deleteAll();
    }


    @Test
    void testListAllWithKeyword() {
        Evento evento1 = new Evento();
        evento1.setNombre("Concierto 1");
        Evento evento2 = new Evento();
        evento2.setNombre("Concierto 2");
        eventoRepositorio.save(evento1);
        eventoRepositorio.save(evento2);

        List<Evento> eventos = eventoServicio.listAll("Concierto");

        assertEquals(2, eventos.size());
    }

    @Test
    void testListAllWithoutKeyword() {
        Evento evento1 = new Evento();
        evento1.setNombre("Evento 1");
        Evento evento2 = new Evento();
        evento2.setNombre("Evento 2");
        eventoRepositorio.save(evento1);
        eventoRepositorio.save(evento2);

        List<Evento> eventos = eventoServicio.listAll(null);

        assertEquals(2, eventos.size());
    }

    @Test
    void testSave() {
        Evento evento = new Evento();
        evento.setNombre("Nuevo Evento");

        eventoServicio.save(evento);

        assertNotNull(evento.getId());
        assertEquals(1, eventoRepositorio.findAll().size());
    }

    @Test
    void testGet() {
        Evento evento = new Evento();
        evento.setNombre("Evento Existente");
        eventoRepositorio.save(evento);

        Evento result = eventoServicio.get(evento.getId());

        assertNotNull(result);
        assertEquals("Evento Existente", result.getNombre());
    }

    @Test
    void testDelete() {
        Evento evento = new Evento();
        evento.setNombre("Evento a Eliminar");
        eventoRepositorio.save(evento);

        eventoServicio.delete(evento.getId());

        assertTrue(eventoRepositorio.findAll().isEmpty());
    }
}