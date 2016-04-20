package com.mobile.framework.webservices;

import org.w3c.dom.Element;

import android.util.Log;

public abstract class WSObject implements IWSObject {

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
		if (root.getTagName().equals(getClass().getSimpleName())) {
			WSHelper.reflectionLoad(this, root);
		}
	}

	@Override
	public void fillXML(WSHelper ws, Element root) {
		WSHelper.reflectionFill(ws, this, root);
	}

	@Override
	public Element toXMLElement(WSHelper ws, Element root) {

		String elementName = String
				.format("ns4:%s", getClass().getSimpleName());
		Element nd = ws.createElement(elementName);

		fillXML(ws, nd);

		return nd;
	}
}
