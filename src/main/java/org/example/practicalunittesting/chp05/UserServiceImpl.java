package org.example.practicalunittesting.chp05;

public class UserServiceImpl {

	private IUserDAO IUserDAO;
	private ISecurityService ISecurityService;

	public void assignPassword(IUser IUser) throws IllegalArgumentException {
		String passwordMd5 = ISecurityService.md5(IUser.getPassword());
		IUser.setPassword(passwordMd5);
		IUserDAO.updateUser(IUser);
	}

	public UserServiceImpl(IUserDAO dao, ISecurityService security) {
		this.IUserDAO = dao;
		this.ISecurityService = security;
	}
}
