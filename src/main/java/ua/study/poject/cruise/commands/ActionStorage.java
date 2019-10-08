package ua.study.poject.cruise.commands;

/**
 * ActionStorage is singletone class that stores all the commands that the user can execute,
 * depending on his role
 */
public class ActionStorage {

    public final static String SIGN_IN = "signin";
    public final static String SIGN_UP = "signup";
    public final static String LOGOUT = "logout";
    public final static String EDIT_ACCOUNT = "editaccount";
    public final static String VIEW_MY_CART = "viewcart";
    public final static String VIEW_CRUISE = "viewcruise";
    public final static String VIEW_EXCURSION = "viewexcursion";
    public final static String VIEW_MY_CRUISES = "viewmycruises";
    public final static String VIEW_PORT = "viewport";
    public final static String DELETE_ALL = "deletefromcart/all";

    public final static String START_PAGE = "startpage";
    public final static String CHANGE_LANGUAGE = "changelanguage";
    public final static String PAY = "pay";
    public final static String DELETE_FROM_CART_CRUISE = "deletefromcart/cruise";
    public final static String DELETE_FROM_CART_EXCURSION = "deletefromcart/excursion";
    public final static String ADD_TO_CART_EXCURSION = "addtocart/excursion";
    public final static String ADD_TO_CART_CRUISE = "addtocart/cruise";
    public final static String CREATE_CRUISE = "createcruise";
    public final static String CREATE_PORT = "createport";
    public final static String CREATE_SHIP = "createship";
    public final static String CREATE_EXCURSION = "createexcursion";
    public final static String CHANGE_USER_ROLE = "changeuserrole";
    public final static String ADD_BONUSES = "addbonuses";
    public final static String BONUSE = "bonuse";
    public final static String SELECTED_CRUISE = "selectedcruise";
    public final static String DELETE_BONUSES = "deletebonuses";
    public final static String ADD_SHIP_SERVICES_TO_SYSTEM = "addshipservicestosystem";
    public final static String ADD_SHIP_SERVICES_TO_SHIP = "addshipservicetoship";
    public final static String DELETE_SHIP_SERVICES_FROM_SHIP = "deleteshipservicefromship";
    public final static String MY_ACCOUNT = "myaccount";
}
