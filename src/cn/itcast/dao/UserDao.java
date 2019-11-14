package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.until.JDBCUntils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.annotation.WebServlet;
import javax.sql.DataSource;

//操作数据库的user表

public class UserDao {

    //声明JDBUTemplet对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUntils.getDataSource());

    /**
     * 登录
     * @param loginUser 只有用户和密码
     * @return
     */
    public User login(User loginUser){
        try {
            //1编写sql
            String sql = "select * from user where uersname = ? and password = ?";
            //调用query方法
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());

            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

}
