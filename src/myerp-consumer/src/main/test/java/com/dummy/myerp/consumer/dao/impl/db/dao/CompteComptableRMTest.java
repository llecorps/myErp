package com.dummy.myerp.consumer.dao.impl.db.dao;

import com.dummy.myerp.consumer.dao.impl.db.rowmapper.comptabilite.CompteComptableRM;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.ResultSet;
import java.sql.SQLException;

@RunWith(MockitoJUnitRunner.class)
public class CompteComptableRMTest {

    @Mock
    private ResultSet resultSet;

    @Test
    public void mapRow() {

        CompteComptableRM pCompteComptableRM = new CompteComptableRM();
        CompteComptable pCompteComptable = null;

        try {

            Mockito.when(resultSet.getInt("numero")).thenReturn(5);
            Mockito.when(resultSet.getString("libelle")).thenReturn("Facture");

            pCompteComptable = pCompteComptableRM.mapRow(resultSet, 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(pCompteComptable);
    }

}
