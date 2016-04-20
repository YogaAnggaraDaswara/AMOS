package com.mobile.framework.webservices;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import org.w3c.dom.*;

import android.util.Log;

public class WSHelper {

	public Document document;

	public WSHelper(Document doc) {
		document = doc;
	}

	static String getString(Document doc) {

		StringWriter sw = new StringWriter();

		Element e = doc.getDocumentElement();

		ArrayList<Object> nsList = new ArrayList<Object>();

		writeElement(sw, e, nsList);

		return sw.toString();
	}

	private static boolean contains(ArrayList<Object> list, String ns) {
		int count = list.size();
		for (int i = 0; i < count; i++) {
			String item = (String) list.get(i);
			if (item.equalsIgnoreCase(ns))
				return true;
		}
		return false;
	}

	private static void writeElement(StringWriter sw, Element e,
			ArrayList<Object> nsList) {
		int count;
		int i;
		sw.write("<" + e.getNodeName());

		NamedNodeMap map = e.getAttributes();

		if (map.getLength() > 0) {
			map = e.getAttributes();
			count = map.getLength();
			for (i = 0; i < count; i++) {
				Node n = map.item(i);
				String name = n.getNodeName();
				String value = n.getNodeValue();
				sw.write(" " + name + "=\"" + getEncoded(value) + "\"");
				if (name.equalsIgnoreCase("xmlns") || name.startsWith("xmlns:")) {
					nsList.add(value);
				}
			}
		}

		String ns = e.getNamespaceURI();
		if (ns != null && ns.length() > 0 && !contains(nsList, ns)) {
			nsList.add(ns);
			String prefix = e.getPrefix();
			if (prefix == null || prefix.length() == 0)
				prefix = "";
			else
				prefix = ":" + prefix;

			sw.write(" xmlns" + prefix + "=\"" + ns + "\"");
		}

		if (e.hasChildNodes()) {
			sw.write(">");
			NodeList list = e.getChildNodes();
			count = list.getLength();
			for (i = 0; i < count; i++) {
				ArrayList<Object> childNSList = copyVector(nsList);

				Node n = list.item(i);
				if (n instanceof Text) {
					sw.write(getEncoded(n.getNodeValue()));
				} else {
					writeElement(sw, (Element) n, childNSList);
				}
			}
			sw.write("</" + e.getNodeName() + ">");
		} else {
			sw.write("/>");
		}
	}

	private static ArrayList<Object> copyVector(ArrayList<Object> v) {
		ArrayList<Object> nv = new ArrayList<Object>();
		int c = v.size();
		for (int i = 0; i < c; i++) {
			nv.add(v.get(i));
		}
		return nv;
	}

	public static String replaceAll(String source, String pattern,
			String replacement) {
		if (source == null) {
			return "";
		}

		StringBuffer sb = new StringBuffer();
		int idx = -1;
		int patIdx = 0;

		while ((idx = source.indexOf(pattern, patIdx)) != -1) {
			sb.append(source.substring(patIdx, idx));
			sb.append(replacement);
			patIdx = idx + pattern.length();
		}
		sb.append(source.substring(patIdx));
		return sb.toString();

	}

	private static String getEncoded(String text) {
		if (text.length() == 0)
			return text;
		text = replaceAll(text, "&", "&amp;");
		text = replaceAll(text, "<", "&lt;");
		text = replaceAll(text, ">", "&gt;");
		return text;
	}

	public void setText(Element e, String text) {
		Text txt = document.createTextNode(text);
		e.appendChild(txt);
	}

	public void addChild(Element root, String name, String value,
			boolean attribute) {
		if (value == null)
			return;
		if (attribute) {
			root.setAttribute(name, value);
		} else {
			Element e = createElement(name);

			Text txt = document.createTextNode(value);
			e.appendChild(txt);
			root.appendChild(e);
		}
	}

	public Element createElement(String name) {
		return XmlDocumentBuilder.createElement(document, name);
	}

	public void addChildNode(Element root, String name, Element child,
			IWSObject obj) {
		Element node = createElement(name);
		if (child != null) {
			node.appendChild(child);
		} else {
			if (obj == null)
				return;
			obj.fillXML(this, node);
		}
		root.appendChild(node);
	}

	public void addChildNode(Element root, String name, IWSObject obj) {
		if (obj == null)
			return;

		Element node = createElement(name);
		obj.fillXML(this, node);
		root.appendChild(node);
	}

	public void addChildNodeNS(Element root, String nsURI, String name,
			IWSObject obj) {
		if (obj == null)
			return;
		Element node = document.createElementNS(nsURI, name);
		obj.fillXML(this, node);
		root.appendChild(node);
	}

	public void addChildArray(Element root, String name, String type,
			ArrayList<? extends IWSObject> array) {
		if (array == null || array.size() == 0)
			return;
		Element arrayElement = createElement(name);
		root.appendChild(arrayElement);
		int i;
		if (type == null) {
			for (i = 0; i < array.size(); i++) {
				IWSObject st = (IWSObject) array.get(i);
				arrayElement.appendChild(st.toXMLElement(this, arrayElement));
			}
		} else {
			for (i = 0; i < array.size(); i++) {
				Element e = createElement(type);
				Object obj = array.get(i);
				String val = obj.toString();
				if (obj.getClass().equals(Date.class)) {
					val = WSDateParser.toString((Date) obj);
				}
				Text txt = document.createTextNode(val);
				e.appendChild(txt);
				arrayElement.appendChild(e);
			}
		}
	}

	public void addChildArrayInline(Element root, String name, String type,
			ArrayList<? extends IWSObject> array) {

		if (array == null || array.size() == 0)
			return;
		int i;
		Element arrayElement = root;
		if (type == null) {
			for (i = 0; i < array.size(); i++) {
				IWSObject st = (IWSObject) array.get(i);
				Element e = createElement(name);
				st.fillXML(this, e);
				arrayElement.appendChild(e);
			}
		} else {
			for (i = 0; i < array.size(); i++) {
				Element e = createElement(name);
				Object obj = array.get(i);
				String val = obj.toString();
				if (obj.getClass().equals(Date.class)) {
					val = WSDateParser.toString((Date) obj);
				}
				Text txt = document.createTextNode(val);
				e.appendChild(txt);
				arrayElement.appendChild(e);
			}
		}
	}

	public static NodeList getChildren(Element root, String name) {
		NodeList childList = root.getChildNodes();
		WSNodeList list = new WSNodeList();
		int n = childList.getLength();
		for (int i = 0; i < n; i++) {
			Node node = childList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				if (name == null)
					list.add(node);
				else if (node.getLocalName().equals(name))
					list.add(node);
			}
		}
		return list;
	}

	public static NodeList getElementChildren(Element root, String name,
			String childrenName) {
		Element e = getElement(root, name);
		if (e == null)
			return null;
		return getChildren(e, childrenName);
	}

	public static NodeList getElementChildren(Element root, String name) {
		Element e = getElement(root, name);
		if (e == null)
			return null;
		return getChildren(e, null);
	}

	public static Element getElement(Element root, String name) {
		if (name == null)
			return null;
		NodeList list = getChildren(root, name);
		if (list.getLength() > 0)
			return (Element) list.item(0);
		return null;
	}

	public static Element getElementNS(Element root, String nsURI, String name) {
		if (name == null)
			return null;
		NodeList list = root.getElementsByTagNameNS(nsURI, name);
		if (list.getLength() > 0)
			return (Element) list.item(0);
		return null;
	}

	public static String getString(Element root, String name,
			boolean isAttribute) {
		if (isAttribute) {
			return root.getAttribute(name);
		}
		if (name == null) {
			Text txt = (Text) root.getFirstChild();
			if (txt == null)
				return null;
			return txt.getNodeValue();
		}
		Element child = getElement(root, name);
		if (child == null)
			return null;
		Text txt = (Text) child.getFirstChild();
		if (txt == null)
			return null;
		return txt.getNodeValue();
	}

	public static boolean getBoolean(Element root, String name,
			boolean isAttribute) {
		String val = getString(root, name, isAttribute);
		if (val == null)
			return false;
		if (val.equalsIgnoreCase("true") || val.equalsIgnoreCase("yes"))
			return true;

		return false;
	}

	public static Date getDate(Element root, String name, boolean isAttribute) {
		String val = getString(root, name, isAttribute);
		if (val == null)
			return null;
		return WSDateParser.parse(val);
	}

	public static long getLong(Element root, String name, boolean isAttribute) {
		String val = getString(root, name, isAttribute);
		long retVal = 0;

		if (val != null) {
			try {
				retVal = Long.parseLong(val);
			} catch (Exception e) {
				Log.i(WSHelper.class.getName(),
						String.format("getLong, Exception: %s", e.getMessage()));
			}
		}

		return retVal;
	}

	public static double getDouble(Element root, String name,
			boolean isAttribute) {
		String val = getString(root, name, isAttribute);
		double retVal = 0.0;

		if (val != null) {
			try {
				retVal = Double.parseDouble(val);
			} catch (Exception e) {
				Log.i(WSHelper.class.getName(),
						String.format("getDouble, Exception: %s",
								e.getMessage()));
			}
		}
		return retVal;
	}

	public static int getShort(Element root, String name, boolean isAttribute) {
		String val = getString(root, name, isAttribute);
		int retVal = 0;

		if (val != null) {
			try {
				retVal = Short.parseShort(val);
			} catch (Exception e) {
				Log.i(WSHelper.class.getName(), String.format(
						"getShort, Exception: %s", e.getMessage()));
			}
		}

		return retVal;
	}

	public static int getInteger(Element root, String name, boolean isAttribute) {
		String val = getString(root, name, isAttribute);
		int retVal = 0;

		if (val != null) {
			try {
				retVal = Integer.parseInt(val);
			} catch (Exception e) {
				Log.i(WSHelper.class.getName(),
						String.format("getInteger, Exception: %s",
								e.getMessage()));
			}
		}

		return retVal;
	}

	public static float getFloat(Element root, String name, boolean isAttribute) {
		String val = getString(root, name, isAttribute);
		float retVal = 0.0f;

		if (val != null) {
			try {
				retVal = Float.parseFloat(val);
			} catch (Exception e) {
				Log.i(WSHelper.class.getName(), String.format(
						"getFLoat, Exception: %s", e.getMessage()));
			}
		}

		return retVal;
	}

	protected static void reflectionLoad(IWSObject wsObject, Element root) {

		Field[] fields = wsObject.getClass().getDeclaredFields();
		Object value = null;

		try {

			for (Field f : fields) {
				f.setAccessible(true);
				value = null;
				if (String.class.isAssignableFrom(f.getType())) {
					value = WSHelper.getString(root, f.getName(), false);
				} else if (short.class.isAssignableFrom(f.getType())) {
					value = WSHelper.getInteger(root, f.getName(), false);
				} else if (int.class.isAssignableFrom(f.getType())) {
					value = WSHelper.getInteger(root, f.getName(), false);
				} else if (long.class.isAssignableFrom(f.getType())) {
					value = WSHelper.getLong(root, f.getName(), false);
				} else if (float.class.isAssignableFrom(f.getType())) {
					value = WSHelper.getFloat(root, f.getName(), false);
				} else if (double.class.isAssignableFrom(f.getType())) {
					value = WSHelper.getDouble(root, f.getName(), false);
				} else if (boolean.class.isAssignableFrom(f.getType())) {
					value = WSHelper.getBoolean(root, f.getName(), false);
				} else if (Date.class.isAssignableFrom(f.getType())) {
					value = WSHelper.getDate(root, f.getName(), false);
				} else if (IWSObject.class.isAssignableFrom(f.getType())) {
					Element e = WSHelper.getElement(root, f.getName());
					if (e != null) {
						IWSObject objWs = (IWSObject) f.getType().newInstance();
						objWs.loadXML(e);
						value = objWs;
					}
					e = null;
				}
				if (value != null) {
					f.set(wsObject, value);
				}
			}

		} catch (Exception e) {
			Log.i(WSHelper.class.getName(),
					String.format("reflectionLoad, Exception: %s",
							e.getMessage()));
		}

		fields = null;
	}

	protected static void reflectionFill(WSHelper ws, Object wsObject,
			Element root) {

		if (wsObject == null) {
			return;
		}

		if (!(wsObject instanceof IWSObject)) {
			return;
		}

		Field[] fields = wsObject.getClass().getDeclaredFields();
		String tagName = "";
		String value = null;

		try {
			for (Field f : fields) {

				tagName = String.format("ns4:%s", f.getName());

				f.setAccessible(true);

				if (String.class.isAssignableFrom(f.getType())) {
					value = (String) f.get(wsObject);
					ws.addChild(root, tagName, value, false);
				} else if (short.class.isAssignableFrom(f.getType())) {
					value = String.valueOf(f.getShort(wsObject));
					ws.addChild(root, tagName, value, false);
				} else if (int.class.isAssignableFrom(f.getType())) {
					value = String.valueOf(f.getInt(wsObject));
					ws.addChild(root, tagName, value, false);
				} else if (long.class.isAssignableFrom(f.getType())) {
					value = String.valueOf(f.getLong(wsObject));
					ws.addChild(root, tagName, value, false);
				} else if (float.class.isAssignableFrom(f.getType())) {
					value = String.valueOf(f.getFloat(wsObject));
					ws.addChild(root, tagName, value, false);
				} else if (double.class.isAssignableFrom(f.getType())) {
					value = String.valueOf(f.getDouble(wsObject));
					ws.addChild(root, tagName, value, false);
				} else if (boolean.class.isAssignableFrom(f.getType())) {
					value = String.valueOf(f.getBoolean(wsObject));
					ws.addChild(root, tagName, value, false);
				} else if (Date.class.isAssignableFrom(f.getType())) {
					value = WSDateParser.toString((Date) f.get(wsObject));
					ws.addChild(root, tagName, value, false);
				} else if (IWSObject.class.isAssignableFrom(f.getType())) {
					IWSObject objWS = (IWSObject) f.get(wsObject);
					if (objWS != null) {
						Element e = objWS.toXMLElement(ws, root);
						if (e != null) {
							root.appendChild(e);
						}
						e = null;
					}
				}
			}
		} catch (Exception e) {
			Log.i(WSHelper.class.getName(),
					String.format("reflectionFill, Exception: %s",
							e.getMessage()));
		}

		fields = null;
	}

}
