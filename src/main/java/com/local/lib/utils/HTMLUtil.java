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


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;


public class HTMLUtil
{
	/**
	 * This method returns an HTML input of type hidden
	 * @param id
	 * @param value
	 * @return
	 */
	public static String constructHiddenInput(String id, String value)
	{
		String hiddenInput = null;
		try
		{
			hiddenInput = "<input type=\"hidden\" id=\"" + id + "\" name=\"" + id + "\"" + " value=\"" + value + "\">";
		}
		catch (Exception ex)
		{
			hiddenInput = "";
		}

		return hiddenInput;
	}

	/**
	 * Construct Text Input
	 *
	 * @param id
	 * @param defaultValue
	 * @param required
	 * @param requiredLabel
	 * @param maxLength
	 * @param readOnly
	 * @param events
	 * @return
	 */
	public static String constructTextInput(String id, String defaultValue, String required, String requiredLabel, int maxLength, boolean readOnly,
			String events)
	{
		return constructTextInput(id, defaultValue, required, requiredLabel, maxLength, readOnly, events, "");
	}

	/**
	 * construct text input with size parameter
	 *
	 * @param id
	 * @param defaultValue
	 * @param required
	 * @param requiredLabel
	 * @param maxLength
	 * @param readOnly
	 * @param events
	 * @param size
	 * @return
	 */
	public static String constructTextInput(String id, String defaultValue, String required, String requiredLabel, int maxLength, boolean readOnly,
			String events, String size)
	{
		String textInput = null;

		try
		{
			textInput = "<input type=\"text\" id=\"" + id + "\" name=\"" + id + "\"" + " value=\"" + defaultValue + "\" required=\"" + required + "\" label=\""+requiredLabel+"\"" +
			" maxLength=\"" + maxLength + "\" " + ((readOnly == true) ? " readonly=\"true\" " : " ") +
			((events != null) ? events : "") + ((size != null) ? (" size=\"" + size + "\"") : "") + " onPaste=\"return false;\"/>";
		}
		catch (Exception ex)
		{
			textInput = "";
		}

		return textInput;
	}

	/**
	 *
	 * @param id
	 * @param defaultValue
	 * @param required
	 * @param requiredLabel
	 * @param maxLength
	 * @param readOnly
	 * @param events
	 * @return
	 */
	public static String constructTextInput(String id, String defaultValue, String required, String requiredLabel, int maxLength, boolean readOnly,
			String events, String style, String className)
	{
		String textInput = null;

		try
		{
			textInput = "<input type=\"text\" id=\"" + id + "\" name=\"" + id + "\"" + " value=\"" + defaultValue + "\" required=\"" + required + "\" label=\""+requiredLabel+"\"" +
			" maxLength=\"" + maxLength + "\" " + ((readOnly == true) ? " readonly=\"true\" " : " ") +
			((events != null) ? events : "") + " onPaste=\"return false;\" style=\"" + style + "\" class=\"" + className + "\">";
		}
		catch (Exception ex)
		{
			textInput = "";
		}

		return textInput;
	}

	/**
	 *
	 * @param id
	 * @param defaultValue
	 * @param required
	 * @param requiredLabel
	 * @param maxLength
	 * @param readOnly
	 * @param events
	 * @return
	 */
	public static String constructTextArea(String id, String defaultValue, String rows, String cols, String required, String requiredLabel,
			int maxLength, boolean readOnly, String events)
	{
		String textArea = null;

		try
		{
			textArea = "<textarea id=\"" + id + "\" name=\"" + id + "\" label=\""+requiredLabel+"\" required=\"" + required + "\" maxlength=\"" + maxLength +
			"\" rows=\"" + rows + "\" cols=\"" + cols + "\" " + ((readOnly == true) ? " readonly=\"true\" " : " ") + "  onPaste=\"return false\" " +
			events + ">" + defaultValue + "</textarea>";
		}
		catch (Exception ex)
		{
			textArea = "";
		}

		return textArea;
	}

	/**
	 *
	 * @param id
	 * @param defaultValue
	 * @param required
	 * @param requiredLabel
	 * @param maxLength
	 * @param readOnly
	 * @param events
	 * @return
	 */
	public static String constructPasswordInput(String id, String defaultValue, String required, String requiredLabel, int maxLength, boolean readOnly,
			String events)
	{
		String pwdInput = null;

		try
		{
			pwdInput = "<input type=\"password\" id=\"" + id + "\" name=\"" + id + "\"" + " value=\"" + defaultValue + "\" required=\"" + required +
			"\" AUTOCOMPLETE=\"off\" label=\""+requiredLabel+"\" maxLength=\"" + maxLength + "\" " +
			((readOnly == true) ? " readonly=true " : " ") + ((events != null) ? events : "") + " onPaste=\"return false;\"/>";
		}
		catch (Exception ex)
		{
			pwdInput = "";
		}

		return pwdInput;
	}

	/**
	 *
	 * @param id
	 * @param buttonDesc
	 * @param eventClick
	 * @param style
	 * @return
	 */
	public static String constructButtonInput(String id, String buttonDesc, boolean disabled, String eventClick, String className)
	{
		String buttonInput = null;
		try
		{
			buttonInput = "<input type=\"button\" id=\"" + id + "\" name=\"" + id + "\"" + " value=\"" + buttonDesc + "\" class=\"" + className + "\"" +
			(disabled ? " disabled=true " : " ") + " onClick=\"if(!this.disabled){" + eventClick + "}\"/>";
		}
		catch (Exception ex)
		{
			buttonInput = "";
		}

		return buttonInput;
	}

	/**
	 *
	 * @param id
	 * @param buttonDesc
	 * @param eventClick
	 * @param style
	 * @return
	 */
	public static String constructButton(String id, String buttonDesc, boolean disabled, String language, String eventClick)
	{
		StringBuffer buttonInput = new StringBuffer(256);
		try
		{
			buttonInput.append("<table cellpadding=\"0\" cellspacing=\"0\" id=\"" + id + "\" > \n ")
			.append("<tr onclick=\"" + eventClick + "\" style=\"cursor:pointer;\" > \n");
			if (language.equals("Eng"))
			{
				buttonInput.append("<td class=\"btn-left\" id=\"" + id + "1\"></td> \n");
			}
			else
			{
				buttonInput.append("<td class=\"btn-right\" id=\"" + id + "2\"></td> \n");
			}

			buttonInput.append("<td class=\"btn-center\" id=\"" + id + "3\">" + buttonDesc + "</td> \n");

			if (language.equals("Eng"))
			{
				buttonInput.append("<td class=\"btn-right\" id=\"" + id + "2\"></td> \n");
			}
			else
			{
				buttonInput.append("<td class=\"btn-left\" id=\"" + id + "1\"></td> \n");
			}

			buttonInput.append("</tr>").append("</table>");
		}
		catch (Exception ex)
		{
			return "";
		}

		return new String(buttonInput);
	}

	/**
	 *
	 * @param id
	 * @param buttonDesc
	 * @param eventClick
	 * @param style
	 * @param visible
	 * @return
	 */
	public static String constructButton(String id, String buttonDesc, boolean disabled, String language, String eventClick, boolean visible)
	{
		StringBuffer buttonInput = new StringBuffer(256);
		try
		{
			//	cursor:pointer;
			buttonInput.append("<table cellpadding=\"0\" cellspacing=\"0\" id=\"" + id + "\"> \n ")
			.append("<tr onclick=\"" + eventClick + "\" style=\"cursor:pointer;\" onmouseover=\"document.getElementById('" + id +
					"1').style.backgroundImage = 'url(images/BUTTON1_03Hover.PNG)'; document.getElementById('" + id +
					"1').style.repeat='no-repeat'; document.getElementById('" + id +
					"2').style.backgroundImage = 'url(images/BUTTON1_05Hover.PNG)'; document.getElementById('" + id +
					"2').style.repeat='x-repeat'; document.getElementById('" + id +
					"3').style.backgroundImage = 'url(images/BUTTON1_02Hover.PNG)'; document.getElementById('" + id +
					"3').style.repeat='no-repeat';\" onmouseout=\"document.getElementById('" + id +
					"1').style.backgroundImage = 'url(images/BUTTON1_03.PNG)'; document.getElementById('" + id +
					"1').style.repeat='no-repeat'; document.getElementById('" + id +
					"2').style.backgroundImage = 'url(images/BUTTON1_05.PNG)'; document.getElementById('" + id +
					"2').style.repeat='x-repeat'; document.getElementById('" + id +
					"3').style.backgroundImage = 'url(images/BUTTON1_02.PNG)'; document.getElementById('" + id +
			"3').style.repeat='no-repeat';\"> \n");
			if (language.equals("Eng"))
			{
				buttonInput.append("<td class=\"btn-left\" id=\"" + id + "1\"></td> \n");
			}
			else
			{
				buttonInput.append("<td class=\"btn-right\" id=\"" + id + "2\"></td> \n");
			}

			buttonInput.append("<td class=\"btn-center\" id=\"" + id + "3\">" + buttonDesc + "</td> \n");

			if (language.equals("Eng"))
			{
				buttonInput.append("<td class=\"btn-right\" id=\"" + id + "2\"></td> \n");
			}
			else
			{
				buttonInput.append("<td class=\"btn-left\" id=\"" + id + "1\"></td> \n");
			}

			buttonInput.append("</tr>").append("</table>");
		}
		catch (Exception ex)
		{
			return "";
		}

		return new String(buttonInput);
	}

	/**
	 *
	 * @param id
	 * @param checked
	 * @param disabled
	 * @param events
	 * @return
	 */
	public static String constructCheckBox(String id, boolean checked, boolean disabled, String events)
	{
		String checkBoxStr = null;
		try
		{
			checkBoxStr = "<input type=\"checkbox\" id=\"" + id + "\" name=\"" + id + "\"" + ((checked == true) ? " checked " : " ") +
			((disabled == true) ? " disabled=true " : " ") + ((events != null) ? events : "") + "/>";
		}
		catch (Exception ex)
		{
			checkBoxStr = "";
		}

		return checkBoxStr;
	}

	/**
	 *
	 * @param labelValue
	 * @return
	 */
	public static String constructLabel(String labelValue)
	{
		String labelStr = null;
		try
		{
			labelStr = "<label>" + labelValue + "</label>";
		}
		catch (Exception ex)
		{
			labelStr = "";
		}

		return labelStr;
	}

	/**
	 *
	 * @param labelValue
	 * @return
	 */
	public static String constructLabelWithId(String id, String labelValue, String className)
	{
		String labelStr = null;
		try
		{
			if (className != null)
				labelStr = "<label id=\"" + id + "\" class=\"" + className + "\">" + labelValue + "</label>";
			else
				labelStr = "<label id=\"" + id + "\">" + labelValue + "</label>";
		}
		catch (Exception ex)
		{
			labelStr = "";
		}

		return labelStr;
	}

	/**
	 *
	 * @param labelValue
	 * @return
	 */
	public static String constructLabel(String labelValue, String className)
	{
		String labelStr = null;
		try
		{
			labelStr = "<label class=\"" + className + "\">" + labelValue + "</label>";
		}
		catch (Exception ex)
		{
			labelStr = "";
		}

		return labelStr;
	}

	/**
	 *
	 * @param id
	 * @param checked
	 * @param disabled
	 * @param events
	 * @return
	 */
	public static String constructRadioButton(String name, boolean checked, String value, String label, boolean disabled, String events, String style)
	{
		String radioStr = null;
		try
		{
			radioStr = "<input type=\"radio\"  name=\"" + name + "\"" + " value=\"" + value + "\" " + ((checked == true) ? " checked=\"true\" " : " ") +
			((disabled == true) ? " disabled=true " : " ") + ((style != null) ? (" style=\"" + style + "\" ") : " ") +
			((events != null) ? events : "") + "><label id=\"" + name + "_" + value + "\">" + label + "</label></input>";
		}

		catch (Exception ex)
		{
			radioStr = "";
		}

		return radioStr;
	}

	/**
	 *
	 * @param selectId: the name of the <select>
	 * @param comboMap: A map containing the <id,value>
	 * @param selectedValue: The selected option if any
	 * @param comboEvents: the events of the select like onchange if any
	 * @return
	 */
	public static String constructCombo(String selectId, Map<Long, String> comboMap, String selectedValue, boolean disabled, String comboEvents,
			String allOptions, String style, String required, String requiredLabel)
	{
		StringBuilder comboStr = new StringBuilder();
		try
		{
			Iterator<Long> it = comboMap.keySet().iterator();

			comboStr.append("<select id=\"" + selectId + "\" name=\"" + selectId + "\" " + " required=\"" + required + "\"");

			comboStr.append("label=\""+requiredLabel+"\" " + ((comboEvents != null) ? comboEvents : " ") +
					((disabled == true) ? " disabled=true " : " "));
			comboStr.append(((style != null) ? (" style=\"" + style + "\" ") : " ") + ">");
			if (allOptions != null)
			{
				comboStr.append("<option id=\"-1\" value=\"-1\"" + ">" + allOptions + "</option>");
			}

			while (it.hasNext())
			{
				Long key     = new Long(it.next());
				String value = comboMap.get(key);
				if (selectedValue != null)
				{
					comboStr.append("<option id=\"" + key + "\" value=\"" + key + "\"" + (selectedValue.equals(String.valueOf(key)) ? " selected" : "") + ">" +
							value + "</option>");
				}
				else
					comboStr.append("<option id=\"" + key + "\" value=\"" + key + "\"" + ">" + value + "</option>");
			}

			comboStr.append("</select>");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			comboStr.append("<select></select>");
		}

		return new String(comboStr);
	}

	/**
	 * This method constructs a script with the corresponding filePath+fileName
	 * @param filePath
	 * @return
	 */
	public static String constructScript(String filePath)
	{
		String scriptInclude = null;

		try
		{
			scriptInclude = "<script language=\"javascript\" src=\"" + filePath + "\"></script>";
		}
		catch (Exception ex)
		{
			scriptInclude = "";
		}

		return scriptInclude;
	}

	/**
	 * This method constructs a link include
	 * @param filePath
	 * @return
	 */
	public static String constructLink(String filePath)
	{
		String linkInclude = null;

		try
		{
			linkInclude = "<link rel=\"stylesheet\" type=\"text/css\" href=\"" + filePath + "\">";
		}
		catch (Exception ex)
		{
			linkInclude = "";
		}

		return linkInclude;
	}

	/**
	 * Returns the color of a row based on a number
	 *
	 * @param i
	 * @param style1
	 * @param style2
	 * @return
	 */
	public static String getRowColor(int i, String style1, String style2)
	{
		String styleColName = style2;
		;
		if ((i % 2) == 0)
		{
			styleColName = style1;
		}

		return styleColName;
	}

	/**
	 * Returns the direction of HTML file based on the language selection
	 *
	 * @param language
	 * @return String HTML Direction
	 */
	public static String getDirection(String language)
	{
		String htmlDirection = "dir=\"ltr\"";
		if (language.equals("Arb"))
		{
			htmlDirection = "dir=\"rtl\"";
		}

		return htmlDirection;
	}

	/**
	 * Returns the alignment of an HTML Object based on the language selection
	 *
	 * @param language
	 * @return String alignment Direction
	 */
	public static String getAlign(String language)
	{
		String alignDirection = "align=\"right\"";
		if (language.equals("Arb"))
		{
			alignDirection = "align=\"left\"";
		}

		return alignDirection;
	}

	/**
	 * Returns the flip alignment of an HTML Object based on the language selection
	 *
	 * @param language
	 * @return String alignment Direction
	 */
	public static String getAlignFlip(String language)
	{
		String alignDirection = "align=\"left\"";
		if (language.equals("Arb"))
		{
			alignDirection = "align=\"right\"";
		}

		return alignDirection;
	}

	/**
	 * This method will construct an input text with 2 up and down arrows to increase and decrease the value of the textbox
	 * don't forget when u use it to include the js file and to take the images from the source safe
	 * @param id
	 * @param value
	 * @return
	 */
	public static String constructTickerInput(String id, String scale, String events, String onChangeEvent)
	{
		StringBuffer spinnerBuffer = new StringBuffer(256);
		try
		{
			spinnerBuffer.append("<table cellpadding=\"0\" cellspacing=\"3\">");
			spinnerBuffer.append(" <tr>");
			spinnerBuffer.append("  <td><input type=\"text\" name=\"" + id + "\" onPaste=\"return false;\" id=\"" + id +
					"\" style=\"height:19px;text-align:center;\" " + events + " onChange=\"roundingNumbers(this);" + onChangeEvent + ";\" value=\"" +
					scale + "\" scale=\"" + scale + "\"/></td>");
			spinnerBuffer.append("  <td>");
			spinnerBuffer.append("    <table cellpadding=\"0\" cellspacing=\"1\">");
			spinnerBuffer.append("      <tr>");
			spinnerBuffer.append("       <td><img src=\"images/sort_asc.gif\" id=\"btnUp\" tickerId=" + id +
					" style=\"cursor:pointer;\" onclick=\"incrementNumber(this," + scale + ")\"/></td>");
			spinnerBuffer.append("      </tr>");
			spinnerBuffer.append("      <tr>");
			spinnerBuffer.append("       <td><img src=\"images/sort_desc.gif\" id=\"btnDown\" tickerId=" + id +
					" style=\"cursor:pointer;\" onclick=\"decrementNumber(this," + scale + ")\"/></td>");
			spinnerBuffer.append("      </tr>");
			spinnerBuffer.append("    </table>");
			spinnerBuffer.append("  </td>");
			spinnerBuffer.append(" </tr>");
			spinnerBuffer.append("</table>");
		}
		catch (Exception ex)
		{
			spinnerBuffer = new StringBuffer(256);
		}

		return new String(spinnerBuffer);
	}

	/**
	 * this legend is used in the LMS for the legend of the grid in the groups menu
	 * @return
	 */
	public static String constructLegend(String legendId, String display, String firstImg, String firstLabel, String secondImg, String secondLabel)
	{
		DIVUtil legendDiv = new DIVUtil();
		legendDiv.setId(legendId);
		legendDiv.setDisplay(display);
		TableUtil legendTable = new TableUtil();
		legendTable.setId(legendId + "Table");
		legendTable.setBorder("thin solid #E0E0FC;");
		legendTable.setCellPadding("0");
		legendTable.setCellSpacing("0");
		StringBuffer sb = new StringBuffer();
		sb.append("<tr>");
		sb.append(" <td>");
		sb.append("  <img src=\"" + firstImg + "\"/>");
		sb.append(" </td>");
		sb.append("	 <td style=\"font-size:11px\"> &nbsp;" + firstLabel + " 	 </td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append(" <td>");
		sb.append("  <img src=\"" + secondImg + "\"/>");
		sb.append(" </td>");
		sb.append("	 <td style=\"font-size:11px\"> &nbsp;" + secondLabel + " 	 </td>");
		sb.append("</tr>");
		legendTable.setContent(new String(sb));
		legendDiv.setContent(legendTable.generateTable());
		return legendDiv.generateDIV();
	}

	/**
	 *
	 * @param selectId
	 * @param list
	 * @param idProperty : name of the id(Key) of the object being sent
	 * @param valueProperty: name of the value of the object being sent
	 * @param selectedValue
	 * @param disabled
	 * @param comboEvents
	 * @param allOptions
	 * @param style
	 * @param required
	 * @param requiredLabel
	 * @return
	 */
	public static String constructCombo(String selectId, ArrayList<Object> list, String idProperty, String valueProperty, String selectedValue,
			boolean disabled, String comboEvents, String allOptions, String style, String required, String requiredLabel)
	{
		StringBuilder comboStr = new StringBuilder();
		try
		{
			XperteamPropertyUtil propertyUtil = new XperteamPropertyUtil();
			Iterator<Object> it           = list.iterator();

			comboStr.append("<select id=\"" + selectId + "\" name=\"" + selectId + "\" " + " required=\"" + required + "\"");

			comboStr.append("label=\""+requiredLabel+"\" " + ((comboEvents != null) ? comboEvents : " ") +
					((disabled == true) ? " disabled=true " : " "));
			comboStr.append(((style != null) ? (" style=\"" + style + "\" ") : " ") + ">");
			if (allOptions != null)
			{
				comboStr.append("<option id=\"-1\" value=\"-1\"" + ">" + allOptions + "</option>");
			}

			while (it.hasNext())
			{
				Object current = it.next();
				Long key       = (Long)propertyUtil.getProperty(current, idProperty);
				String value   = (String)propertyUtil.getProperty(current, valueProperty);
				if (selectedValue != null)
				{
					comboStr.append("<option id=\"" + key + "\" value=\"" + key + "\"" + (selectedValue.equals(String.valueOf(key)) ? " selected" : "") + ">" +
							value + "</option>");
				}
				else
					comboStr.append("<option id=\"" + key + "\" value=\"" + key + "\"" + ">" + value + "</option>");
			}

			comboStr.append("</select>");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			comboStr.append("<select></select>");
		}

		return new String(comboStr);
	}
}
