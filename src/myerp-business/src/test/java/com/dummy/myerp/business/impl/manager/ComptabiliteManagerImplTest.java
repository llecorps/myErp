package com.dummy.myerp.business.impl.manager;

import com.dummy.myerp.consumer.dao.impl.db.dao.ComptabiliteDaoImpl;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;
import com.dummy.myerp.technical.exception.FunctionalException;
import com.dummy.myerp.testbusiness.business.BusinessTestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static com.dummy.myerp.consumer.ConsumerHelper.getDaoProxy;


public class ComptabiliteManagerImplTest extends BusinessTestCase {

    private ComptabiliteManagerImpl manager = new ComptabiliteManagerImpl();
    private static ComptabiliteDaoImpl dao;
    private  EcritureComptable vEcritureComptable = new EcritureComptable();
    private static Date vCurrentDate;
    private static Integer vCurrentYear;






    @Before
    public void init() {

        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.setReference("AC-2019/00001");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(401),
                null, new BigDecimal(123),
                null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(411),
                null, null,
                new BigDecimal(123)));

    }



    @Test
    public void checkEcritureComptableUnit() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.setReference("AC-2019/00055");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                                                                                 null, new BigDecimal(123),
                                                                                 null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
                                                                                 null, null,
                                                                                 new BigDecimal(123)));
        manager.checkEcritureComptableUnit(vEcritureComptable);
    }

    @Test(expected = FunctionalException.class)
    public void checkEcritureComptableUnitViolation() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        manager.checkEcritureComptableUnit(vEcritureComptable);
    }

    @Test(expected = FunctionalException.class)
    public void checkEcritureComptableUnitRG2() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                                                                                 null, new BigDecimal(123),
                                                                                 null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
                                                                                 null, null,
                                                                                 new BigDecimal(1234)));
        manager.checkEcritureComptableUnit(vEcritureComptable);
    }

    @Test(expected = FunctionalException.class)
    public void checkEcritureComptableUnitRG3() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                                                                                 null, new BigDecimal(123),
                                                                                 null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                                                                                 null, new BigDecimal(123),
                                                                                 null));
        manager.checkEcritureComptableUnit(vEcritureComptable);
    }

    @Test
    public void checkEcritureComptableContext() throws FunctionalException {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.setReference("AC-2019/00001");
        manager.checkReference(vEcritureComptable);
    }

    @Test(expected = FunctionalException.class)
    public void checkEcritureComptableContextViolation() throws FunctionalException {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.setReference("AC-2010/00001");
        manager.checkReference(vEcritureComptable);
    }

    @Test
    public void getListCompteComptable() {
        List<CompteComptable> pList = getDaoProxy().getComptabiliteDao().getListCompteComptable();
        Assert.assertTrue(pList.size() >= 1);
    }

    @Test
    public void getListJournalComptable() {
        List<CompteComptable> pList = getDaoProxy().getComptabiliteDao().getListCompteComptable();
        Assert.assertTrue(pList.size() >= 1);
    }

    @Test
    public void getListEcritureComptable() {
        List<EcritureComptable> pList = getDaoProxy().getComptabiliteDao().getListEcritureComptable();
        Assert.assertTrue(pList.size() >= 1);
    }

    @Test
    public void addReference() throws Exception {
        EcritureComptable vEcritureComptable = new EcritureComptable();

        vEcritureComptable.setId(-1);
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new SimpleDateFormat("yyyy/MM/dd").parse("2016/12/31"));
        vEcritureComptable.setLibelle("Cartouches d’imprimante");

        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(606),
                "Cartouches d’imprimante", new BigDecimal(43),
                null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(4456),
                "TVA 20%", new BigDecimal(8),
                null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(401),
                "Facture F110001", null,
                new BigDecimal(51)));

        manager.addReference(vEcritureComptable);

     //   assertThrows(NotFoundException.class, () -> {
       //     vEcritureComptable.setDate(vCurrentDate);
         //   managerIntegration.addReference(vEcritureComptable);
        //});
    }

    @Test
    public void checkEcritureComptable() throws Exception {

        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();

        Date vCurrentDate = new Date();
        int vCurrentYear = LocalDateTime.ofInstant(vCurrentDate.toInstant(), ZoneId.systemDefault()).toLocalDate().getYear();

        vEcritureComptable.setJournal(new JournalComptable("VE", "Vente"));
        vEcritureComptable.setDate(vCurrentDate);
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.setReference("VE-2019/00044");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                null, new BigDecimal(123),
                null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
                null, null,
                new BigDecimal(123)));
        manager.checkEcritureComptable(vEcritureComptable);
    }

    @Test
    public void checkEcritureComptableUnitRG5() {

        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();

        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.setReference("AC-2019/00001");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(401),
                null, new BigDecimal(123),
                null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(411),
                null, null,
                new BigDecimal(123)));
    }

    @Test(expected = FunctionalException.class)
    public void checkEcritureComptableUnitRG2Violation() throws Exception {

        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();

        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.setReference("AC-2019/00001");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(401),
                null, new BigDecimal(123),
                null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(411),
                null, null,
                new BigDecimal(123)));

        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                null, new BigDecimal(123),
                null));

        manager.checkEcritureEquilibre(vEcritureComptable);
    }

    @Test(expected = FunctionalException.class)
    public void checkEcritureComptableUnitRG3Violation() throws Exception {
        EcritureComptable v = new EcritureComptable();
        v.setJournal(new JournalComptable("AC", "Achat"));
        v.setDate(new Date());
        v.setLibelle("Libelle");
        manager.checkNumLigneEcriture(v);
    }

    @Test
    public void insertEcritureComptable() throws Exception {
        manager.insertEcritureComptable(vEcritureComptable);
        EcritureComptable eb =
                getDaoProxy().getComptabiliteDao()
                        .getEcritureComptableByRef("AC-2019/00001");
        Assert.assertEquals("AC-2019/00001", eb.getReference());
        manager.deleteEcritureComptable(eb.getId());
    }

    @Test
    public void updateEcritureComptable() throws Exception {
        manager.insertEcritureComptable(vEcritureComptable);
        EcritureComptable eb =
                getDaoProxy().getComptabiliteDao()
                        .getEcritureComptableByRef("AC-2019/00001");
        Assert.assertEquals("AC-2019/00001", eb.getReference());
        eb.setReference("AC-2022/00055");
        manager.updateEcritureComptable(eb);
        Assert.assertEquals("AC-2022/00055", eb.getReference());
        manager.deleteEcritureComptable(eb.getId());
    }

    @Test
    public void deleteEcritureComptable() throws Exception {
        manager.insertEcritureComptable(vEcritureComptable);
        EcritureComptable eb =
                getDaoProxy().getComptabiliteDao()
                        .getEcritureComptableByRef("AC-2019/00001");
        manager.deleteEcritureComptable(eb.getId());
    }

}
