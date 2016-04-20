package com.mobile.framework.webservices;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.util.Log;

public abstract class WSObjectList<T extends IWSObject> extends ArrayList<T>
		implements IWSObject {

	private Class<T> theGenericClass = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = 3150202540570220425L;

	public WSObjectList() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getGenericClass() {
		if (theGenericClass == null) {
			Type genericType = getClass().getGenericSuperclass();
			if (genericType instanceof ParameterizedType) {
				ParameterizedType paramType = (ParameterizedType) genericType;
				theGenericClass = (Class<T>) paramType.getActualTypeArguments()[0];
			}
		}

		return theGenericClass;
	}

	public static <T extends WSObject> T fromXMLElement(Element root,
			Class<T> result) {
		T newObject = null;

		try {
			newObject = result.newInstance();
			newObject.loadXML(root);
		} catch (Exception e) {
			Log.i(WSObject.class.getName(),
					String.format("fromXMLElement, Exception: %s",
							e.getMessage()));
		}

		return newObject;
	}

	@Override
	public void loadXML(Element root) {
		Class<T> generiClass = getGenericClass();
		NodeList list = null;
		Element nc = null;
		T wsObject = null;

		if (generiClass != null) {
			try {
				list = WSHelper.getElementChildren(root, getClass()
						.getSimpleName(), generiClass.getSimpleName());
				if (list != null) {
					for (int i = 0; i < list.getLength(); i++) {
						nc = (Element) list.item(i);
						wsObject = generiClass.newInstance();
						wsObject.loadXML(nc);
						add(wsObject);
					}
				}
			} catch (Exception e) {
				Log.i(getClass().getName(),
						String.format("loadXML, Exception: %s", e.getMessage()));
			}
		}
	}

	@Override
	public void fillXML(WSHelper ws, Element root) {
		Class<T> genericClass = getGenericClass();
		if (genericClass != null) {
			if (size() > 0) {
				ws.addChildArrayInline(root,
						String.format("ns4:%s", genericClass.getSimpleName()),
						null, this);
			}
		}
	}

	@Override
	public Element toXMLElement(WSHelper ws, Element root) {
		Element e = ws.createElement(String.format("ns4:%s", getClass()
				.getSimpleName()));
		fillXML(ws, e);
		return e;

	}
}
