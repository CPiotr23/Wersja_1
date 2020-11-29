package com.example.Magazine;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Start {
    private final String UPLOAD_DIR = "C:/Users/Crump/Desktop/JavaProjekty/Magazine/uploads";
    private List<Obiekt> listaLaptopow;
    private int zmienna;
    public Start() {
        Obiekt d = new Obiekt("D", "777");
        Obiekt l = new Obiekt("L", "T4");
        Obiekt h = new Obiekt("H", "G3");
        listaLaptopow = new ArrayList<>();
        listaLaptopow.add(d);
        listaLaptopow.add(l);
        listaLaptopow.add(h);
    }
    @GetMapping("/wpisz")
    public String dodawanie(Model model) {
        model.addAttribute("variables", new Variables());
        return "Dodawanie";
    }
    @GetMapping("")
    public String get(Model model) {
        model.addAttribute("lista", listaLaptopow);
        model.addAttribute("nowyLaptop", new Obiekt());
        return "Glowna";
    }
    @PostMapping("/wpisz")
    public String dodawanieObiekt(@ModelAttribute Variables variables, Obiekt next) {
        next.setMarka(variables.getB());
        next.setModel(variables.getA());
        listaLaptopow.add(next);
        return "redirect:/wpisz";
    }
    @PostMapping("")
    public String dodawaniePliku(@RequestParam("file") MultipartFile file, RedirectAttributes attributes){
        // Sprawdzanie czy plik jest pusty
        if(file.isEmpty()) {
            attributes.addFlashAttribute("wiadomosc", "Wybierz plik do wrzucenia.");
            return "redirect:/";
        }

        // ustawianie sciezki
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        // zapisywanie pliku na lokalnym systemie plików

        try {
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e){
            e.printStackTrace();
        }

        // potwierdzenie wykonania

        attributes.addFlashAttribute("wiadomosc", "Udalo ci sie dodac plik " + fileName);

        return "redirect:/";
    }
}
