package com.emissystem.www.home;

import com.emissystem.www.home.util.*;
import spark.*;
import java.util.*;
import static com.emissystem.www.home.EmisMain.*;

public class IndexController {
    public static Route serveIndexPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("users", userDao.getAllNames());
        return ViewUtil.render(request, model, Path.Template.INDEX);
    };
}