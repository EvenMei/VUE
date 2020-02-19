package com.meiyukai.provider;

        import com.meiyukai.domain.User;
        import org.apache.ibatis.jdbc.SQL;

        import java.util.Map;

public class UserUpdateProvider {

    public  String getUpdateProvider(final Map<String , Object>paramMap){  // 或者使用@Param(vlaue="u")

        return new SQL(){{
            UPDATE("user");
            User user = (User)paramMap.get("u");

            SET("age='"+user.getAge()+"'");  //组合 SQL语句 ，字符串需要使用 '' ,否则会报错
            SET("username='"+user.getUsername()+"'");
            SET("password='"+user.getPassword()+"'");
            SET("email='"+user.getEmail()+"'");
            SET("sex='"+user.getSex()+"'");
            WHERE("id="+user.getId());

        }}.toString();
    }

}
