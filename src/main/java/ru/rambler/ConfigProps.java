package ru.rambler;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:src/main/resources/credentials.properties",
        "file:src/main/resources/textAndTopic.properties"
})
public interface ConfigProps extends Config {
    ConfigProps conf = ConfigFactory.create(ConfigProps.class);

    @Key("login1")
    String login1();
    @Key("password1")
    String password1();
    @Key("login1.post.adr")
    String login1PostAdr();
    @Key("login2")
    String login2();
    @Key("password2")
    String password2();
    @Key("login2.post.adr")
    String login2PostAdr();
    @Key("topicField")
    String topicExample();
    @Key("mailField2")
    String mailExample();
    @Key("name.login1")
    String namelogin1();
    @Key("login3.fake")
    String fakeLogin();
}
