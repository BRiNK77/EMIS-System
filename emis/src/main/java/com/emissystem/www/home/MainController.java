package com.emissystem.www.home;

import com.emissystem.www.home.model.ChartEntry;
import com.emissystem.www.home.model.User;
import com.emissystem.www.home.util.*;
import spark.*;
import java.util.*;
import java.util.stream.Collectors;

import static com.emissystem.www.home.EmisMain.*;

class MainController {

    static Route serveMainPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        User user = request.session().attribute("currentUser");
        if (user == null) { response.redirect(Path.Web.LOGIN); return null; }
        model.put("PRIVLEVEL", user.getPRIVLEVEL() );
        model.put("UID", user.getUID());
        model.put("NAME", user.getNAME());
        return ViewUtil.render(request, model, Path.Template.MAIN);
    };

    static Route servePatientListPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("NAMEList", userDao.getAllNames());
        model.put("UIDList", userDao.getAllUID());
        return ViewUtil.render(request, model, Path.Template.PATIENTLIST);
    };

    static Route handleAddPatient = (Request request, Response response) -> {
        int UID;
        String NAME;
        String EMAIL;
        try {
            UID = Integer.valueOf(request.queryParams("arg0"));
            NAME = request.queryParams("arg1");
            EMAIL = request.queryParams("arg2");
        }
        catch (Exception e) {
            //failed, return without adding an entry
            return serveMainPage.handle(request,response);
        }
        userDao.addEntry(new User(EMAIL, UID, NAME));
        //completed addition, return to main page
        return serveMainPage.handle(request, response);
    };

    static Route serveChartPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        String arg0 = request.queryParams("arg0");
        try {
            User patient = userDao.getUserByUID(Integer.valueOf(arg0));
            List<ChartEntry> chartEntries = chartDao.getAllEntriesByUID(patient.getUID());
            model.put("NAME", patient.getNAME());
            model.put("DATEList", chartEntries.stream().map(ChartEntry::getDATE).collect(Collectors.toList()));
            model.put("DOCTORNOTEList", chartEntries.stream().map(ChartEntry::getDOCTORNOTE).collect(Collectors.toList()));

            //ran out of time to create collection code for prescription
            List<List<String>> diagList = new ArrayList<>();
            for (ChartEntry entry : chartEntries) {
                diagList.add(Arrays.asList("Flu", "Depression"));
            }
            List<List<String>> rxList = new ArrayList<>();
            for (ChartEntry entry : chartEntries) {
                rxList.add(Arrays.asList("Ibeprofen", "HelpUsPleasenol"));
            }
            model.put("DIAGNOSEList", diagList);
            model.put("PRESCIPTIONList", rxList);
            model.put("WEIGHTList", chartEntries.stream().map(ChartEntry::getWEIGHT).collect(Collectors.toList()));
            model.put("HEIGHTList", chartEntries.stream().map(ChartEntry::getHEIGHT).collect(Collectors.toList()));
            model.put("BPList", chartEntries.stream().map(ChartEntry::getBP).collect(Collectors.toList()));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return serveMainPage.handle(request, response);
        }

        return ViewUtil.render(request, model, "/public/prescriptionPage.html");
    };

    static Route handleChartPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        //ran out of time to create UPDATE code
        //return ViewUtil.render(request, model, Path.Template.CHART);

        //temporary loop around
        return serveMainPage.handle(request, response);
    };

}
