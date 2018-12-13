package com.emissystem.www.home.util;

import com.emissystem.www.home.EmisMain;
import freemarker.template.*;
import org.eclipse.jetty.http.*;
import spark.*;
import spark.template.freemarker.*;

import java.util.*;
import static com.emissystem.www.home.util.RequestUtil.*;

public class ViewUtil {

    // Renders a template given a model and a request
    // The request is needed to check the user session for language settings
    // and to see if the user is logged in
    public static String render(Request request, Map<String, Object> model, String templatePath) {
        model.put("currentUser", getSessionCurrentUser(request));
        model.put("WebPath", Path.Web.class); // Access application URLs from templates
        return strictFreeMarkerEngine().render(new ModelAndView(model, templatePath));
    }

    public static Route notFound = (Request request, Response response) -> {
        response.status(HttpStatus.NOT_FOUND_404);
        return render(request, new HashMap<>(), Path.Template.NOT_FOUND);
    };

    private static FreeMarkerEngine strictFreeMarkerEngine() {
        FreeMarkerEngine configuredEngine = new FreeMarkerEngine();
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setClassForTemplateLoading(EmisMain.class, "/");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLogTemplateExceptions(false);

        return new FreeMarkerEngine(cfg);
    }
}
