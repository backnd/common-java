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
package com.hdc.sysdev.utils;


public class TableUtil
{
  private String id;
  private String width;
  private String height;
  private String className;
  private String onClick;
  private String onSelectStart;
  private String content;
  private String dir;
  private String vAlign;

  //Styles
  private String tableLayout;
  private String border;
  private String attributes;
  private String cellPadding;
  private String cellSpacing;
  StringBuffer table      = null;
  StringBuffer tableStyle = null;

  public String generateTable()
  {
    table      = new StringBuffer();
    tableStyle = new StringBuffer();

    table.append("<TABLE ");

    if ((id != null) && !id.equals(""))
    {
      table.append("id=\"" + id + "\" ");
    }

    if ((dir != null) && !dir.equals(""))
    {
      table.append("dir=\"" + dir + "\" ");
    }

    if ((width != null) && !width.equals(""))
    {
      table.append("width=\"" + width + "\" ");
    }

    if ((height != null) && !height.equals(""))
    {
      table.append("height=\"" + height + "\" ");
    }

    if ((vAlign != null) && !vAlign.equals(""))
    {
      table.append("vAlign=\"" + vAlign + "\" ");
    }

    if ((cellPadding != null) && !cellPadding.equals(""))
    {
      table.append("cellPadding=" + cellPadding + " ");
    }

    if ((cellSpacing != null) && !cellSpacing.equals(""))
    {
      table.append("cellSpacing=" + cellSpacing + " ");
    }

    if ((className != null) && !className.equals(""))
    {
      table.append("class=\"" + className + "\" ");
    }

    if ((onClick != null) && !onClick.equals(""))
    {
      table.append("onclick=\"" + onClick + "\" ");
    }

    if ((onSelectStart != null) && !onSelectStart.equals(""))
    {
      table.append("onselectstart=\"" + onSelectStart + "\" ");
    }

    if ((tableLayout != null) && !tableLayout.equals(""))
    {
      tableStyle.append("TABLE-LAYOUT:" + tableLayout + "; ");
    }

    if ((border != null) && !border.equals(""))
    {
      tableStyle.append("border:" + border + "; ");
    }

    if (tableStyle.length() > 0)
    {
      table.append("style=\"" + tableStyle + " \"");
    }

    if ((attributes != null) && !attributes.equals(""))
    {
      table.append(attributes + "; ");
    }

    table.append(">");
    table.append(content);
    table.append("</TABLE>");

    return new String(table);
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getTableLayout()
  {
    return tableLayout;
  }

  public void setTableLayout(String tableLayout)
  {
    this.tableLayout = tableLayout;
  }

  public String getWidth()
  {
    return width;
  }

  public void setWidth(String width)
  {
    this.width = width;
  }

  public String getContent()
  {
    return content;
  }

  public void setContent(String content)
  {
    this.content = content;
  }

  public String getClassName()
  {
    return className;
  }

  public void setClassName(String className)
  {
    this.className = className;
  }

  public String getBorder()
  {
    return border;
  }

  public void setBorder(String border)
  {
    this.border = border;
  }

  public String getOnClick()
  {
    return onClick;
  }

  public void setOnClick(String onClick)
  {
    this.onClick = onClick;
  }

  public String getOnSelectStart()
  {
    return onSelectStart;
  }

  public void setOnSelectStart(String onSelectStart)
  {
    this.onSelectStart = onSelectStart;
  }

  public String getAttributes()
  {
    return attributes;
  }

  public void setAttributes(String attributes)
  {
    this.attributes = attributes;
  }

  public String getCellPadding()
  {
    return cellPadding;
  }

  public void setCellPadding(String cellPadding)
  {
    this.cellPadding = cellPadding;
  }

  public String getCellSpacing()
  {
    return cellSpacing;
  }

  public void setCellSpacing(String cellSpacing)
  {
    this.cellSpacing = cellSpacing;
  }

  public String getDir()
  {
    return dir;
  }

  public void setDir(String dir)
  {
    this.dir = dir;
  }

  public String getHeight()
  {
    return height;
  }

  public void setHeight(String height)
  {
    this.height = height;
  }

  public String getVAlign()
  {
    return vAlign;
  }

  public void setVAlign(String align)
  {
    vAlign = align;
  }
}
