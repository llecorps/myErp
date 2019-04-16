package com.dummy.myerp.model.bean.comptabilite;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CompteComptableTest {



    @Test
    public void toStringCC() {
        CompteComptable vCompte = new CompteComptable();
        vCompte.setLibelle("libelle");
        vCompte.setNumero(123);


        assertEquals(vCompte.toString(),
                "CompteComptable" +
                "{numero=123, libelle='libelle'}");
    }
    @Test
    public void getByNumero() {
        CompteComptable vCompte = new CompteComptable();
        List<CompteComptable> vList;
        vCompte = new CompteComptable();
        vCompte.setNumero(401);
        vCompte.setLibelle("Fournisseurs");
        vList = new ArrayList<>(0);
        vList.add(vCompte);
        vList.add(new CompteComptable(411, "Clients"));
        assertEquals(CompteComptable.getByNumero(vList, 401), vCompte);
    }
}
