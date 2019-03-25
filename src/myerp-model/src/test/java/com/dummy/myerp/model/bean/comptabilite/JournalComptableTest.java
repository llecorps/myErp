package com.dummy.myerp.model.bean.comptabilite;

import org.junit.Assert;
import org.junit.Test;

public class JournalComptableTest {

    @Test
    public void toStringJC() {

        JournalComptable vJournal = new JournalComptable();
        vJournal.setCode("RTY");
        vJournal.setLibelle("libelle");

        Assert.assertEquals(vJournal.toString(),
                "JournalComptable" +
                        "{code='RTY', libelle='libelle'}");
    }
}
