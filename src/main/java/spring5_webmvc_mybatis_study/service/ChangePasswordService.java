package spring5_webmvc_mybatis_study.service;

public interface ChangePasswordService {


	void changePassword(String email, String oldPwd, String newPwd);
}
