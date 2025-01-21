package com.lindbros.aigames.rest;

import com.lindbros.aigames.service.IveNeverService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/ive-never")
public class IveNeverController {

    @Autowired
    private IveNeverService iveNeverService;

    @GetMapping("/get")
    public String get(@RequestBody IveNeverBody body) {
        return iveNeverService.sendToChatGpt(body.message, body.category);
    }
    
    public record IveNeverBody(String message, String category) {}
}