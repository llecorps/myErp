package com.dummy.myerp.model.bean.comptabilite;

import org.junit.Assert;
import org.junit.Test;

public class CompteComptableTest {

    @Test
    public void toStringCC() {
        CompteComptable vCompte = new CompteComptable();
        vCompte.setLibelle("libelle");
        vCompte.setNumero(123);


        Assert.assertEquals(vCompte.toString(),
                "CompteComptable" +
                "{numero=123, libelle='libelle'}");
    }
}
