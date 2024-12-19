package com.aifarm.rest_api.controller;
import com.aifarm.rest_api.model.CloudVendor;
import com.aifarm.rest_api.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudVendor")

public class CloudVendorController
{

    CloudVendorService cloudVendorService;


    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    //Read Specific Cloud Vendor detail from DB
    @GetMapping("{VendorID}")
    public CloudVendor getCloudVendorDetail(@PathVariable("VendorID") String VendorID){
        return cloudVendorService.getCloudVendor(VendorID);
    }


    //Read All Cloud Vendor detail from DB
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetail(){
        return cloudVendorService.getAllCloudVendor();
    }



    @PostMapping()
    public String createCloudVendorDetail(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor Created Successful";
    }

    @PutMapping
    public String updateCloudVendorDetail(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor updated Successful";
    }

    @DeleteMapping("{vendorID}")
    public String deleteCloudVendorDetail(@PathVariable("VendorID") String VendorID){
        cloudVendorService.deleteCloudVendor(VendorID);
        return "Cloud Vendor deleted Successful";
    }

}
