package com.mobile.framework.webservices;

import java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressWarnings({ "serial" })
public class WSNodeList extends ArrayList<Node> implements NodeList {

	@Override
	public int getLength() {
		return this.size();
	}

	@Override
	public Node item(int index) {
		return this.get(index);
	}

}
