package com.mobile.framework.webservices;

public class VoidResultHandler extends ResultHandler {

	@Override
	protected void onServiceResult() {
		onResult();
	}

	protected void onResult() {
	}
}
