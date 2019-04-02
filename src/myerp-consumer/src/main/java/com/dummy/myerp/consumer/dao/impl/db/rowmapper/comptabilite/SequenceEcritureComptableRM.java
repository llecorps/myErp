package com.dummy.myerp.consumer.dao.impl.db.rowmapper.comptabilite;

/**
 * Created by TheAdmin on 18.03.2019.
 */
import com.dummy.myerp.model.bean.comptabilite.SequenceEcritureComptable;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SequenceEcritureComptableRM implements RowMapper<SequenceEcritureComptable> {
    @Override
    public SequenceEcritureComptable mapRow(ResultSet rs, int pRowNum) throws SQLException {
        SequenceEcritureComptable sequence = new SequenceEcritureComptable();
        sequence.setAnnee(rs.getInt("annee"));
        sequence.setDerniereValeur(rs.getInt("derniere_valeur"));

        return sequence;
    }

}