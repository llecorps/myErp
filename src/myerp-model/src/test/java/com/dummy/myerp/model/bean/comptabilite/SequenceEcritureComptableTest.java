package com.dummy.myerp.model.bean.comptabilite;

import org.junit.Assert;
import org.junit.Test;

public class SequenceEcritureComptableTest {

    @Test
    public void toStringSeq() {
        SequenceEcritureComptable vSeq = new SequenceEcritureComptable();
        vSeq.setAnnee(2018);
        vSeq.setDerniereValeur(1);

        Assert.assertEquals(vSeq.toString(),
                "SequenceEcritureComptable" +
                        "{annee=2018, derniereValeur=1}");
    }
}
