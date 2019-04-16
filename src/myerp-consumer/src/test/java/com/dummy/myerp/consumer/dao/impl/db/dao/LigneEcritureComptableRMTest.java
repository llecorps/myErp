package com.dummy.myerp.consumer.dao.impl.db.dao;

import com.dummy.myerp.consumer.ConsumerHelper;
import com.dummy.myerp.consumer.dao.contrat.ComptabiliteDao;
import com.dummy.myerp.consumer.dao.contrat.DaoProxy;
import com.dummy.myerp.consumer.dao.impl.db.rowmapper.comptabilite.LigneEcritureComptableRM;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;


@RunWith(MockitoJUnitRunner.class)
public class LigneEcritureComptableRMTest {

    @Mock
    private ResultSet resultSet;

    @Mock
    private static ComptabiliteDao comptabiliteDao;

    @Mock
    private DaoProxy daoProxy;

    @Before
    public void setUp(){
        ConsumerHelper.configure(daoProxy);
        Mockito.when(daoProxy.getComptabiliteDao()).thenReturn(comptabiliteDao);
    }

    @Test
    public void mapRow() {

        LigneEcritureComptableRM pLigneEcritureComptableRM = new LigneEcritureComptableRM();
        LigneEcritureComptable pLigneEcritureComptable = null;

        try {

            Mockito.when(resultSet.getBigDecimal("credit")).thenReturn(BigDecimal.valueOf(120));
            Mockito.when(resultSet.getBigDecimal("debit")).thenReturn(BigDecimal.valueOf(120));
            Mockito.when(resultSet.getString("libelle")).thenReturn("Total");

            pLigneEcritureComptable = pLigneEcritureComptableRM.mapRow(resultSet, 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(pLigneEcritureComptable);


    }

}
