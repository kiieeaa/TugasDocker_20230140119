package com.tugas.deploy.controller;

import com.tugas.deploy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    // List untuk menyimpan data sementara (temporary) [cite: 74]
    private static List<User> daftarMahasiswa = new ArrayList<>();

    @GetMapping("/")
    public String loginPage() {
        return "login"; // Mengarah ke login.html [cite: 56]
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username, @RequestParam String password) {
        // Logika login: admin & NIM masing-masing [cite: 70]
        if ("admin".equals(username) && "20230140119".equals(password)) {
            return "redirect:/home";
        }
        return "redirect:/?error";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("mahasiswaList", daftarMahasiswa);
        return "home"; // Mengarah ke home.html [cite: 55]
    }

    @GetMapping("/form")
    public String formPage(Model model) {
        model.addAttribute("user", new User());
        return "form"; // Mengarah ke form.html [cite: 54]
    }

    @PostMapping("/save")
    public String saveData(@ModelAttribute User user) {
        daftarMahasiswa.add(user);
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout() {
        daftarMahasiswa.clear(); // Opsional: hapus data saat logout
        return "redirect:/";
    }
}