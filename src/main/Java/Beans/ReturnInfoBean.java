package Beans;

import Dao.ReturnInfoDao;
import Entities.ReturnInfo;
import Interfaces.ReturnInfoI;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless
public class ReturnInfoBean implements ReturnInfoI {
    @PersistenceContext
    private EntityManager em;

    public boolean add(ReturnInfo returnInfo) {
        ReturnInfoDao returnInfoDao = new ReturnInfoDao(em);
        return returnInfoDao.add(returnInfo);
    }

    public List<ReturnInfo> viewReturnInfo(ReturnInfo returnInfo) {
        ReturnInfoDao returnInfoDao = new ReturnInfoDao(em);
        return returnInfoDao.viewReturnInfo(returnInfo);
    }
}
