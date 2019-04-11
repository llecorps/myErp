package com.dummy.myerp.consumer.dao.impl.db.dao;

import com.dummy.myerp.consumer.dao.contrat.ComptabiliteDao;
import com.dummy.myerp.model.bean.comptabilite.*;
import com.dummy.myerp.testconsumer.consumer.ConsumerTestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Created by TheAdmin on 16.03.2019.
 */
public class ComptabiliteDaoImplTest extends ConsumerTestCase {


    private ComptabiliteDao dao = getDaoProxy().getComptabiliteDao();
    private EcritureComptable vEcritureComptable = new EcritureComptable();
    private int dateAnnee;

    @Before
    public void init() {
        Date currentDate = new Date();
        dateAnnee = LocalDateTime.ofInstant(currentDate.toInstant(), ZoneId.systemDefault()).toLocalDate().getYear();
        vEcritureComptable.setJournal(new JournalComptable("OD", "Test_Insert"));
        vEcritureComptable.setReference("LL-2019/00077");
        vEcritureComptable.setDate(currentDate);
        vEcritureComptable.setLibelle("Test_Ecriture");

        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(401),
                "Line1", new BigDecimal(200),new BigDecimal(100)));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(411),
                "Line2", new BigDecimal(150),new BigDecimal(100)));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(512),
                "Line3", new BigDecimal(100),new BigDecimal(250)));
    }
    @Test
    public void getListCompteComptable() throws Exception {
        List<CompteComptable> vList = dao.getListCompteComptable();
        Assert.assertTrue(vList.size() >= 1);

    }


    @Test
    public void getListJournalComptable() throws Exception {
        List<CompteComptable> vList = dao.getListCompteComptable();
        Assert.assertTrue(vList.size() >= 1);

    }


    @Test
    public void getListEcritureComptable() {
        List<EcritureComptable> vList = dao.getListEcritureComptable();
        Assert.assertTrue(vList.size() >= 1);
    }


    @Test
    public void getEcritureComptable() throws Exception {

        EcritureComptable vEcritureComptable = dao.getEcritureComptable(-2);
        Assert.assertNotNull(vEcritureComptable);
    }
    @Test
    public void getEcritureComptableByRef() throws Exception {
        EcritureComptable vEcritureComptable = dao.getEcritureComptableByRef("VE-2016/00002");
        Assert.assertNotNull(vEcritureComptable);

    }

    @Test
    public void loadListLigneEcriture() throws Exception {
        EcritureComptable vEcriture  = new EcritureComptable();
        vEcriture.setId(-1);
        dao.loadListLigneEcriture(vEcriture);
        Assert.assertEquals(3, vEcriture.getListLigneEcriture().size());
    }


    @Test
    public void insertEcritureComptable() throws Exception {
        dao.insertEcritureComptable(vEcritureComptable);

        EcritureComptable pEcritureComptable = dao.getEcritureComptableByRef("LL-" + dateAnnee + "/00077");

        dao.deleteEcritureComptable(pEcritureComptable.getId());
        Assert.assertEquals(vEcritureComptable.getReference(), pEcritureComptable.getReference());
        Assert.assertEquals(vEcritureComptable.getLibelle(), pEcritureComptable.getLibelle());

    }





    @Test
    public void updateEcritureComptable() throws Exception {

        vEcritureComptable.setReference("LL-2019/0022");
        dao.insertEcritureComptable(vEcritureComptable);
        EcritureComptable ecriture = dao.getEcritureComptableByRef("LL-2019/0022");
        ecriture.setLibelle("update");
        dao.updateEcritureComptable(ecriture);
        Assert.assertEquals("update", ecriture.getLibelle());
        dao.deleteEcritureComptable(ecriture.getId());

    }


    @Test
    public void deleteEcritureComptable() throws Exception {

        Date currentDate = new Date();
        dateAnnee = LocalDateTime.ofInstant(currentDate.toInstant(), ZoneId.systemDefault()).toLocalDate().getYear();
        vEcritureComptable.setJournal(new JournalComptable("OD", "Remove"));
        vEcritureComptable.setReference("OD-2019/00044");
        vEcritureComptable.setDate(currentDate);
        vEcritureComptable.setLibelle("Remove");

        dao.insertEcritureComptable(vEcritureComptable);

        EcritureComptable bis = dao.getEcritureComptableByRef("OD-2019/00044");
        Assert.assertNotNull(bis);
        dao.deleteEcritureComptable(bis.getId());

    }



}