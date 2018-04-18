package cn.com.service;
import java.util.List;

import cn.com.dao.UserDao;
import cn.com.pojo.User;
import cn.com.utils.MD5;
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public void addUser(User user) {
		//md5加密存储到数据库
		String md5str = MD5.encrypty(user.getPassword()) ;
		user.setPassword(md5str);
		this.userDao.save(user);//服务层代码调用数据访问层
	}
	@Override
	public List<User> findUser() {
		return this.userDao.findall();
	}
	@Override
	public User loginUser(User user) {
		String  md5str = MD5.encrypty(user.getPassword());
		user.setPassword(md5str);
		return this.userDao.findbyuser(user);
	}
}
