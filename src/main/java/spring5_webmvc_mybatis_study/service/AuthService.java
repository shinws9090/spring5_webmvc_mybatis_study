package spring5_webmvc_mybatis_study.service;

import spring5_webmvc_mybatis_study.spring.AuthInfo;

public interface AuthService {


	AuthInfo authenicate(String email, String password);
}
