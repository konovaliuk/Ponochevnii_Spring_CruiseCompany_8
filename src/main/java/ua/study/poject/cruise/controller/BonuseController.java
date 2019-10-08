package ua.study.poject.cruise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.study.poject.cruise.persistance.dao.IShipservice;
import ua.study.poject.cruise.persistance.dao.ITicketclass;
import ua.study.poject.cruise.persistance.entity.*;
import ua.study.poject.cruise.service.CruiseService;
import ua.study.poject.cruise.service.ManagerAndBonuseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ua.study.poject.cruise.persistance.entity.Ticketclass.*;

@Controller
@SessionAttributes({"addBonusesMessage", "shipserviceList", "currentuser", "cruiseListBonuse", "ticketclassList", "selectedcruise", "sticketclass", "scruise",
        "allBonusesForTicketClass1", "allBonusesForTicketClass2", "allBonusesForTicketClass3", "allBonusesForTicketClass4"})
public class BonuseController {
    @Autowired
    CruiseService cruiseService;

    @Autowired
    IShipservice shipService;

    @Autowired
    ITicketclass ticketclassImpl;

    @Autowired
    ManagerAndBonuseService managerAndBonuseService;

    @GetMapping("/bonuse")
    public String bonuseGet(Model model, @SessionAttribute User currentuser) {
        List<UserShip> userShips = managerAndBonuseService.getAllShipsByManager(currentuser);
        List<Cruise> cruiseList = new ArrayList<>();
        for (UserShip userShip : userShips) {
            cruiseList.addAll(cruiseService.getAllCruisesByShip(userShip.getShip()));     //allServicesOnShip
        }

        model.addAttribute("cruiseListBonuse", cruiseList);
        model.addAttribute("ticketclassList", managerAndBonuseService.getAllTicketclass());
        return "managebonuses";
    }

    @GetMapping("/managebonusesview")
    public String viewBonuses() {
        return "managebonuses";
    }

    @GetMapping("/selectedcruise")
    public String addBonusesGet(Model model, @RequestParam Long selectedcruise) {

        model.addAttribute("selectedcruise", selectedcruise);
        // 4. Менеджер выбирает конкретный круиз
        Optional<Cruise> cruise = cruiseService.findById(selectedcruise);
        if (!cruise.isPresent()) {
            model.addAttribute("addBonusesMessage", "message.managebonuses.errselectcruise");
            return "redirect:/managebonusesview";
        }
        // 5. Загрузить список всех сервисов на этом корабле и отправить на JSP
        model.addAttribute("shipserviceList", shipService.findAllServicesByShipId(cruise.get().getShip().getId()));


        // 6. Получить списки бонусов для каждого Ticketclass и отправить на JSP
        refreshBonusList(model, cruise.get().getId());
        model.addAttribute("scruise", cruise.get());

        return "redirect:/managebonusesview";
    }

    @PostMapping("/addbonuses")
    public String addBonusesPost(Model model,
                                 @SessionAttribute List<Ticketclass> ticketclassList,
                                 @SessionAttribute List<Shipservice> shipserviceList,
                                 @SessionAttribute Cruise scruise,
                                 @SessionAttribute List<TicketclassBonus> allBonusesForTicketClass1,
                                 @SessionAttribute List<TicketclassBonus> allBonusesForTicketClass2,
                                 @SessionAttribute List<TicketclassBonus> allBonusesForTicketClass3,
                                 @SessionAttribute List<TicketclassBonus> allBonusesForTicketClass4,
                                 @RequestParam Long selectedticketclass,
                                 @RequestParam Long selectedshipserviceid) {

        if (selectedshipserviceid == null || selectedticketclass == null) {
            model.addAttribute("addBonusesMessage", "message.managebonuses.youneedselectcruise");
            return "redirect:/managebonusesview";
        }

        // Получим объект Ticketclass по id
        Ticketclass ticketclassObj = null;
        for (Ticketclass temp : ticketclassList) {
            if (selectedticketclass.equals(temp.getId())) {
                ticketclassObj = temp;
                model.addAttribute("sticketclass", temp);
                break;
            }
        }

        // Попытаемся найти в соответсвующем списке такой бонус, если он есть - новый добавлять не будем
        List<TicketclassBonus> listForFinding = new ArrayList<>();

        switch (ticketclassObj.getTicketclassName()) {
            case TICKET_CLASS_FIRST:
                listForFinding = allBonusesForTicketClass1;
                break;
            case TICKET_CLASS_SECOND:
                listForFinding = allBonusesForTicketClass2;
                break;
            case TICKET_CLASS_THIRD:
                listForFinding = allBonusesForTicketClass3;
                break;
            case TICKET_CLASS_FOURTH:
                listForFinding = allBonusesForTicketClass4;
        }

        for (TicketclassBonus ticketclassBonus : listForFinding) {
            if (ticketclassBonus.getShipService().getId().equals(selectedshipserviceid)) {
                model.addAttribute("addBonusesMessage", "message.managebonuses.thereisbonus");
                return "redirect:/managebonusesview";
            }
        }


        Shipservice shipservice = null;
        for (Shipservice temp : shipserviceList) {
            if (temp.getId().equals(selectedshipserviceid)) {
                shipservice = temp;
                break;
            }
        }

        managerAndBonuseService.addBonus(ticketclassObj, shipservice, scruise);

        // обновляем список всех бонусов на этом корабле
        refreshBonusList(model, scruise.getId());

        return "redirect:/managebonusesview";
    }


    @PostMapping("/deletebonuses")
    public String deleteBonusesPost(Model model, @RequestParam List<Long> bonuses, @SessionAttribute Cruise scruise) {

        // получаем bonuses - это List строк (один из 4) в которых записаны ticketclassBonusId
        managerAndBonuseService.deleteBonuses(bonuses);

        // обновляем список всех бонусов на этом корабле
        refreshBonusList(model, scruise.getId());
        return "redirect:/managebonusesview";
    }


    private void refreshBonusList(Model model, Long cruiseId) {
        model.addAttribute("allBonusesForTicketClass1",
                managerAndBonuseService.getAllBonusesByCruiseIdTicketclassName(cruiseId, TICKET_CLASS_FIRST));

        model.addAttribute("allBonusesForTicketClass2",
                managerAndBonuseService.getAllBonusesByCruiseIdTicketclassName(cruiseId, TICKET_CLASS_SECOND));

        model.addAttribute("allBonusesForTicketClass3",
                managerAndBonuseService.getAllBonusesByCruiseIdTicketclassName(cruiseId, TICKET_CLASS_THIRD));

        model.addAttribute("allBonusesForTicketClass4",
                managerAndBonuseService.getAllBonusesByCruiseIdTicketclassName(cruiseId, TICKET_CLASS_FOURTH));
    }
}
