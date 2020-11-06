package ru.cikrf.election.utils;

import org.springframework.stereotype.Component;
import ru.cikrf.election.model.Candidate;
import ru.cikrf.election.model.ElectionProtocol;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

@Component
public class SimpleCalculation implements Calculation {
    @Override
    public void calculatePercent(ElectionProtocol protocol, List<Candidate> candidates) {

        int staticBoxes = protocol.getStaticBoxesBulletins();
        int mobileBoxes = protocol.getMobileBoxesBulletins();

        for (Candidate person: candidates) {
            double percent = round(person.getNumOfVotes() / ((staticBoxes + mobileBoxes) * 0.01f));
            person.setPercentOfTotal(percent);
        }
    }

    private double round(double value) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        return Double.parseDouble(df.format(value).replace(",", "."));
    }
}
