package de.hdm.ITProjekt17.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;
import de.hdm.ITProjekt17.client.LoginInfo;

public interface LoginServiceAsync {

	public void login(String requestUri, AsyncCallback<LoginInfo> callback);

}
