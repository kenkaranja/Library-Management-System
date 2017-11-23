package Dao;

import Entities.ReturnInfo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class ReturnInfoDao extends CustomDao<ReturnInfo> {

    public ReturnInfoDao(EntityManager em) {
        super(em);
    }

    public boolean add(ReturnInfo returnInfo) {
        return this.addCustom(returnInfo);
    }

// --Commented out by Inspection START (11/6/2017 7:05 AM):
//    @SuppressWarnings("unchecked")
//    public ReturnInfo viewEachReturnInfo(String regno, String bookId) {
//        try {
//            List<ReturnInfo> returnInfoList = em.createNamedQuery("viewEachIssued").setParameter("regno", regno).setParameter("bookId", bookId).getResultList();
//            return returnInfoList.size() > 0 ? returnInfoList.get(0) : null;
//        } catch (PersistenceException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
// --Commented out by Inspection STOP (11/6/2017 7:05 AM)

    @SuppressWarnings("unchecked")
    public List<ReturnInfo> viewReturnInfo(ReturnInfo returnInfo) {
        try {
            return em.createNamedQuery("viewEachReturnInfo").setParameter("regno", returnInfo.getIssuedBook().getStudent().getRegNo()).setParameter("bookId", returnInfo.getIssuedBook().getBook().getBookId()).getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }

    }

    @SuppressWarnings("unchecked")
    public List<ReturnInfo> viewDebtInfo(ReturnInfo returnInfo) {
        try {
            return em.createNamedQuery("viewDebtInfo").setParameter("regno", returnInfo.getIssuedBook().getStudent().getRegNo()).getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public ReturnInfo viewDebtInfoO(ReturnInfo returnInfo) {
        try {
            List<ReturnInfo> returnInfos = em.createNamedQuery("viewDebtInfo").setParameter("regno", returnInfo.getIssuedBook().getStudent().getRegNo()).getResultList();
            return returnInfos.size() > 0 ? returnInfos.get(0) : null;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean payDebt(ReturnInfo returnInfo) {
        try {
            em.merge(returnInfo);
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public List<ReturnInfo> viewAllDebt() {
        try {
            return em.createNamedQuery("viewAllDebt").getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }
    }
}
