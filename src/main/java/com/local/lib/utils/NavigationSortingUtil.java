package com.local.lib.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hdc.sysdev.utils.beans.NavigationBean;

public class NavigationSortingUtil
{

    public NavigationSortingUtil()
    {
    }

    public static String getSortingDirection(String sessionAlias, HttpServletRequest request)
    {
        String result = "";
        String state = "";
        HttpSession session = request.getSession();
        if(session.getAttribute(sessionAlias) == null)
            session.setAttribute(sessionAlias, "desc");
        state = (String)session.getAttribute(sessionAlias);
        if(state.equals("desc"))
            result = "asc";
        if(state.equals("asc"))
            result = "desc";
        session.setAttribute(sessionAlias, result);
        return result;
    }

    public static NavigationBean getNavigationLimits(int currentPageNo, int numOfRowToShow, int dataRowNum)
    {
        NavigationBean navigationBean = new NavigationBean();
        int lastRowNo = 0;
        if(dataRowNum % numOfRowToShow == 0)
            lastRowNo = dataRowNum / numOfRowToShow;
        else
            lastRowNo = dataRowNum / numOfRowToShow + 1;
        if(numOfRowToShow > dataRowNum)
            numOfRowToShow = dataRowNum;
        int startNavigationRowNo = currentPageNo * numOfRowToShow;
        int endNavigationRowNo = startNavigationRowNo + numOfRowToShow;
        if(endNavigationRowNo > dataRowNum)
            endNavigationRowNo = dataRowNum;
        navigationBean.setStartNavigationRowNo(startNavigationRowNo);
        navigationBean.setEndNavigationRowNo(endNavigationRowNo);
        navigationBean.setLastRowNo(lastRowNo);
        return navigationBean;
    }

    public static int getPageNo(String formAction, int pageNo)
    {
        if(formAction.equals("Next"))
            pageNo++;
        else
        if(formAction.equals("Previous"))
            pageNo--;
        return pageNo;
    }
}