package com.local.lib.beans;

import java.io.Serializable;

public class NavigationBean
    implements Serializable
{

    public NavigationBean()
    {
    }

    public int getEndNavigationRowNo()
    {
        return endNavigationRowNo;
    }

    public void setEndNavigationRowNo(int endNavigationRowNo)
    {
        this.endNavigationRowNo = endNavigationRowNo;
    }

    public int getLastRowNo()
    {
        return lastRowNo;
    }

    public void setLastRowNo(int lastRowNo)
    {
        this.lastRowNo = lastRowNo;
    }

    public int getStartNavigationRowNo()
    {
        return startNavigationRowNo;
    }

    public void setStartNavigationRowNo(int startNavigationRowNo)
    {
        this.startNavigationRowNo = startNavigationRowNo;
    }

    private static final long serialVersionUID = 1L;
    private int startNavigationRowNo;
    private int endNavigationRowNo;
    private int lastRowNo;
}