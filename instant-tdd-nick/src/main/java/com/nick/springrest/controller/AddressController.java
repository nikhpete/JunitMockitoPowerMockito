package com.nick.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nick.springrest.service.AddressDeleter;
import com.nick.springrest.service.AddressRetriever;
import com.nick.springrest.service.AddressStorer;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressRetriever retriever;

    @Autowired
    private AddressStorer storer;

    @Autowired
    private AddressDeleter deleter;

    @RequestMapping(path = "/{who}", method = RequestMethod.GET)
    public ResponseEntity<?> getAddress(@PathVariable("who") String who) {
        String address = retriever.getAddress(who);
        if (address == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(address);
    }

    @RequestMapping(path = "/{who}", method = RequestMethod.POST, consumes = "*/*")
    public void storeAddress(@PathVariable("who") String who, @RequestBody String body) {
        storer.storeAddress(who, body);
    }

    @RequestMapping(path = "/{who}", method = RequestMethod.DELETE)
    public void deleteAddress(@PathVariable("who") String who) {
        deleter.deleteAddress(who);
    }
}
