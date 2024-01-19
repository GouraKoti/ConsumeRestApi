package com.molcon.ConsumeRestApi.controller;

import com.molcon.ConsumeRestApi.model.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/user")
public class userController {

    @Autowired
    private RestTemplate restTemplate;
        @GetMapping("/restUser")
        public ResponseEntity<?> getUsers() {

                String uri="http://192.168.6.66:9989/mcntl-support-api/api/v1/getUsers?days=1";

                PageResponse result = restTemplate.getForObject(uri, PageResponse.class);
                    return new ResponseEntity<>(result, HttpStatus.OK);

        }


}
