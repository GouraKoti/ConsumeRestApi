package com.molcon.ConsumeRestApi.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.molcon.ConsumeRestApi.model.MongoHenkel;
import com.molcon.ConsumeRestApi.model.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@PropertySource("classpath:application.properties")
@RequestMapping(value = "/user")
public class userController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${status}")
    private String status;

    String mongoUri = "http://localhost:8080/api/henkel/";

    @GetMapping("/extUrl")
    public ResponseEntity<?> getUsers() {
        String uri = "http://your_external_url";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "Basic YWRtaW46MmsyMzExMDNfTUNQTA==");
        httpHeaders.set("Cookie", "JSESSIONID=B7D7FB520C6CE7A1B743649CB7879CA9");

        ResponseEntity<PageResponse> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(httpHeaders), PageResponse.class);
        return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }


    @GetMapping("/status")
    public ResponseEntity<?> getStatus() {
        return new ResponseEntity<>("Status: " + status, HttpStatus.OK);
    }

    @GetMapping("/getChemicals")
    public ResponseEntity<?> getChemicals() {
        String uri = mongoUri + "getFromMongo";

        ResponseEntity<List> responseEntity = restTemplate.getForEntity(uri, List.class);
        return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }

    @PostMapping("/postChemical")
    public ResponseEntity<?> postChemical(@RequestBody MongoHenkel mongoHenkel) {
        String uri = mongoUri + "postIntoMongo";

        ResponseEntity<MongoHenkel> responseEntity = restTemplate.postForEntity(uri, mongoHenkel, MongoHenkel.class);
        return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }

    @PutMapping("/putChemical/{mcid}")
    public ResponseEntity<?> putChemical(@RequestBody MongoHenkel mongoHenkel, @PathVariable String mcid) {
        String uri = mongoUri + "updateIntoMongo/"+mcid;
         restTemplate.put(uri, mongoHenkel);
         return new ResponseEntity<>("Updated Chemical mcid "+ mcid, HttpStatus.OK);
    }

   /* @PatchMapping("/patchChemical/{mcid}/{commonName}")
    public ResponseEntity<?> patchChemical(@PathVariable String mcid, @PathVariable String commonName){
        String uri = mongoUri + "updateIntoMongo/"+ mcid + "/" + commonName;

        MongoHenkel temp = new MongoHenkel();
        temp.setCommonName(commonName);
        HttpEntity<MongoHenkel> requestEntity = new HttpEntity<>(temp);
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

        restTemplate.exchange(uri, HttpMethod.PATCH, requestEntity, MongoHenkel.class);
        return new ResponseEntity<>("Updated Chemical mcid "+ mcid, HttpStatus.OK);
    }
*/
    @DeleteMapping("/deleteChemical/{mcid}")
    public ResponseEntity<?> deleteChemical(@PathVariable String mcid){
        String uri = mongoUri + "deleteFromMongo/"+mcid;
        restTemplate.delete(uri);
        return new ResponseEntity<>("Deleted Chemical mcid "+ mcid, HttpStatus.OK);
    }



}
