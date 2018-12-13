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
        String userName = request.session().attribute("currentUser");
        model.put("PRIVLEVEL", userDao.getUserByUsername(userName).getPRIVLEVEL() );
        model.put("UID", userDao.getUserByUsername(userName).getUID());
        model.put("NAME", userName);
        return ViewUtil.render(request, model, Path.Template.MAIN);
    };

    static Route servePatientListPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("NAMEList", userDao.getAllNames());
        model.put("UIDList", userDao.getAllUID());
        return ViewUtil.render(request, model, Path.Template.PATIENTLIST);
    };

    static Route serveChartPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        User patient = userDao.getUserByUID(Integer.getInteger(request.queryParams("arg0")));
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
        return ViewUtil.render(request, model, Path.Template.CHART);
    };

    static Route handleChartPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        //ran out of time to create UPDATE code
        return ViewUtil.render(request, model, Path.Template.CHART);
    };

}
