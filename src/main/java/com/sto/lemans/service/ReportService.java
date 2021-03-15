package com.sto.lemans.service;

import com.sto.lemans.dao.ClientDAO;
import com.sto.lemans.entity.Client;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private ClientDAO clientDAO;

    private final String path = "C:\\STO\\reports";

    @Transactional
    public synchronized void exportReport(String reportFormat) throws JRException, FileNotFoundException {
        List<Client> clients = clientDAO.getAllClients();
        File file = ResourceUtils.getFile("classpath:report.jrxml");

        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(clients);
        Map<String, Object> parameters = new HashMap<>();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint,
                    path + "\\clients.pdf");
        }
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint,
                    path + "\\clients.html");
        }
    }

    public String getPath() {
        return "Reports generated in path: " + path;
    }
}
