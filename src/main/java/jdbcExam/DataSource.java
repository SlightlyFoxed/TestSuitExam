package jdbcExam;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataSource {
    private static final DB_Props dbProps = DB_Props.conf;

    public static BasicDataSource dsMap() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl(dbProps.DB_URL());
        ds.setUsername(dbProps.USER());
        ds.setPassword(dbProps.PASS());
        return ds;
    }
}
