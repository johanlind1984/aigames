package com.lindbros.aigames.rest;

import com.lindbros.aigames.service.IveNeverService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ive-never")
public class IveNeverController {

    private final IveNeverService iveNeverService;

    @GetMapping("/get")
    public String get(@RequestBody IveNeverBody body) {
        return iveNeverService.sendToChatGpt(body.message, body.category);
    }
    
    public record IveNeverBody(String message, String category) {}
}