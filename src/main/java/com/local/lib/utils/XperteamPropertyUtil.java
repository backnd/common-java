/*
 * Copyright
 * ------------------------------------------------------------------------
 * (C) Copyright 2006, Xperteam
 *
 * Xperteam retains all ownership rights to this source code. No
 * warranty is expressed or implied by Xperteam, if Xperteam grants
 * the right to use or re-use this source code.
 * ------------------------------------------------------------------------
 */
package com.local.lib.utils;


import java.util.StringTokenizer;

import org.apache.commons.beanutils.PropertyUtils;


public class XperteamPropertyUtil
{
  public Object getProperty(Object obj, String property)
  {
    Object theObj      = null;
    StringTokenizer st = new StringTokenizer(property, ".");
    try
    {
      String theProperty = "";
      if (property.indexOf('.') == -1)
        theObj = PropertyUtils.getProperty(obj, property);
      else
      {
        while (st.hasMoreTokens())
        {
          String propertyName = st.nextToken();
          if (st.hasMoreTokens())
            theProperty += (propertyName + ".");
          else
            theProperty += propertyName;
        }

        theObj = PropertyUtils.getNestedProperty(obj, theProperty);
      }
    }
    catch (Exception e)
    {
      theObj = getPrivateProperty(obj, property);
    }

    return theObj;
  }

  private Object getPrivateProperty(Object obj, String property)
  {
    Object theObj = null;
    try
    {
      String theProperty1 = "";
      StringTokenizer st1 = new StringTokenizer(property, ".");
      while (st1.hasMoreTokens())
      {
        String propertyName1 = st1.nextToken();
        if (st1.hasMoreTokens())
          theProperty1 += (propertyName1.substring(0, 1).toUpperCase() + propertyName1.substring(1, propertyName1.length()) + ".");
        else
          theProperty1 += propertyName1;
      }

      theObj = PropertyUtils.getNestedProperty(obj, theProperty1);
    }
    catch (Exception ex)
    {
      System.out.println("Error in getProperty for obj:" + obj + " property: " + property + "Exception  " + ex);
      return null;
    }

    return theObj;
  }

  /**
   * Set the property for the given object
   *
   * @param dest
   *            Object
   * @param property
   *            String
   * @param value
   *            Object
   */
  public void setProperty(Object dest, String property, Object value)
  {
    try
    {
      if (property.indexOf('.') == -1)
      {
        PropertyUtils.setProperty(dest, property, value);
        return;
      }

      StringTokenizer st  = new StringTokenizer(property, ".");
      Object parent       = dest;
      Object valueAux;
      String propertyName;
      while (st.hasMoreTokens())
      {
        propertyName      = st.nextToken();
        if (!st.hasMoreTokens())
        {
          PropertyUtils.setProperty(parent, propertyName, value);
        }
        else
        {
          valueAux = PropertyUtils.getProperty(parent, propertyName);
          if (valueAux == null)
          {
            Class<?> type = PropertyUtils.getPropertyType(parent, propertyName);
            valueAux = type.newInstance();
            PropertyUtils.setProperty(parent, propertyName, valueAux);
          }

          parent = valueAux;
        }
      }
    }
    catch (Exception e)
    {
      System.out.println("Error in setProperty for obj:" + dest + " property: " + property + "Exception  " + e);
    }
  }
}
