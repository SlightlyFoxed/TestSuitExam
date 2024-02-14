package jdbcExam;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:src/main/resources/dbCredentials.properties",
})
public interface DB_Props extends Config {
    DB_Props conf = ConfigFactory.create(DB_Props.class);

    @Key("DB.URL")
    String DB_URL();

    @Key("USER")
    String USER();

    @Key("PASS")
    String PASS();

}
