package com.dummy.myerp.consumer.dao.impl.db.dao;

import com.dummy.myerp.consumer.dao.contrat.ComptabiliteDao;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;
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
    @Before
    public void init() {
        Date currentDate = new Date();
        int currentYear = LocalDateTime.ofInstant(currentDate.toInstant(), ZoneId.systemDefault()).toLocalDate().getYear();
        vEcritureComptable.setJournal(new JournalComptable("OD", "TestInsert"));
        vEcritureComptable.setReference("TT-2019/00055");
        vEcritureComptable.setDate(currentDate);
        vEcritureComptable.setLibelle("Test");

        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(401),
                "Test1", new BigDecimal(200),new BigDecimal(100)));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(411),
                "Test2", new BigDecimal(150),new BigDecimal(100)));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(512),
                "Test3", new BigDecimal(100),new BigDecimal(250)));
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
    public void setSQLgetListEcritureComptable() throws Exception {

    }

    @Test
    public void setSQLgetEcritureComptable() throws Exception {

    }

    @Test
    public void getEcritureComptable() throws Exception {

        EcritureComptable vEcritureComptable = dao.getEcritureComptable(-2);
        Assert.assertNotNull(vEcritureComptable);
    }



    @Test
    public void setSQLgetEcritureComptableByRef() throws Exception {

        EcritureComptable vEcritureComptable = dao.getEcritureComptableByRef("VE-2016/00002");
        Assert.assertNotNull(vEcritureComptable);
    }
    @Test
    public void getEcritureComptableByRef() throws Exception {
        EcritureComptable vEcritureComptable = dao.getEcritureComptableByRef("VE-2016/00002");
        Assert.assertNotNull(vEcritureComptable);

    }

    @Test
    public void setSQLloadListLigneEcriture() throws Exception {

    }

    @Test
    public void loadListLigneEcriture() throws Exception {

    }

    @Test
    public void setSQLinsertEcritureComptable() throws Exception {

    }

    @Test
    public void insertEcritureComptable() throws Exception {

    }

    @Test
    public void setSQLinsertListLigneEcritureComptable() throws Exception {

    }

    @Test
    public void insertListLigneEcritureComptable() throws Exception {

    }

    @Test
    public void setSQLupdateEcritureComptable() throws Exception {

    }

    @Test
    public void updateEcritureComptable() throws Exception {

    }

    @Test
    public void setSQLdeleteEcritureComptable() throws Exception {

    }

    @Test
    public void deleteEcritureComptable() throws Exception {

    }

    @Test
    public void setSQLdeleteListLigneEcritureComptable() throws Exception {

    }

    @Test
    public void deleteListLigneEcritureComptable() throws Exception {

    }

}