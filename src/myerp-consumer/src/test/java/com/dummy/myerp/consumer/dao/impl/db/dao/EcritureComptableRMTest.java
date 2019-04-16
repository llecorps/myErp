package com.dummy.myerp.consumer.dao.impl.db.dao;


import com.dummy.myerp.consumer.ConsumerHelper;
import com.dummy.myerp.consumer.dao.contrat.ComptabiliteDao;
import com.dummy.myerp.consumer.dao.contrat.DaoProxy;
import com.dummy.myerp.consumer.dao.impl.db.rowmapper.comptabilite.EcritureComptableRM;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.ResultSet;
import java.sql.SQLException;

@RunWith(MockitoJUnitRunner.class)
public class EcritureComptableRMTest {

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

        EcritureComptableRM pEcritureComptableRM = new EcritureComptableRM();
        EcritureComptable pEcritureComptable = null;

        try {

            Mockito.when(resultSet.getInt("id")).thenReturn(5);
            Mockito.when(resultSet.getString("journal_code")).thenReturn("VE");
            Mockito.when(resultSet.getString("reference")).thenReturn("ref");
            Mockito.when(resultSet.getString("libelle")).thenReturn("lib");
            Mockito.when(resultSet.getString("journal_code")).thenReturn("VE");

            pEcritureComptable = pEcritureComptableRM.mapRow(resultSet, 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(pEcritureComptable);

    }

}
