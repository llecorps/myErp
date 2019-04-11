package com.dummy.myerp.consumer.dao.impl.db.dao;

import com.dummy.myerp.consumer.ConsumerHelper;
import com.dummy.myerp.consumer.dao.contrat.DaoProxy;
import com.dummy.myerp.consumer.dao.impl.db.rowmapper.comptabilite.SequenceEcritureComptableRM;
import com.dummy.myerp.model.bean.comptabilite.SequenceEcritureComptable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.ResultSet;
import java.sql.SQLException;

@RunWith(MockitoJUnitRunner.class)
public class SequenceEcritureComptableRMTest {

    @Mock
    private ResultSet resultSet;

    @Mock
    private DaoProxy daoProxy;

    @Before
    public void setUp(){
        ConsumerHelper.configure(daoProxy);
    }

    @Test
    public void mapRow() {

        SequenceEcritureComptableRM pSequenceEcritureComptableRM = new SequenceEcritureComptableRM();
        SequenceEcritureComptable pSequenceEcritureComptable = null;

        try {
            pSequenceEcritureComptable = pSequenceEcritureComptableRM.mapRow(resultSet, 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(pSequenceEcritureComptable);

    }

}
