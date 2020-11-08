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
        Candidate first = new Candidate("Батехтин", "Виктор",
                "Васильевич", 826);
        Candidate second = new Candidate("Никитин", "Андрей",
                "Андреевич", 975);
        Candidate third = new Candidate("Понамарев", "Сергей",
                "Викторович", 729);
        Candidate forth = new Candidate("Уйба", "Владимир",
                "Викторович", 7589);
        List<Candidate> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);
        list.add(forth);
        create(new ElectionProtocol("Выборы главы республики Коми",
                "01.01.2020",
                62052,
                45950,
                6098,
                4559,
                228,
                35064,
                6316,
                4554,
                751,
                10119,
                2,
                1,
                list));
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
