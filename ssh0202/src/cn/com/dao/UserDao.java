package cn.com.dao;
import java.io.Serializable;
import java.util.List;
import cn.com.pojo.User;
public interface UserDao {
	public void save(User user);
	public void update(User user);
	public void delete(Serializable id);
	public User findbyid(Serializable id);
	public List<User> findall();
	public User findbyuser(User user);
}
