package my;

import java.nio.charset.Charset;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Общие методы jsf
 *
 * @author Vlad Matyushevski
 * @author Kazakevich Ilya
 */
public final class JSFUtil {

    private JSFUtil() {
    }

    public static Object getRequestParameter(String elementName) {
        Object resultParam =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(elementName);
        return resultParam;
    }

    public static Object getViewScopedParameter(String parameter) {
        return FacesContext.getCurrentInstance().getViewRoot().getViewMap().get(parameter);
    }

    public static void removeViewScopedParameter(String parameter) {
        FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(parameter);
    }

    public static Object getSessionScopedParameter(String parameter) {
        Assert.notNull(parameter);
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(parameter);
    }

    public static void putParameterToViewScope(String name, Object o) {
        FacesContext.getCurrentInstance().getViewRoot().getViewMap().put(name, o);
    }

    public static Object getFlashedObject(String name) {
        return FacesContext.getCurrentInstance().getExternalContext().getFlash().get(name);
    }

    public static void putObjectToFlash(String name, Object o) {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put(name, o);
    }

    public static String getMessage(String bundleKey, String messageKey) {
        ResourceBundle bundle =
                FacesContext.getCurrentInstance().getApplication()
                        .getResourceBundle(FacesContext.getCurrentInstance(), bundleKey);
        return new String(bundle.getString(messageKey).getBytes(Charset.defaultCharset()));
    }

    public static void addMessage(String message) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage(message);
        facesContext.addMessage(null, facesMessage);
    }

    public static void addErrorMessage(String message) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, "Ошибка!");
        facesContext.addMessage(null, facesMessage);
    }

    public static <T> T getBean(String beanName) {
        Assert.notNull(beanName);

        return getValue("#{" + beanName + "}");
    }

    public static <T> T getBean(Class<T> beanClass) {
        Assert.notNull(beanClass);

        ServletContext servletContext =
                (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        return springContext.getBean(beanClass);
    }

    @SuppressWarnings("unchecked")
    private static <T> T getValue(String expression) {
        FacesContext context = FacesContext.getCurrentInstance();
        return (T) context.getApplication().evaluateExpressionGet(context, expression, Object.class);
    }
}
