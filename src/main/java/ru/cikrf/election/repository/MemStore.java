package ru.cikrf.election.repository;

import org.springframework.stereotype.Repository;
import ru.cikrf.election.model.Candidate;
import ru.cikrf.election.model.ElectionProtocol;
import ru.cikrf.election.utils.SimpleCalculation;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemStore implements Store {

    private final List<ElectionProtocol> protocols = new ArrayList<>();

    private SimpleCalculation calculation = new SimpleCalculation();

    public MemStore() {

    }

    @Override
    public ElectionProtocol create(ElectionProtocol protocol) {
        calculation.calculatePercent(protocol, protocol.getCandidates());
        this.protocols.add(protocol);
        protocol.setId(this.protocols.indexOf(protocol));
        return protocol;
    }

    @Override
    public void update(ElectionProtocol protocol) {
        int index = protocol.getId();
        this.protocols.add(index, protocol);
    }

    @Override
    public void delete(int id) {
        this.protocols.remove(id);
    }

    @Override
    public ElectionProtocol findById(int id) {
        ElectionProtocol result = null;
        if (this.protocols.get(id) != null) {
            result = this.protocols.get(id);
        }
        return result;
    }

    @Override
    public List<ElectionProtocol> findAll() {
        return this.protocols;
    }
}
