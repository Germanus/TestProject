package my;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: KAZAKEVICH
 * Date: 14.12.13
 * Time: 23:35
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@ViewScoped
public class FirstBean implements Serializable {

    private List<String> list = new ArrayList<String>();
    private int count = 0;

    public FirstBean() {
        list.add("ff");
        list.add("fefef");
        int i = JSFUtil.getBean(Service.class).sum(3, 4);
        JSFUtil.getBean(Service.class).find();

        int j;
    }

    public void addToList() {
        list.add("  " + count++);
        getService().insertUser();
    }

    private Service getService() {
        return JSFUtil.getBean(Service.class);
    }

    public void removeFromList(String str) {
        list.remove(str);

    }

    public boolean isFirst(String str) {
        return list.indexOf(str) == 0;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
