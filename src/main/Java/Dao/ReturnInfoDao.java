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

    @SuppressWarnings("unchecked")
    public ReturnInfo viewEachReturnInfo(String regno, String bookId) {
        try {
            List<ReturnInfo> returnInfoList = em.createNamedQuery("viewEachIssued").setParameter("regno", regno).setParameter("bookId", bookId).getResultList();
            return returnInfoList.size() > 0 ? returnInfoList.get(0) : null;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<ReturnInfo> viewReturnInfo(ReturnInfo returnInfo) {
        try {
            return em.createNamedQuery("viewEachReturnInfo").setParameter("regno", returnInfo.getIssuedBook().getStudent().getRegNo()).setParameter("bookId", returnInfo.getIssuedBook().getBook().getBookId()).getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }

    }
}
