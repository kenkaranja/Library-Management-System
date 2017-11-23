package Interfaces;

import Entities.ReturnInfo;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ReturnInfoI {
    boolean add(ReturnInfo returnInfo);

    List<ReturnInfo> viewReturnInfo(ReturnInfo returnInfo);

    boolean payDebt(ReturnInfo returnInfo);

    List<ReturnInfo> viewAllDebt();

}
