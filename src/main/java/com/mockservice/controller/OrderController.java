package com.mockservice.controller;

import com.mockservice.util.JsonFileReaderUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class OrderController {

    @RequestMapping("/orders")
    @ResponseBody
    public String getOrders() {
        try {
            return JsonFileReaderUtil.readFile("Order");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "[]";
    }
    
    @RequestMapping("/vehicles")
    @ResponseBody
    public String getVehicleList(){
    	try {
			return JsonFileReaderUtil.readFile("Vehicle");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return "[]";
    }

}
