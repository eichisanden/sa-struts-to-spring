package tutorial.action;

import org.seasar.extension.dbcp.impl.XADataSourceImpl;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import tutorial.dao.UsrDao;
import tutorial.entity.Usr;
import tutorial.form.AddForm;

import javax.annotation.Resource;
import java.util.List;

public class AddAction {

    public Integer result;

    @ActionForm
    @Resource
    protected AddForm addForm;

    @Resource
    protected UsrDao usrDao;

    @Resource
    public XADataSourceImpl xaDataSource;

    @Execute(validator = false)
    public String index() {
        return "index.jsp";
    }

    @Execute(input = "index.jsp")
    public String submit() {
        System.out.println("####################################");
        Usr usr = new Usr(1001, "huga");
        usrDao.insert(usr);
        List<Usr> list = usrDao.findAll();
        list.forEach(System.out::println);
        System.out.println(xaDataSource.getUser() + "::" + xaDataSource.getPassword());
        System.out.println("####################################");

        result = Integer.valueOf(addForm.arg1) + Integer.valueOf(addForm.arg2);
        return "index.jsp";
    }
}