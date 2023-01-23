package com.example.TP3.controller;

import com.example.TP3.model.APIAnswer;
import com.example.TP3.model.APIMeteo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Controller
public class MeteoController {
    @PostMapping("/meteo")
    public String meteo(@RequestBody String address, Model model) throws URISyntaxException {
        URI uri = new URI("https://api-adresse.data.gouv.fr/search/?q=" + address.replace("address=", ""));
        RestTemplate restTemplate = new RestTemplate();
        APIAnswer answer = restTemplate.getForObject(uri, APIAnswer.class);

        uri = new URI("https://api.meteo-concept.com/api/forecast/daily/0?token=db9abfc1b9e81116c7b48e84ec4835e838652953ac33eb1f5cb632e555485ee5&latlng=" +
                answer.features().get(0).geometry().coordinates().get(1) + "," + answer.features().get(0).geometry().coordinates().get(0));
        RestTemplate restTemplate1 = new RestTemplate();
        APIMeteo meteo = restTemplate1.getForObject(uri, APIMeteo.class);

        //model.addAttribute("uri", uri);
        model.addAttribute("tmax", meteo.forecast().tmax());
        model.addAttribute("tmin", meteo.forecast().tmin());
        return "meteo";
    }
}
