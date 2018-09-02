package springbootdemo.springboot.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import springbootdemo.springboot.dao.SbUserDao;
import springbootdemo.springboot.dao.entity.Page;
import springbootdemo.springboot.dao.entity.Sql;
import springbootdemo.springboot.entity.SbUser;

@Repository
public class SbUserDaoImpl extends JdbcPageImpl implements SbUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(SbUser sbUser) {
        String sql = "insert into sb_user (name, create_time) values (?, ?)";
        return jdbcTemplate.update(sql, sbUser.getName(),
                sbUser.getCreateTime());
    }

    @Override
    public int deleteById(int id) {
        String sql = "delete from sb_user where id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateById(SbUser sbUser) {
        String sql = "update sb_user set name=?, create_time=? where id=?";
        return jdbcTemplate.update(sql, sbUser.getName(),
                sbUser.getCreateTime(), sbUser.getId());
    }

    @Override
    public SbUser selectById(int id) {
        String sql = "select * from sb_user where id=?";
//        return jdbcTemplate.queryForObject(sql, new RowMapper<SbUser>() {
//            @Override
//            public SbUser mapRow(ResultSet rs, int rowNum) throws SQLException {
//                SbUser sbUser = new SbUser();
//                sbUser.setId(rs.getInt("id"));
//                sbUser.setName(rs.getString("name"));
//                sbUser.setCreateTime(rs.getDate("create_time"));
//                return sbUser;
//            }
//        }, id);
        return queryForObject(sql, SbUser.class, id);
    }

    @Override
    public Page<SbUser> queryForPage(int pageCurrent, int pageSize, String name) {
        // 确定参数
		/*String sql = "select * from sb_user where name=?";
		return queryForPage(sql.toString(), pageCurrent, pageSize, SbUser.class, name);*/

        // 若name可能为空，则要进行判定，如下
		/*StringBuffer sql = new StringBuffer("select * from sb_user where 1");
		if(!StringUtils.isNullOrEmpty(name)){
			// Sql.checkSql 的作用是防止sql注入
			sql.append(" and name = '").append(Sql.checkSql(name)).append("' ");
		}
		return queryForPage(sql.toString(), pageCurrent, pageSize, SbUser.class);*/

        // 若要like查询，如下
        StringBuffer sql = new StringBuffer("select * from sb_user where 1");
        if(name != null){
            // Sql.checkSql 的作用是防止sql注入
            sql.append(" and name like '%").append(Sql.checkSql(name)).append("%' ");
        }
        return queryForPage(sql.toString(), pageCurrent, pageSize, SbUser.class);
    }

}
