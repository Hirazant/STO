package com.sto.lemans.controller;

import com.sto.lemans.entity.Master;
import com.sto.lemans.entity.Client;
import com.sto.lemans.entity.CarSession;
import com.sto.lemans.exceptions.MasterNumberException;
import com.sto.lemans.exceptions.SessionException;
import com.sto.lemans.service.MasterService;
import com.sto.lemans.service.ClientService;
import com.sto.lemans.service.CarSessionService;
import com.sto.lemans.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private MasterService masterService;
    @Autowired
    private CarSessionService carSessionService;
    @Autowired
    private ReportService reportService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping("/")
    public String showMenu() {
        return "menu";
    }

    @RequestMapping("/report")
    public String generateReport(Model model) {

        Runnable report1 = () -> {
            try {
                reportService.exportReport("pdf");
            } catch (JRException | FileNotFoundException e) {
                e.printStackTrace();
            }
        };

        Runnable report2 = () -> {
            try {
                reportService.exportReport("html");
            } catch (JRException | FileNotFoundException e) {
                e.printStackTrace();
            }
        };

        Thread thread1 = new Thread(report1);
        Thread thread2 = new Thread(report2);
        thread1.start();
        thread2.start();

        final String path = reportService.getPath();
        model.addAttribute("path", path);

        return "report";
    }

    @RequestMapping("/showAllClients")
    public String showAllClients(Model model) {

        List<Client> allClients = clientService.getAllClients();
        model.addAttribute("allClients", allClients);

        return "all-clients";
    }

    @RequestMapping("/addNewClient")
    public String addNewClient(Model model) {

        Client client = new Client();
        model.addAttribute("client", client);

        return "client-info";
    }

    @RequestMapping("/saveClient")
    public String saveClient(@Valid @ModelAttribute("client") Client client,
                            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "master-info";
        } else {
            clientService.saveClient(client);
            return "redirect:/showAllClients";
        }
    }

    @RequestMapping("/updateClient")
    public String updateClient(@RequestParam("clientId") int id, Model model) {

        Client client = clientService.getClient(id);
        model.addAttribute("client", client);

        return "client-info";
    }

    @RequestMapping("/deleteClient")
    public String deleteClient(@RequestParam("clientId") int id) {

        clientService.deleteClient(id);

        return "redirect:/showAllClients";
    }

    @RequestMapping("/showAllMasters")
    public String showAllMasters(Model model) {

        List<Master> allMasters = masterService.getAllMasters();
        model.addAttribute("allMasters", allMasters);

        return "all-masters";
    }

    @RequestMapping("/addNewMaster")
    public String addNewMaster(Model model) {

        Master master = new Master();
        model.addAttribute("master", master);

        return "master-info";
    }

    @RequestMapping("/saveMaster")
    public String saveMaster(@Valid @ModelAttribute("master") Master master,
                           BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "master-info";
        } else {
            try {
                masterService.saveMaster(master);
            } catch (MasterNumberException e) {
                model.addAttribute("error", e);
                return "error";
            }
            return "redirect:/showAllMasters";
        }
    }

    @RequestMapping("/updateMaster")
    public String updateMaster(@RequestParam("masterId") int id, Model model) {

        Master master = masterService.getMaster(id);
        model.addAttribute("master", master);

        return "master-info";
    }

    @RequestMapping("/deleteMaster")
    public String deleteMaster(@RequestParam("masterId") int id) {

        masterService.deleteMaster(id);

        return "redirect:/showAllMasters";
    }

    @RequestMapping("/showAllSessions")
    public String showAllSessions(Model model) {

        List<CarSession> allSessions = carSessionService.getAllSessions();
        model.addAttribute("allSessions", allSessions);

        return "all-sessions";
    }

    @RequestMapping("/showReport")
    public String showReport(Model model) {

        int count = carSessionService.count();
        model.addAttribute("count", count);

        return "show-report";
    }

    @RequestMapping("/addNewSession")
    public String addNewSession(Model model) {

        CarSession session = new CarSession();
        model.addAttribute("session", session);
        List<Client> allClients = clientService.getAllClients();
        model.addAttribute("allClients", allClients);
        List<Master> allMasters = masterService.getAllMasters();
        model.addAttribute("allMasters", allMasters);

        return "session-info";
    }

    @RequestMapping("/saveSession")
    public String saveSession(@Valid @ModelAttribute("session") CarSession session,
                           BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            List<Client> allClients = clientService.getAllClients();
            model.addAttribute("allClients", allClients);
            List<Master> allMasters = masterService.getAllMasters();
            model.addAttribute("allMasters", allMasters);
            return "session-info";
        } else {
            try {
                session.setMaster(masterService.getMaster(session.getMasterId()));
                session.setClient(clientService.getClient(session.getClientId()));
                carSessionService.saveSession(session);
            } catch (SessionException e) {
                model.addAttribute("error", e);
                return "error";
            }
            return "redirect:/showAllSessions";
        }
    }

    @RequestMapping("/updateSession")
    public String updateSession(@RequestParam("sessionId") int id, Model model) {

        CarSession session = carSessionService.getSession(id);
        model.addAttribute("session", session);

        List<Client> allClients = clientService.getAllClients();
        model.addAttribute("allClients", allClients);
        List<Master> allMasters = masterService.getAllMasters();
        model.addAttribute("allMasters", allMasters);

        return "session-info";
    }

    @RequestMapping("/deleteSession")
    public String deleteSession(@RequestParam("sessionId") int id) {

        carSessionService.deleteSession(id);

        return "redirect:/showAllSessions";
    }
}