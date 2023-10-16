package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AddressBookController {
    @Autowired
    private AddressBookRepository addressBookRepository;

    @RequestMapping("/book/create")
    public String createBook(Model model) {
        AddressBook book = new AddressBook();
        addressBookRepository.save(book);
        model.addAttribute("id", book.getId());
        return "bookcreated";
    }

    @RequestMapping("/buddy/add")
    public String addBuddy(@RequestParam(value = "name") String name, @RequestParam(value = "address")
    String address, @RequestParam(value = "number") String number, @RequestParam(value = "book") String book, Model model) {
        long bookLong = Long.parseLong(book);
        AddressBook book1 = addressBookRepository.findById(bookLong);
        BuddyInfo buddy = new BuddyInfo(name, address, number);
        book1.addBuddy(buddy);
        addressBookRepository.save(book1);
        model.addAttribute("buddy", buddy.toString());

        return "addbuddy";

    }


    @RequestMapping("/buddy/remove")
    public String removeBuddy(@RequestParam(value = "name") String name, @RequestParam(value = "address")
    String address, @RequestParam(value = "number") String number,@RequestParam(value = "book") String book, Model model) {
        long bookLong = Long.parseLong(book);
        AddressBook book1 = addressBookRepository.findById(bookLong);
        BuddyInfo buddy = new BuddyInfo(name, address, number);
        book1.removeBuddy(buddy);
        addressBookRepository.save(book1);
        model.addAttribute("buddy", buddy.toString());

        return "removebuddy";

    }

    @RequestMapping("/book/view")
    public String viewBook(@RequestParam(value = "book") String book, Model model) {
        long bookLong = Long.parseLong(book);
        AddressBook book1 = addressBookRepository.findById(bookLong);
        model.addAttribute("book", book1);
        return "book";
    }

    @RequestMapping("/book/viewtest")
    @ResponseBody
    public AddressBook viewBookTest(@RequestParam(value = "book") String book, Model model) {
        long bookLong = Long.parseLong(book);
        AddressBook book1 = addressBookRepository.findById(bookLong);
        model.addAttribute("book", book1);
        return book1;
    }

    @RequestMapping("/")
    public String home(Model model) {
        return "home";
    }
}
