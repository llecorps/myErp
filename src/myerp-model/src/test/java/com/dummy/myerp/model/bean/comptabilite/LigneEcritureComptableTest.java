package com.dummy.myerp.model.bean.comptabilite;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class LigneEcritureComptableTest {

    @Test
    public void toStringLEC() {
        LigneEcritureComptable vLine = new LigneEcritureComptable();
        vLine.setCompteComptable(null);
        vLine.setLibelle("libelle");
        vLine.setCredit(BigDecimal.valueOf(10));
        vLine.setDebit(null);

        Assert.assertEquals(vLine.toString(),
                "LigneEcritureComptable" +
                "{compteComptable=null, libelle='libelle', debit=null, credit=10}");
    }
}
