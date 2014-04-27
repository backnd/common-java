package com.hdc.sysdev.utils;

public class DIVUtil {

	private String id;
	private String className;
	private String content;

	private String onSelectStart;
	private String onBeforeActivate;
	private String onBeforeDeactivate;
	private String onActivate;
	private String onContextMenu;
	private String onClick;
	private String onscroll;

	// Styles
	private String overflow;
	private String width;
	private String height;
	private String position;
	private String cursor;
	private String display;

	private String cellPadding;
	private String cellSpacing;
	StringBuffer div = null;
	StringBuffer divStyle = null;
	public String generateDIV() {
		div = new StringBuffer();
		divStyle = new StringBuffer();
		div.append("<DIV ");

		if (id != null && !id.equals("")) {
			div.append("id=\"" + id + "\" ");
		}
		if (className != null && !className.equals("")) {
			div.append("class=\"" + className + "\" ");
		}

		if (cellPadding != null && !cellPadding.equals("")) {
			div.append("cellpadding=" + cellPadding + " ");
		}

		if (onClick != null && !onClick.equals("")) {
			div.append("onclick=\"" + onClick + "\" ");
		}

		if (onscroll != null && !onscroll.equals("")) {
			div.append("onscroll=\"" + onscroll + "\" ");
		}

		if (onContextMenu != null && !onContextMenu.equals("")) {
			div.append("oncontextmenu=\"" + onContextMenu + ";\" ");
		}

		if (onSelectStart != null && !onSelectStart.equals("")) {
			div.append("onselectstart=\"" + onSelectStart + "\" ");
		}

		if (onBeforeActivate != null && !onBeforeActivate.equals("")) {
			div.append("onbeforeactivate=\"" + onBeforeActivate + "\" ");
		}

		if (onBeforeDeactivate != null && !onBeforeDeactivate.equals("")) {
			div.append("onbeforedeactivate=\"" + onBeforeDeactivate + "\" ");
		}

		if (overflow != null && !overflow.equals("")) {
			divStyle.append("OVERFLOW:" + overflow + "; ");
		}

		if (width != null && !width.equals("")) {
			divStyle.append("width:" + width + "; ");
		}

		if (height != null && !height.equals("")) {
			divStyle.append("height:" + height + "; ");
		}

		if (position != null && !position.equals("")) {
			divStyle.append("position:" + position + "; ");
		}

		if (cursor != null && !cursor.equals("")) {
			divStyle.append("cursor:" + cursor + "; ");
		}

		if (display != null && !display.equals("")) {
			divStyle.append("display:" + display + "; ");
		}

		div.append("style=\"" + new String(divStyle) + "\"");

		if (cellSpacing != null && !cellSpacing.equals("")) {
			div.append("cellspacing:" + cellSpacing + "; ");
		}

		div.append(" >");

		if (content != null && !content.equals("")) {
			div.append(content);
		}

		div.append("</DIV>");		
		return new String(div);
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getOverflow() {
		return overflow;
	}

	public void setOverflow(String overflow) {
		this.overflow = overflow;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getCursor() {
		return cursor;
	}

	public void setCursor(String cursor) {
		this.cursor = cursor;
	}

	/**
	 * @return the display
	 */
	public String getDisplay() {
		return display;
	}

	/**
	 * @param display
	 *            the display to set
	 */
	public void setDisplay(String display) {
		this.display = display;
	}

	public String getOnSelectStart() {
		return onSelectStart;
	}

	public void setOnSelectStart(String onSelectStart) {
		this.onSelectStart = onSelectStart;
	}

	public String getOnBeforeActivate() {
		return onBeforeActivate;
	}

	public void setOnBeforeActivate(String onBeforeActivate) {
		this.onBeforeActivate = onBeforeActivate;
	}

	public String getOnBeforeDeactivate() {
		return onBeforeDeactivate;
	}

	public void setOnBeforeDeactivate(String onBeforeDeactivate) {
		this.onBeforeDeactivate = onBeforeDeactivate;
	}

	public String getOnActivate() {
		return onActivate;
	}

	public void setOnActivate(String onActivate) {
		this.onActivate = onActivate;
	}

	public String getOnContextMenu() {
		return onContextMenu;
	}

	public void setOnContextMenu(String onContextMenu) {
		this.onContextMenu = onContextMenu;
	}

	public String getOnClick() {
		return onClick;
	}

	public void setOnClick(String onClick) {
		this.onClick = onClick;
	}

	public String getCellPadding() {
		return cellPadding;
	}

	public void setCellPadding(String cellPadding) {
		this.cellPadding = cellPadding;
	}

	public String getCellSpacing() {
		return cellSpacing;
	}

	public void setCellSpacing(String cellSpacing) {
		this.cellSpacing = cellSpacing;
	}

	public String getOnscroll() {
		return onscroll;
	}

	public void setOnscroll(String onscroll) {
		this.onscroll = onscroll;
	}
}
