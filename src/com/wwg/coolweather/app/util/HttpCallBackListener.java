package com.wwg.coolweather.app.util;

public interface HttpCallBackListener {
	void onFinish(String response);

	void onError(Exception e);
}
