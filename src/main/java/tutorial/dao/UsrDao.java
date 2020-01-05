package tutorial.dao;

import org.seasar.extension.jdbc.service.S2AbstractService;
import org.seasar.framework.container.annotation.tiger.Component;
import tutorial.entity.Usr;

@Component
public class UsrDao extends S2AbstractService<Usr> {
}
