package com.emissystem.www.home.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//CHART DAO KEYS (UID AND DATE) ARE USED AS FOREIGN KEYS FOR A DIAGNOSIS TABLE AND A PRESCRIPTION TABLE
public class ChartDao {
    private List<ChartEntry> chartEntires = Arrays.asList(
        new ChartEntry(1003,"2018-11-13","don't forget captain",80.00,95.00,150.00),
        new ChartEntry(1005,"2018-11-15","pollen allergies",90.00,75.00,174.00),
        new ChartEntry(1003,"2018-11-15","healthy? serious weight loss",95.00,60.00,158.00),
        new ChartEntry(1008,"2018-11-16","healthy",100.00,81.00,155.00),
        new ChartEntry(1003,"2018-11-17","keep an eye on medicine reaction",110.00,56.00,160.00),
        new ChartEntry(1004,"2018-11-17","maybe give painkillers",110.00,60.00,150.00),
        new ChartEntry(1007,"2018-11-17","healthy",115.00,66.00,190.00),
        new ChartEntry(1009,"2018-12-07","remind more frequent checkups",120.00,63.00,171.00),
        new ChartEntry(1003,"2018-12-09","I am scared",160.00,40.00,200.00),
        new ChartEntry(1005,"2018-12-13","keep an eye on blood pressure",87.00,75.00,174.00)
                                                         );
    public List<ChartEntry> getAllEntriesByUID(int UID) {
        return chartEntires.stream().filter(b -> (b.getUID() == UID)).collect(Collectors.toList());
    }
}
