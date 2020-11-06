package ru.cikrf.election.services;

import org.springframework.stereotype.Service;
import ru.cikrf.election.model.ElectionProtocol;
import ru.cikrf.election.repository.MemStore;

import java.util.Collection;

@Service
public class ElectionProtocolService {

    private MemStore memStore;

    public ElectionProtocolService(final MemStore memStore) {
        this.memStore = memStore;
    }

    public ElectionProtocol create(ElectionProtocol protocol) {
        return this.memStore.create(protocol);
    }
    public void update (ElectionProtocol protocol) {
        this.memStore.update(protocol);
    }
    public void delete (int id) {
        this.memStore.delete(id);
    }
    public ElectionProtocol findById (int id) {
        return this.memStore.findById(id);
    }
    public Collection<ElectionProtocol> findAll() {
        return this.memStore.findAll();
    }

}
