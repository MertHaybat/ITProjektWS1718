package de.hdm.ITProjekt17.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.hdm.ITProjekt17.client.LoginInfo;


@RemoteServiceRelativePath("login")
public interface LoginService extends RemoteService{
	public LoginInfo login(String requestUri);
}
