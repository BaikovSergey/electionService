package ru.cikrf.election.repository;

import ru.cikrf.election.model.ElectionProtocol;

import java.util.Collection;

public interface Store {
    ElectionProtocol create(ElectionProtocol protocol);
    void update (ElectionProtocol protocol);
    void delete (int id);
    ElectionProtocol findById (int id);
    Collection<ElectionProtocol> findAll();
}
