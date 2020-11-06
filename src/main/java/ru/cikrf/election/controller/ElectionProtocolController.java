package ru.cikrf.election.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cikrf.election.model.ElectionProtocol;
import ru.cikrf.election.services.ElectionProtocolService;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/protocols")
public class ElectionProtocolController {

    private ElectionProtocolService service;

    public ElectionProtocolController(final ElectionProtocolService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<ElectionProtocol> create(@RequestBody ElectionProtocol protocol) {
        return new ResponseEntity<>(this.service.create(protocol),
                HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Void> update (@RequestBody ElectionProtocol protocol) {
        this.service.update(protocol);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable int id) {
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElectionProtocol> findById (@PathVariable int id) {
        ElectionProtocol protocol = this.service.findById(id);
        return new ResponseEntity<>(
                protocol, protocol != null ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @GetMapping("/")
    public List<ElectionProtocol> findAll() {
        return new ArrayList<>(this.service.findAll());
    }
}
